package com.legalmall.user.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.legalmall.user.bean.User;
/*@Service
public class ventorServiceImpl implements iVentorService{
	
}*/
public interface UserMapper {

	public void addUser(User user);

	public List<User> getAllUser();

	public User getUserById(String id);

	public void deleteById(String id);

	public void update(User user);

}
