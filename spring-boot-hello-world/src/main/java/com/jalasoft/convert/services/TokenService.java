package com.jalasoft.convert.services;

import com.jalasoft.convert.interfaces.InterfaceToken;
import com.jalasoft.convert.interfaces.InterfaceTokenService;
import com.jalasoft.convert.model.mysqlmodel.TokenDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TokenService implements InterfaceTokenService {
    @Autowired
    private InterfaceToken interfaceToken;
    @Override
    public List<TokenDB> getList() {
        return (List<TokenDB>) interfaceToken.findAll();
    }

    @Override
    public TokenDB updateUser(int id) {
        Optional<TokenDB> tokens = interfaceToken.findById(id);
        TokenDB intialToken = tokens.stream().findFirst().get();
        intialToken.setUses(intialToken.getUses() - 1);
        TokenDB finalToken = interfaceToken.save(intialToken);
        return finalToken;
    }

    @Override
    public TokenDB save(TokenDB t) {
        TokenDB token = interfaceToken.save(t);
        return token;
    }

    @Override
    public void delete(int id) {
        interfaceToken.deleteById(id);
    }
}
