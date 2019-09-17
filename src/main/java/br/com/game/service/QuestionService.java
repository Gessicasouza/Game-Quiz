package br.com.game.service;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.game.api.CreateQuestion;
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

	public Question takeQuestionById(long id) {
		return questionRepository.findById(id).get();
	}

	public Question createQuestion(CreateQuestion input) {
		Question question = new Question();
		question.setDescription(input.getDescription());
		question.setAlternatives(input.getAlternatives().stream().map(alternativePart -> {
			Alternative alternative = new Alternative();
			alternative.setDescription(alternativePart.getDescription());
			alternative.setCorrect(alternativePart.isCorrect());
			return alternative;
		}).collect(Collectors.toList()));

		questionRepository.save(question);

		return question;

	}

	public void deleteQuestion(long id) {
		questionRepository.deleteById(id);
	}

	public Question updateQuestion(long id, Question update) {
		Question test = new Question();
		test = questionRepository.findById(id).get();

		if (test != null) {
			update.setId(id);
			return questionRepository.save(update);
		}
		return null;

	}

}
