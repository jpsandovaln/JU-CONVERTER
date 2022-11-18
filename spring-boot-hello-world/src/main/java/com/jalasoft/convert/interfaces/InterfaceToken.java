package com.jalasoft.convert.interfaces;

import com.jalasoft.convert.model.mysqlmodel.TokenDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceToken extends CrudRepository<TokenDB, Integer> {
}
