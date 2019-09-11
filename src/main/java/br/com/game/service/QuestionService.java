package br.com.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.game.models.Alternative;
import br.com.game.models.Question;
import br.com.game.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Iterable<Question> showAllQuestions() {
		return questionRepository.findAll();
	}

	public long quantityQuestions() {
		return questionRepository.count();

	}

	public void SaveQuestion(Question question, List<Alternative> alternative) {
		question.setAlternatives(alternative);
		questionRepository.save(question);
	}

}
