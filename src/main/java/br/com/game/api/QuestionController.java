package br.com.game.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.game.models.Alternative;
import br.com.game.models.Question;
import br.com.game.service.QuestionService;

@RestController
@RequestMapping("/quiz")
public class QuestionController {

	@Autowired
	public QuestionService questionService;

	@GetMapping
	public ResponseEntity<?> showQuestions() {

		if (questionService.quantityQuestions() > 0) {
			return ResponseEntity.ok(questionService.showAllQuestions());
		}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping
	public ResponseEntity<QuestionRepresentation> saveQuestion(@Valid @RequestBody CreateQuestion question){
		
		try {
			Question newQuestion = questionService.createQuestion(question);
			
			QuestionRepresentation representation = new QuestionRepresentation();
			representation.setId(newQuestion.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(representation);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}	