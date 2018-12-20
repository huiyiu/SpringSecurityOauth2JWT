package com.example.demo;

import java.util.List;



public interface UserService {

	List<User> findAll();

	User save(User user);

	void delete(Long id);

}
