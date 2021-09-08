/**
 * @author El babili - 2021
 * 
 */

package fr.ldnr.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)	//Une SEULE TABLE pour toute hiérarchie de classe
@DiscriminatorColumn(name="TYPE_ACC", discriminatorType = DiscriminatorType.STRING,length=2)	//CA ou SA
public abstract class Account implements Serializable {													
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date creationDate;
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="CODE_CUST")	//jointure donc clé étrangère = CODE_CUST
	private Customer customer;
	
	@OneToMany(mappedBy="account")	//un compte peut avoir plusieurs opérations
	// reference de la relation dans la classe operation
	private Collection<Transaction> listTransactions;	
}
