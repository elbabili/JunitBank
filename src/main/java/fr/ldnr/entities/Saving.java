/**
 * @author El babili - 2021
 * 
 */

package fr.ldnr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SA")	//TYPE_ACC = SA
public class Saving extends Account {
	private double rate;
	
	public Saving(Date creationDate, double balance, double rate, Customer customer) {
		super(null, creationDate, balance, customer,null);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Saving() {
		super();
	}

	@Override
	public String toString() {
		return "Saving [rate=" + rate + "]" + super.toString();
	}		
	
}
