package Odontologo.com.Empresa.dao;

import java.util.List;

public interface IDao<T> {
    T save(T t);
    List<T> findAll();


}