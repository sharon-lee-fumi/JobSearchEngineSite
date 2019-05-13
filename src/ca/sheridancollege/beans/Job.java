package ca.sheridancollege.beans;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Job{

	@Length(min=3, max=255)
	private String jobTitle;
	@Min(0)
	@Max(1000000)
	private int salaryMin;
	@Min(0)
	@Max(1000000)
	private int salaryMax;
	@Length(min=3, max=255)
	private String details;
}
