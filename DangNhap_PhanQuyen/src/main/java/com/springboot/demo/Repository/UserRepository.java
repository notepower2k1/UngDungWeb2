package com.springboot.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.Model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
    User findByEmail(String email);
}
