package br.com.game.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.game.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {

}
