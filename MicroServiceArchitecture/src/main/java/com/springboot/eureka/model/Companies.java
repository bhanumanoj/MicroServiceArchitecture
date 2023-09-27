package com.springboot.eureka.model;

import java.util.List;

public class Companies {
	
	private String user;
	private List<String> providers;
	
	public Companies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Companies(String user, List<String> providers) {
		super();
		this.user = user;
		this.providers = providers;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<String> getProviders() {
		return providers;
	}

	public void setProviders(List<String> providers) {
		this.providers = providers;
	}
	
	
}
