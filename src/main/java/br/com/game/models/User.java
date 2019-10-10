package br.com.game.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String idGoogle;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@ElementCollection
	private List<Long> questionsAnswered;
	
	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdGoogle() {
		return idGoogle;
	}
	
	public void setIdGoogle(String idGoogle) {
		this.idGoogle = idGoogle;
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

	public List<Long> getQuestionsAnswered() {
		return questionsAnswered;
	}
	
	public void setQuestionsAnswered(List<Long> questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}
}