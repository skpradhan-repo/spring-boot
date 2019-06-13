/**
 * 
 */
package com.pt.room.booking.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.room.booking.main.entity.User;
import com.pt.room.booking.main.exception.UserNotFoundException;
import com.pt.room.booking.main.repository.UserRepoSitoryImpl;
import com.pt.room.booking.main.repository.UserRepository;

/**
 * @author SAMARESH
 *
 */
@Service
public class JPAUserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findOne(int id) {
		Optional<User> user = repository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("ID " + id);
		}
		return user.get();
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public void deleteById(int id) {
		 repository.deleteById(id);
	}

}
