package com.gmalheiro.java_cars_jpa.repository;

import java.util.List;

public interface BaseRepository<T> {
    T save (T entity);
    T findById(Long id);
    List<T> findAll();
    void delete(T entity);
    T merge(T entity);
}
