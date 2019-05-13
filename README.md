# JobSearchEngineSite
Job search engine site with live searching functionality and using JSON/AJAX

- Allow all users to post new jobs to a collective pool
- Users are able to view a full list of all jobs posted previously
- Users see the minimal information about the job (employer) and have the ability to drill into any given job for more information (using an AJAX JSON call)
- Hibernate Validation is used to enforce strict data requirements
- The system is able to perform a keyword search on the short form displayed info (employer) to narrow the results. A link at the bottom of the search results is return the user to the full list again
- Use ModelAttributes with Spring Forms
