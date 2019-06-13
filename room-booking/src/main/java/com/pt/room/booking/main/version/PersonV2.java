/**
 * 
 */
package com.pt.room.booking.main.version;

import com.pt.room.booking.main.entity.Name;

/**
 * @author SAMARESH
 *
 */
public class PersonV2 {
	private Name name;

	public PersonV2() {
		super();
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
