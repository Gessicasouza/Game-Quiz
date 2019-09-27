package br.com.game.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String name;
	
	private String email;
//	
//	private boolean administrator = false;
//	
//	@ElementCollection
//	private List<Long> answeredQuestions ;
	
	public User () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public boolean isAdministrator() {
//		return administrator;
//	}
//
//	public void setAdministrator(boolean administrator) {
//		this.administrator = administrator;
//	}
//
//	public List<Long> getAnsweredQuestions() {
//		return answeredQuestions;
//	}
//
//	public void setAnsweredQuestions(List<Long> answeredQuestions) {
//		this.answeredQuestions = answeredQuestions;
//	}
	
}