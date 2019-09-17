package br.com.game.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.game.api.CreateQuestion;
import br.com.game.api.CreateQuestion.AlternativePart;
import br.com.game.models.Alternative;
import br.com.game.models.Question;
import br.com.game.repositories.AlternativeRepository;
import br.com.game.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AlternativeRepository alternativeRepository;

	public Iterable<Question> showAllQuestions() {
		return questionRepository.findAll();
	}

	public long quantityQuestions() {
		return questionRepository.count();

	}

	public Question createQuestion(CreateQuestion input) {
		Question question = new Question();
		question.setDescription(input.getDescription());
		question.setAlternatives(input.getAlternatives()
				.stream()
				.map(alternativePart -> {
					Alternative alternative = new Alternative();
					alternative.setDescription(alternativePart.getDescription());
					alternative.setCorrect(alternativePart.isCorrect());
					return alternative;})
				.collect(Collectors.toList()));
		
		questionRepository.save(question);

		
		return question;
//		question.setAlternatives(alternative);
//		questionRepository.save(question);
//		return question;
	}

}
