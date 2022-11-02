package com.jalasoft.convert.middleware.token;

import com.jalasoft.convert.common.logger.At18Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
public class GenerateToken {
    private static final Logger LOG = new At18Logger().getLogger();

    @GetMapping("/getToken")
    public StringBuilder generateToken() throws IOException {
        String Path = System.getProperty("user.dir") + "\\spring-boot-hello-world\\src\\main\\java\\com\\jalasoft\\convert\\middleware\\token\\token.txt";
        System.out.println(new File("").getAbsolutePath());
        System.out.println(new File(""));
        File myObj = new File(Path);
        Scanner myReader = new Scanner(myObj);
        StringBuilder token = new StringBuilder();
        StringBuilder reference = new StringBuilder();
        if (myReader.hasNextLine()) {
                LOG.info("There is a pending token to be used");
                token.append(myReader.nextLine());
                String tokenNumberReference = String.format("Active token with %s uses, the token is: ", myReader.nextLine());
                reference.append(tokenNumberReference).append(token);
                return reference;
        } else {
                FileWriter fw = new FileWriter(Path, false);
                Supplier<String> tokenSupplier = () -> {
                    long currentTimeInMilisecond = Instant.now().toEpochMilli();
                    return token.append(currentTimeInMilisecond).append("-")
                            .append(UUID.randomUUID()).toString();
                };
                fw.write(tokenSupplier.get());
                fw.write(System.getProperty( "line.separator" ));
                fw.write("5");
                fw.close();
        }
        myReader.close();
        reference.append("The new token is: ").append(token);
        return reference;
    }
}
