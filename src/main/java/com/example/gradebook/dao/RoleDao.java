package com.example.gradebook.dao;


import com.example.gradebook.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
