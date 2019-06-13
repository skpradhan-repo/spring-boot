/**
 * 
 */
package com.pt.room.booking.main.entity;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author SAMARESH
 *
 */
@JsonFilter("DynamicUserFilter")
public class DynamicUserFilterBean {
	int uid;
	String username;
	String dob;

	public DynamicUserFilterBean(int id, String username, String dob) {
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
