package fr.ldnr.business;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.ldnr.dao.AccountRepository;
import fr.ldnr.dao.TransactionRepository;
import fr.ldnr.entities.Account;
import fr.ldnr.entities.Current;
import fr.ldnr.entities.Transaction;
import fr.ldnr.entities.Transfert;
import fr.ldnr.entities.withdrawal;

/**
 * @author El babili - 2021
 * 
 */

@Service //pour que spring puisse instancier cette classe
@Transactional	// pour deleguer les transactions à spring -> soit execution des méthodes soit annulation 
public class IBankJobImpl implements IBankJob {
	public static final double overdraft = 10; 
	
	@Autowired 
	private AccountRepository accountRepository; 
	@Autowired //si pas declaré/injecté, pointer null
	private	TransactionRepository transactionRepository;
	
	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);					
	}
	
	@Override
	public void deleteAccount(Account account) {
		accountRepository.deleteById(account.getId());
	}
	
	@Override
	public Account consultAccount(long accountId) {		
		Account account = accountRepository.getById(accountId);
		if(account == null)		throw new RuntimeException("Vous demandez un compte inexistant !");
		return account;
	}
	
	public double getBalanceById(long id) {
		return consultAccount(id).getBalance();
	}

	@Override
	public Transaction pay(long accountId, double amount) {				// versement
		Account account = consultAccount(accountId);		
		Transaction trans = new Transfert(null,new Date(),amount,account);	
		
		transactionRepository.save(trans);		// ajout d'une opération de versement
		account.setBalance(account.getBalance() + amount);
		accountRepository.save(account);	//mise à jour du compte : solde
		
		return trans;
	}

	@Override
	public void withdraw(long accountId, double amount) {			//retrait
		Account account = consultAccount(accountId);

		double capacity = 0;
		if(account instanceof Current) {
			capacity = account.getBalance() + ((Current)account).getOverdraft();	//solde + decouvert autorisé				
		}
		else capacity = account.getBalance();
		if(amount <= capacity) {
			account.setBalance(account.getBalance() - amount);
			Transaction trans = new withdrawal(null,new Date(),amount,account);
			transactionRepository.save(trans);		// ajout d'une opération de retrait
			accountRepository.save(account);		//mise à jour du compte : solde
		}
		else {
			throw new RuntimeException("vous avez dépassé vos capacités de retrait !");
		}
	}
	
	@Override
	public void transfert(long accIdSrc, long accIdDest, double amount) throws RuntimeException {	//virement				
		if(accIdSrc == accIdDest)	throw new RuntimeException("vous ne pouvez retirer et verser sur le même compte !");							
		withdraw(accIdSrc, amount);			//retrait
		pay(accIdDest, amount);				//alors versement		
	}
		
	public List<Account> listAccounts(){
		return accountRepository.findAll();
	}
	
	public List<Transaction> listTransactions(Long AccountId){
		return transactionRepository.findByAccountId(AccountId);
	}
	
	public double calculOverdraft(int val) {	//calcul le découvert autorisé d'un client
		return overdraft*val;
	}
}
