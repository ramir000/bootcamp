package com.globant.bootcamp.service.implement;

import java.util.List;

import com.globant.bootcamp.dao.UserDao;
import com.globant.bootcamp.model.User;
import com.globant.bootcamp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao repo;

	public User addUser(User user) {
		return repo.save(user);
	};

	public User getUser(long id) {
		return repo.getOne(id);
	};

	public void removeUser(long id) {
		repo.deleteById(id);
	}

	public List<User> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean exists(Long id) {
		return repo.existsById(id);
	};
}