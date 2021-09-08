package fr.ldnr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ldnr.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
	
//	@Query("select c from Compte c where c.codeCompte=:x")
//	public Compte findOne(@Param("x")String codeCpte);
}
