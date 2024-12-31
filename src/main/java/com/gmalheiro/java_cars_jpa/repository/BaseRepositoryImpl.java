package com.gmalheiro.java_cars_jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseRepositoryImpl <T> implements BaseRepository<T> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> entityType;

    public BaseRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    public BaseRepositoryImpl() {}


    @Override
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public T findById(Long id) {
        return em.find(entityType,id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType).getResultList();
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public T merge(T entity) {
        return em.merge(entity);
    }
}
