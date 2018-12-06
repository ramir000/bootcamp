package com.api.shoppingcart.service.implement;

import java.util.List;

import com.api.shoppingcartdao.UserDao;
import com.api.shoppingcart.dto.UserDto;
import com.api.shoppingcart.service.ConverterService;
import com.api.shoppingcart.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private ConverterService converterService;
	@Autowired
	private UserDao repo;

	public UserDto addUser(UserDto user) {
		return converterService.convert(repo.save(converterService.convert(user)));
	};

	public UserDto getUser(long id) {
		return converterService.convert(repo.getOne(id));
	};

	public void removeUser(long id) {
	}

	public List<UserDto> getAll() {
		return null;
	}

	@Override
	public boolean exists(Long id) {
		return false;
	};
}