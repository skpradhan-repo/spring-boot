/**
 * 
 */
package com.pt.room.booking.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt.room.booking.main.entity.User;

/**
 * @author SAMARESH
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
