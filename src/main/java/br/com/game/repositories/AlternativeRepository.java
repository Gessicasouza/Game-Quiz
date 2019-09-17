package br.com.game.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.game.models.Alternative;
@Repository
public interface AlternativeRepository extends CrudRepository<Alternative,Long> {

}
