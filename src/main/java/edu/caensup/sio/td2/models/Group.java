package edu.caensup.sio.td2.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 60)
	private String name;
	
	private String email;
	
	private String aliases;
	
	@ManyToMany
	@JoinTable(name = "user_group")
	private List<User> users;
	
}
