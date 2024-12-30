package com.gmalheiro.java_cars_jpa.repository.user;

import com.gmalheiro.java_cars_jpa.entity.User;
import com.gmalheiro.java_cars_jpa.repository.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository  {

    public UserRepositoryImpl() {
        super(User.class);
    }
}
