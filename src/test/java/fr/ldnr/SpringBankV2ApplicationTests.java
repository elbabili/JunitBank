package fr.ldnr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.ldnr.business.IBankJobImpl;
import fr.ldnr.dao.AccountRepository;
import fr.ldnr.dao.CustomerRepository;
import fr.ldnr.dao.TransactionRepository;
import fr.ldnr.entities.Current;
import fr.ldnr.entities.Customer;
import fr.ldnr.entities.Transaction;

@SpringBootTest
class SpringBankV2ApplicationTests {
	@Autowired
	IBankJobImpl bankJob;
	
	@Autowired
	CustomerRepository customerRepository;	
	@Autowired
	AccountRepository accountRepository;	
	@Autowired
	TransactionRepository transactionRepository;

	@Test
	void simpleTest() {
		assertEquals(true,true);
	}
	
	@Test
	void anotherSimpleTest() {
		assertNotEquals(true,true);
	}
	
	@Test
	void testOverdraft() {
		double val = bankJob.calculOverdraft(10);		
		assertEquals(val,100);
	}
	
	@Test
	void testCustomerPay() {	
		Customer toto = new Customer(null, "toto", "toto@gmail.com",null);
		customerRepository.save(toto);
		Customer tata = customerRepository.findByEmail("toto@gmail.com");
		assertEquals(tata.getEmail() , toto.getEmail());
		
		Current current = new Current(new Date(), 1500, 200 , toto);
		current = (Current)bankJob.addAccount(current);
		Transaction transaction = bankJob.pay(current.getId(), 500);		
		assertEquals(bankJob.getBalanceById(current.getId()),2000);
		
		transactionRepository.deleteById(transaction.getId());
		accountRepository.deleteById(current.getId());
		customerRepository.deleteById(toto.getId());	
	}
	
}
