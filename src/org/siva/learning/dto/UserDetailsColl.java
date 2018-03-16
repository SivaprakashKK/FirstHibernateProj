package org.siva.learning.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "USER_COLLECTION")
public class UserDetailsColl {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	private String userName;
/*
 * Lazy/Eager, Adding foreign table index, renaming the collection name and columns
	@ElementCollection(fetch = FetchType.EAGER)
	// @CollectionTable(name="USER_ADDR_COLL")
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

*/	
	
/*	
//	One to one realtationshipp explanation
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
*/
	
	

//	One to many relationship
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();	 
	

	
/*	
//	Many to many relation
	@ManyToMany
	@JoinTable(name="VEHICLE_USER_COLL", joinColumns =@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
*/
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public Collection<Address> getListOfAddresses() {
//		return listOfAddresses;
//	}
//
//	public void setListOfAddresses(Collection<Address> listOfAddresses) {
//		this.listOfAddresses = listOfAddresses;
//	}

/*	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
*/	
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

 
}
