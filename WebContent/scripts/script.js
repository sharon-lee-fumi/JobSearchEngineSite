function getEmployer(url, id) {
	if (document.getElementById("employer"+id).innerHTML == "") {
		// fetch the relevant JSON data and set the div!
			fetch(url+id)
				.then(data => data.json())
				.then(function(data) {
					
				// modify textToDisplay here!
				var textToDisplay = "";
				textToDisplay += "Job Title: " + data.employer.job.jobTitle + "<br>";
				textToDisplay += "Salary Min: " + data.employer.job.salaryMin + "<br>";
				textToDisplay += "Salary Max: " + data.employer.job.salaryMax + "<br>";
				textToDisplay += "Details: " + data.employer.job.details + "<br>";
				
				document.getElementById("employer"+id).innerHTML = textToDisplay;
			});
		} else {
		document.getElementById("employer"+id).innerHTML = "";
	}
}