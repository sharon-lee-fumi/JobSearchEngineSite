package ca.sheridancollege.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.sheridancollege.beans.Employer;
import ca.sheridancollege.dao.DAO;

@Controller
public class HomeController {

	private DAO dao = new DAO();

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model)
	{		
		model.addAttribute("employerList", dao.getEmployerList());
		return "displayEmployers";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model)
	{
		Employer employer = new Employer();
		model.addAttribute("employer", employer);
		return "addEmployer";
	}
	
	@RequestMapping(value="/saveEmployer", method=RequestMethod.POST)
	public String saveEmployer(Model model, @ModelAttribute Employer employer)
	{

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Employer>> constraintViolations =
				validator.validate(employer);
		
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Employer> violation : constraintViolations) {
				model.addAttribute(violation.getPropertyPath().toString() .replace(".",
			"_"), violation.getMessage());
			model.addAttribute("employer", employer);
			}
			return "addEmployer";
		}
		else {
			dao.saveEmployer(employer);
		}
		
		model.addAttribute("employerList", dao.getEmployerList());
		return "displayEmployers";
	}

	@RequestMapping(value="/getEmployer/{id}", produces="application/json")
	@ResponseBody
	public Map<String, Object> getEmployer(@PathVariable Long id) {
		// map is a kind of collection
		Map<String, Object> data = new HashMap<String, Object>();
		
		Employer employer = dao.getEmployerById(id);
		data.put("employer", employer);
		return data;
	}
	
	@RequestMapping(value="display",produces="application/json")
	public String display(Model model) {

		model.addAttribute("employerList", dao.getEmployerList());
		return "displayEmployers";
	}
	
	@RequestMapping(value="/searchItem", method=RequestMethod.GET)
	public String searchItem(Model model, @RequestParam String word)
	{
		model.addAttribute("employerList", dao.searchItemList(word));
		return "displayEmployers";
	}
}
