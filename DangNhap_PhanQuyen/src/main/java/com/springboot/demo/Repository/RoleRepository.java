package com.springboot.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.Model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}