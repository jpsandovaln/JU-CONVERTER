package com.jalasoft.convert.model.mysqlmodel;
import javax.persistence.*;

@Entity
@Table(name = "token")
public class TokenDB {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String token;
    private int uses;

    public TokenDB(){

    }

    public TokenDB(Integer uses){
        this.uses = uses;
    }
    public TokenDB(String token, Integer uses) {
        this.token = token;
        this.uses = uses;
    }

    public TokenDB(int id, String token, Integer uses) {
        this.id = id;
        this.token = token;
        this.uses = uses;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String lastname) {
        this.token = token;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
