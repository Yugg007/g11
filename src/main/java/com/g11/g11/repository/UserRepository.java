package com.g11.g11.repository;

import org.springframework.data.repository.CrudRepository;

import com.g11.g11.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByusername(String username);

}
