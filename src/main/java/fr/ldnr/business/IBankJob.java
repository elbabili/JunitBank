package fr.ldnr.business;

import org.springframework.data.domain.Page;

import fr.ldnr.entities.Account;
import fr.ldnr.entities.Transaction;

/**
 * @author El babili - 2021
 * 
 */

public interface IBankJob {
	public void    deleteAccount(Account account);
	public Account addAccount(Account account);						//ajoute un compte à notre banque
	public Account consultAccount(long accountId);					//renvoi le compte correspondant à l'id 
	public Transaction pay(long accountId, double amount);					//faire un versement sur un compte 
	public void withdraw(long accountId, double amount);			//faire un retrait sur un compte
	public void transfert(long accIdSrc, long accIdDest, double amount);	//faire un virement d'un compte source vers destination
	//public Page<Transaction> listTransactions(long accountId, int page, int size); //renvoi la liste des opérations sur un compte donné
}
