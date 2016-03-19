package com.shengsiyuan.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.service.PersonService;
import com.shengsiyuan.service.impl.PersonServiceImpl;

public class PersonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String savePerson() throws Exception {
		Person person = new Person();
		person.setUsername(username);
		person.setPassword(password);
		person.setAge(age);
		
		Date date = new Date();
		person.setRegisterDate(date);
		
		PersonService service = new PersonServiceImpl();
		service.savePerson(person);
		
		return SUCCESS;
	}
	
}
