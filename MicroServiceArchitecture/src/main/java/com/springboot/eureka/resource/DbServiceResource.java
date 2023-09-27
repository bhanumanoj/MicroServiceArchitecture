package com.springboot.eureka.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.eureka.model.Companies;
import com.springboot.eureka.model.Quote;
import com.springboot.eureka.repository.Repository;

@RestController
@RequestMapping("/rest/db")
//http://localhost:8300/rest/db/nitesh
public class DbServiceResource {
	
	@Autowired
	private Repository repository;
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Companies companies){
		
		companies.getProviders().stream()
		.map(provide -> new Quote(companies.getUser(),provide))
		.forEach(provide -> repository.save(provide));
		
		return getCompaniesByUserName(companies.getUser());
	}
	
	
	private List<String> getCompaniesByUserName(@PathVariable("username") String username){
		return repository.findByUserName(username).stream()
				.map(quote->{
					return quote.getQuote();
				}).collect(Collectors.toList());
	}
	
	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return getCompaniesByUserName(username);

	}
	
	@PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {

        List<Quote> quotes = repository.findByUserName(username);
        repository.deleteAll(quotes);

        return getCompaniesByUserName(username);
    }

}
