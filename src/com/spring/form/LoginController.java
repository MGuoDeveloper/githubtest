package com.spring.form;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.LoginService;


@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) {
		String un = request.getParameter("username");
		String ps = request.getParameter("password");
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model) {
		
		if (result.hasErrors()) {
			return "loginform";
		}
		
		loginForm = (LoginForm) model.get("loginForm");
		
		LoginService ls = new LoginService();
		
		if(ls.isUserExists(loginForm)){
			model.put("loginForm", loginForm);
			return "loginsuccess";
		} else {
			System.out.println("error");
			return "loginerror";
		}
		
	}
}
