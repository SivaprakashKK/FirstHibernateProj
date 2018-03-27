package org.siva.learning.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
//@NamedQuery(name="UserDetails.byId", query="from UserDetailsCRUD where userId = ?")
//@NamedNativeQuery(name="UserDetails.byName", query="Select * from USER_CRUD where username = ?", resultClass=UserDetailsCRUD.class)
@Table(name = "USER_CRUD")
public class UserDetailsCRUD {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
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



}
