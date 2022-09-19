package edu.caensup.sio.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.caensup.sio.td2.models.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer> {

	public List<User> findByFirstnameAndLastname(String firstname, String lastname);
	
}
