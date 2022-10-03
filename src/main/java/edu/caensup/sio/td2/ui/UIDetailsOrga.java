package edu.caensup.sio.td2.ui;

import java.util.ArrayList;
import java.util.List;

import edu.caensup.sio.td2.models.Group;
import edu.caensup.sio.td2.models.User;

public class UIDetailsOrga {

	private List<Group> groups;
	private List<User> users;
		
	public UIDetailsOrga(List<Group> groups, List<User> users) {
		
		this.groups = groups;
		this.users = users;
		System.out.println(this.groups);
		System.out.println(this.users);
		
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
