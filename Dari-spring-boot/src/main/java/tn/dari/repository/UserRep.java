package tn.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.User;

@Repository
public interface UserRep extends CrudRepository<User, Long> {

}
