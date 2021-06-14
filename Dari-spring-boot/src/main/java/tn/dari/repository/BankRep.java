package tn.dari.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Bank;

@Repository
public interface BankRep extends CrudRepository<Bank, Long>{

	@Query( "SELECT count (*) from Bank bank where bank.address=:address")
	public long getNombreBankJPQL(@Param("address") String address);

}
