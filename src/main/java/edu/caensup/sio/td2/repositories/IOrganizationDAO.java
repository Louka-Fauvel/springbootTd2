package edu.caensup.sio.td2.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.caensup.sio.td2.models.Organization;

public interface IOrganizationDAO extends CrudRepository<Organization, Integer> {

}
