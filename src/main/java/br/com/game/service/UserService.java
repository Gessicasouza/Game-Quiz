package br.com.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.game.models.User;
import br.com.game.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> showAllUser() {
		return userRepository.findAll();
	}

	public User showUserById(Long id) {
		return userRepository.findById(id).get();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
