package br.com.game.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateQuestion {

	private String description;
	private List<AlternativePart> alternatives;
	
	@JsonCreator
	public CreateQuestion(@JsonProperty("description") String description, @JsonProperty("alternatives") List<AlternativePart> alternatives) {
		this.description = description;
		this.alternatives = alternatives;
	}
	
	public String getDescription() {
		return description;
	}

	public List<AlternativePart> getAlternatives() {
		return alternatives;
	}


	public static class AlternativePart {
		private String description;
		private Boolean correct;
		
		@JsonCreator
		public AlternativePart(@JsonProperty("description") String description, @JsonProperty("correct") Boolean correct) {
			this.description = description;
			this.correct = correct;
		}
		
		public String getDescription() {
			return description;
		}
		public Boolean isCorrect() {
			return correct;
		}
		
	}
}
