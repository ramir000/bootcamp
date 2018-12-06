package com.api.shoppingcart.service.implement;

import java.util.List;

import com.api.shoppingcart.dao.UserDao;
import com.api.shoppingcart.dto.UserDto;
import com.api.shoppingcart.model.User;
import com.api.shoppingcart.service.UserService;

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
		return null;
	}

	@Override
	public boolean exists(Long id) {
		return false;
	};
}