package br.com.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.game.models.User;
import br.com.game.repositories.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRespository;
	
	public Iterable<User> showAllUser() {
		return userRespository.findAll();
	}

	public User showUserById(Long id){
		return userRespository.findById(id).get();
	}
	
	public User saveUser(User user) {
		return userRespository.save(user);
	}
	
}
