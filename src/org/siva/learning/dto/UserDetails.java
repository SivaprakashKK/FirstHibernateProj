package org.siva.learning.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Model class
 * 
 * @author kksi
 *
 */
@Entity
//(name = "USER_DETAILS")
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="USER_ID")
	private int userId;
	//@Column(name="USER_NAME")
	//@Transient
	private String userName;
	//private String address;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Lob
	private String description;

	@Embedded
	private Address address;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="OFFICE_STREET")),
		@AttributeOverride(name="city", column=@Column(name="CITY")),
		@AttributeOverride(name="state", column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="pincode", column=@Column(name="OFFICE_PIN_CODE")),
	})
	private Address officeAddress;
	
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

/*	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
*/
	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	

}
