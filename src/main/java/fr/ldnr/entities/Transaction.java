/**
 * @author El babili - 2021
 * 
 */

package fr.ldnr.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_TRANS", discriminatorType=DiscriminatorType.STRING,length=1)	//T ou W
public abstract class Transaction {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date transactionDate;
	private double amount;
	
	@ManyToOne	// plusieurs opérations peuvent être effectuées sur un compte
	@JoinColumn(name="CODE_ACC")		//jointure donc clé étrangère = CODE_ACC
	private Account account;
}
