package br.com.game.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.game.api.CreateQuestion;
import br.com.game.models.Alternative;
import br.com.game.models.Question;
import br.com.game.models.User;
import br.com.game.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
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

	public void deleteAllQuestion() {
		questionRepository.deleteAll();
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

	public long getCorrectAlternative(Long idQuestion) {
		Question question = questionRepository.findById(idQuestion).get();
		long idCorreto = 0;
//		List<Alternative> correctAlternative = new ArrayList<Alternative>();
		List<Alternative> alternativas = question.getAlternatives();

		for (Alternative alternative : alternativas) {
			if (alternative.isCorrect() == true) {
				idCorreto = alternative.getId();
//				correctAlternative.add(alternative);
				return idCorreto;
			}
		}
		return idCorreto;
	}

	public boolean checkCorrectAnswer(HttpSession session, Long idQuestion, Long alternative) {

		boolean correct = false;

		User user = (User) session.getAttribute("user");

		if (user != null) {

			if (getCorrectAlternative(idQuestion) == alternative) {

//				user.getAnsweredQuestions().add(idQuestion);
				correct = true;

				return correct;
			} else {
				return correct;
			}
		} else {
			return correct;
		}
	}

}
