package fr.ldnr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Customer;
													 //Classe  id
public interface CustomerRepository extends JpaRepository<Customer,Long> {
	public Customer findByEmail(String email);
}
