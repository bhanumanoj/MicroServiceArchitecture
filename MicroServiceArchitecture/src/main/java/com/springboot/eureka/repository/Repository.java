package com.springboot.eureka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.eureka.model.Quote;

public interface Repository extends JpaRepository<Quote,Integer>{
	
	List<Quote> findByUserName(String username);
	//select * from quotes where userame=username

		//1 Ramu HDFC
		//2 Ramu SBI
		//3 Ramu ICICI
		//4 Ramu JIO
		//5 Ramu Airtel

}
