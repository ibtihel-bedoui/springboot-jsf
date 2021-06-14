package tn.dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Credit;

@Repository
public interface CreditRep extends CrudRepository<Credit, Integer>{
	@Query(value = "SELECT *  FROM `credit` WHERE `result`='Accepted'", nativeQuery = true)
	List<Credit> retrieveAccepted();

	@Query(value = "SELECT *  FROM `credit` WHERE `result`='Denied'", nativeQuery = true)
	List<Credit> retrieveDenied();
}
