package com.jalasoft.convert.interfaces;

import com.jalasoft.convert.model.mysqlmodel.TokenDB;

import java.util.List;
import java.util.Optional;

public interface InterfaceTokenService {
    public List<TokenDB>getList();
    public TokenDB updateUser(int id);
    public TokenDB save(TokenDB t);
    public void delete(int id);
}
