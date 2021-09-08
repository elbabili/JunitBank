/**
 * @author El babili - 2021
 * 
 */

package fr.ldnr.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)	// un client peut avoir plusieurs compte : association bidirectionnelle donc mappedBy, LAZY pour gérer les associations entre les classes, LAZY pour eviter de renvoyer tous les comptes d'un client (performances)
	// reference de la relation dans la classe compte
	private Collection<Account> listAccounts;
	
}
