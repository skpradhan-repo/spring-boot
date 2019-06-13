/**
 * 
 */
package com.pt.room.booking.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.room.booking.main.entity.User;
import com.pt.room.booking.main.repository.UserRepoSitoryImpl;

/**
 * @author SAMARESH
 *
 */
@Service
public class UserService {
	@Autowired
	UserRepoSitoryImpl repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findOne(int id) {
		return repository.findOne(id);
	}

	public User saveUser(User user) {
		return repository.saveUser(user);
	}

	public User deleteById(int id) {
		return repository.deleteById(id);
	}
}
