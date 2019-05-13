package ca.sheridancollege.beans;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
	@NamedQuery(name="Employer.getEmployerList", query="from Employer"),
	@NamedQuery(name="Employer.getEmployer", query="from Employer where id=:id"),
	@NamedQuery(name="Employer.getEmployerById", query="from Employer where id=:id"),
	@NamedQuery(name="Employer.searchItemList", query="from Employer where name like :word"),
}) 
public class Employer implements Serializable{

	@Id
	@GeneratedValue
	@Positive
	private Long id;	// primary key
	@Length(min=3, max=255)
	private String name;

	@Embedded
	@Valid
	private Job job;
	
	public Employer(String name) {
		super();
		this.name = name;
	}
	
	
}
