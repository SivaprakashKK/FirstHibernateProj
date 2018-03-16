package org.siva.learning.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
/*
	@ManyToOne
	private UserDetailsColl user;

*/	
	@ManyToMany(mappedBy="vehicles")
	private Collection<UserDetailsColl> userList = new ArrayList<>();
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	/*public UserDetailsColl getUser() {
		return user;
	}

	public void setUser(UserDetailsColl user) {
		this.user = user;
	}
*/
	public Collection<UserDetailsColl> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserDetailsColl> userList) {
		this.userList = userList;
	}

	
}
