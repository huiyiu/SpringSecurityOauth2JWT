package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	static Map<String,User> map;
	static {
		map = new HashMap<>();
		map.put("zhangSan", new User("1", "zhangSan", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu"));
		map.put("liSi", new User("2", "liSi", "$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK"));
		map.put("WangWu", new User("3", "WangWu", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu"));
	}

	public User findByUsername(String username) {
		
		return (User) map.get(username);
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		map.forEach((k,v)->{
			list.add(v);
		});
		return list;
	}

	public User save(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setPassword( new BCryptPasswordEncoder().encode(user.getPassword()));
		map.put(user.getUsername(), user);
		return user;
	}

}
