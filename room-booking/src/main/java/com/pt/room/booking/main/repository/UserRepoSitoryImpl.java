/**
 * 
 */
package com.pt.room.booking.main.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pt.room.booking.main.entity.User;

/**
 * @author SAMARESH
 *
 */
@Repository
public class UserRepoSitoryImpl {
	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1, "Samaresh", new Date().toString()));
		users.add(new User(2, "Bharat", new Date().toString()));
	}

	public List<User> findAll() {
		return users;
	}

	public User saveUser(User user) {
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (int i = 0; i < users.size(); i++) {
			User temp = users.get(i);
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		for (User user : users) {
			if (id == user.getId()) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}
}
