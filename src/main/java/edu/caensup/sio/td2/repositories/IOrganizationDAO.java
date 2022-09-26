package edu.caensup.sio.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.caensup.sio.td2.models.Organization;

public interface IOrganizationDAO extends JpaRepository<Organization, Integer> {

	public List<Organization> findByNameContaining(String name);
	
}
