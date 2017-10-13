package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;


public interface IBaseDAO<T, PK extends Serializable> {
    T create(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
    List<T> readAll();
    List<T> readAllByDeleteFlag();
}
