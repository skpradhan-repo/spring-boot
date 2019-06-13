/**
 * 
 */
package com.pt.room.booking.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SAMARESH
 *
 */
@JsonIgnoreProperties(value = {"uid"}) //Known as Static Filtering
public class UserFilterBean {
	// @JsonIgnore //Known as Static Filtering
	int uid;
	String username;
	String dob;

	public UserFilterBean(int id, String username, String dob) {
		this.uid = id;
		this.username = username;
		this.dob = dob;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
