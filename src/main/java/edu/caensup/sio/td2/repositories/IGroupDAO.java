package edu.caensup.sio.td2.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.caensup.sio.td2.models.Group;

public interface IGroupDAO extends CrudRepository<Group, Integer> {

}
