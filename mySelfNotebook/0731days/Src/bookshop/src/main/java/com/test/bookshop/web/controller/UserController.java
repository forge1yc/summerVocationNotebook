package com.test.bookshop.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookshop.biz.UserService;
import com.test.bookshop.biz.impl.UserServiceImpl;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.test.bookshop.domain.po.User;
// �������� session �е����ݵ���Ϣ(key��ֵ��value������)
@SessionAttributes(value = {"usn", "pwd"}, types = {User.class})
@Controller
public class UserController {
//	private UserService userService = new UserServiceImpl();
	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(User user, /* Map<String, Object> map,*/ ModelMap map, Model model) {
		ModelAndView mv = new ModelAndView();
		// 1 - ��ȡ����
		System.out.println(user);
		// 2 - ����ҵ���߼���ķ���
		// ģ��ʵ��
//		if ( user.getUsn().equals(user.getPwd()) ) {
		if (userService.isValidate(user.getUsn(), user.getPwd())){
//			mv.setViewName("success");
//			Map<String, Object> data = new HashMap<String, Object>();
//			data.put("username", user.getUsn());
//			data.put("salary", user.getSalary());
//			mv.addAllObjects(data);
			// �����û�����Ϣ������ session �У�
			map.put("usn", user.getUsn());
			map.put("pwd", user.getPwd());
			model.addAttribute("user",user);
//			mv.addObject("user", user);
			mv.setViewName("redirect:/getAllBooks");
		}else {
			mv.setViewName("login");	// ת���� login.jsp ҳ��
//
//			mv.setViewName("forward:/register");  // ת����ת�� /register ������
		}
		return mv;
	}

	// ��ת��ע��ҳ��
	@GetMapping("/register")
	public String toRegister(){
		return "register";
	}

}
