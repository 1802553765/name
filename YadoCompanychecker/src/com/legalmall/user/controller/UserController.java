package com.legalmall.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.legalmall.user.bean.User;
import com.legalmall.user.mapper.UserMapper;
//@这个你在service上，或者方法上加上那个事务的注解就可以了
/*@Service
public class ventorServiceImpl implements iVentorService{
	
}*/

@Controller
@RequestMapping(value = "/gl")
public class UserController {

	private UserMapper userMapper = null;

	@Autowired
	public void setMapper(UserMapper userMapper) {
			this.userMapper = userMapper;
		
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		List<User> users = userMapper.getAllUser();
		model.addAttribute("users", users);
		return "hello";
	}

//	@RequestMapping(value = "/add")
//	public ModelAndView add(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("hello");
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		User user = new User();
//		user.setId(UUID.randomUUID().toString());
//		user.setUserName(userName);
//		user.setPassword(password);
//		userMapper.addUser(user);
//		List<User> list = userMapper.getAllUser();
//		mv.addObject("users", list);
//		return mv;
//	}

	@RequestMapping(value = "/detail")
	public String detail(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("111111");
		String id = request.getParameter("id");
	
		User user = userMapper.getUserById(id);
	
		model.addAttribute("user", user);
		//model.
		return "detail";
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		userMapper.deleteById(id);
		ModelAndView mv = new ModelAndView("hello");
		List<User> list = userMapper.getAllUser();
		System.out.println("进来"+list.size());
		mv.addObject("users", list);
		return mv;
	}

	@RequestMapping(value = "/toupdate")
	public String toUpdate(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入");
		String id = request.getParameter("id");
		User user = userMapper.getUserById(id);
		model.addAttribute("user", user);
		return "update";
	}

/*	@RequestMapping(value = "/update")
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("执行");
//		String id = request.getParameter("sid");
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
		String id="1";
		String userName="2";
		String password="3";
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		userMapper.update(user);
		ModelAndView mv = new ModelAndView("hello");
		List<User> list = userMapper.getAllUser();
		mv.addObject("users", list);
		return mv;
	}*/
}
