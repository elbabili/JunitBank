package fr.ldnr.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ldnr.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
	public List<Transaction> findByAccountId(Long accountId);
}
