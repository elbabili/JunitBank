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
@DiscriminatorValue("CA")	//TYPE_ACC = CA
public class Current extends Account {
	private int overdraft;
	
	public Current(Date creationDate, double balance, int overdraft, Customer customer) {
		super(null, creationDate, balance, customer,null);
		this.overdraft = overdraft;
	}
	
	public Current() {
		super();
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "Current [overdraft=" + overdraft + "]" + super.toString();
	}		
	
}
