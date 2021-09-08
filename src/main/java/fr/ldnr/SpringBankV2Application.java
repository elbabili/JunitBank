package fr.ldnr;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.ldnr.business.IBankJobImpl;
import fr.ldnr.dao.AccountRepository;
import fr.ldnr.dao.CustomerRepository;
import fr.ldnr.entities.Account;
import fr.ldnr.entities.Current;
import fr.ldnr.entities.Customer;
import fr.ldnr.entities.Saving;
import fr.ldnr.entities.Transaction;

@SpringBootApplication
public class SpringBankV2Application implements CommandLineRunner{
	@Autowired
	IBankJobImpl bankJob;
	
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBankV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Customer robert = new Customer(null, "robert", "robert@gmail.com",null);
//		Customer julie = new Customer(null, "julie", "julie@gmail.com",null);	
//		customerRepository.save(robert);
//		customerRepository.save(julie);
//		
//		Current firstAccount = new Current(new Date(), 1500, 200 , robert);		
//		Saving secondAccount = new Saving(new Date(), 2000, 5.5, julie);	
//		
//		System.out.println("**************************************");
//		System.out.println("**************************************");
//		System.out.println("**************************************");
//		System.out.println("**************************************");
//		System.out.println(firstAccount);
//		System.out.println(secondAccount);
//		
//		bankJob.addAccount(firstAccount);
//		bankJob.addAccount(secondAccount);
//		
//		bankJob.pay(firstAccount.getId(),500);		// versement de 500 euros sur le compte de robert
//		bankJob.pay(secondAccount.getId(), 1000);	// versement de 1000 euros sur le compte de julie
//		
//		bankJob.withdraw(firstAccount.getId(), 250);			// retrait de 250 euros sur le compte de robert
//		bankJob.withdraw(secondAccount.getId(), 400);			// retrait de 400 euros sur le compte de julie
//		
//		bankJob.transfert(firstAccount.getId(), secondAccount.getId() , 200);		// virement de robert chez julie de 200
//		
//		try {
//			bankJob.consultAccount(111111);		//compte inexistant
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			bankJob.withdraw(firstAccount.getId(), 10000);	//capacité de retrait dépassée
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			bankJob.transfert(firstAccount.getId(), firstAccount.getId(), 50000);		//virement sur le même compte
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		Current thirdAccount = new Current(new Date(), 750, 150 , julie);
//		bankJob.addAccount(thirdAccount);	//nous rajoutons un nouveau compte à Julie
//		bankJob.pay(thirdAccount.getId(),150);
//		bankJob.pay(thirdAccount.getId(),750);
//		
//		System.out.println("\n-----------------------Liste des transactions pour chaque compte-----------------------------------");
//		for(Account acc : bankJob.listAccounts()) {			
//			for(Transaction trans : bankJob.listTransactions(acc.getId()))
//				System.out.println(trans);
//			System.out.println("-----------------------------------------");
//		}	
	}
}
