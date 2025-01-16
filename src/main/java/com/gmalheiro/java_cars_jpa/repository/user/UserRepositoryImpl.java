package com.gmalheiro.java_cars_jpa.repository.user;

import com.gmalheiro.java_cars_jpa.entity.User;
import com.gmalheiro.java_cars_jpa.repository.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository  {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public User save(User entity) {
        if (Objects.isNull(findByName(entity.getName()))) {
            entity.setAddress(entity.getAddress());
            entity.getAddress().setUser(entity);
            entity.setCars(entity.getCars());
            entity.getCars().forEach(c -> c.setUser(entity));
            em.persist(entity);
            return entity;
        }else{
            return merge(entity);
        }
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class,id);
    }

    @Override
    public List<User> findAll() {
        Query namedQuery = em.createNamedQuery("TbUser.findAllUsers");
        return  namedQuery.getResultList();
    }

    @Override
    public void delete(User entity) {
        em.remove(entity);
    }

    @Override
    public User merge(User entity) {
        return em.merge(entity);
    }

    @Override
    public User findByName(String name) {
        Query namedQuery = em.createNamedQuery("TbUser.findByUserName");
        namedQuery.setParameter("name",name);
        try {
           return (User) namedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
