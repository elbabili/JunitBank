/**
 * @author El babili - 2021
 * 
 */

package fr.ldnr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.ToString;

@Entity
@DiscriminatorValue("W")
@ToString
public class withdrawal extends Transaction {
	public withdrawal() {
		super();
	}
	
	public withdrawal(Long id, Date date, double amount, Account account) {
		super(id,date,amount,account);
	}
}
