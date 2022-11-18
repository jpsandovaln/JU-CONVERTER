package com.jalasoft.convert.middleware.token;

import com.jalasoft.convert.model.mysqlmodel.TokenDB;
import com.jalasoft.convert.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@RestController
public class GenerateTokenMySQL {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/listTokensSQL")
    public ResponseEntity<List<TokenDB>> listTokens(Model model){
        try {
            List<TokenDB> tokens = new ArrayList<TokenDB>();
            tokenService.getList().forEach(tokens::add);
            System.out.println(tokens.get(0).getToken());
            model.addAttribute("tokens", tokens);

        if (tokens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tokens, HttpStatus.OK);

        } catch (Exception exception){
            throw new RuntimeException("There are no tokens on the Database");
        }
    }

    @GetMapping("/getTokenSQL")
    public ResponseEntity<TokenDB> getToken(Model model){
        try {
            StringBuilder token = new StringBuilder();
            Supplier<String> tokenSupplier = () -> {
                long currentTimeInMilisecond = Instant.now().toEpochMilli();
                return token.append(currentTimeInMilisecond).append("-")
                        .append(UUID.randomUUID()).toString();
            };
            TokenDB tokenDB = new TokenDB(tokenSupplier.get(), 5);
            TokenDB _tokenDB = tokenService.save(tokenDB);
            model.addAttribute("token", _tokenDB);
            return new ResponseEntity<>(_tokenDB, HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Token could not be created");
        }
    }

    @GetMapping("/deleteToken/{id}")
    public ResponseEntity<String> deleteToken(Model model, @PathVariable("id") int id){
        try {
            tokenService.delete(id);
            return new ResponseEntity<>("Token deleted correctly", HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException("Token could not be deleted from the Database");
        }
    }

    @GetMapping("/updateToken/{id}")
    public ResponseEntity<TokenDB> findToken(Model model, @PathVariable("id") int id){
        try {
            TokenDB tokenByID = tokenService.updateUser(id);
            model.addAttribute("token", tokenByID);
            return new ResponseEntity<>(tokenByID, HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Token could not be updated");
        }
    }



}
