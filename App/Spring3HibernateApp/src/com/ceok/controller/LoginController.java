package com.ceok.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ceok.bean.LoginBean;
import com.ceok.model.Login;
import com.ceok.service.LoginService;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	private static Logger logger = LogManager.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView isValidateUser(@ModelAttribute("users") LoginBean loginBean, 
			BindingResult result,Model model) {
		try{
			Login users = prepareModel(loginBean);
			boolean validUser = loginService.isValidateUser(users);
			if(validUser){
				model.addAttribute("username",users.getUsername());
				model.addAttribute("password",users.getPassword());
				return new ModelAndView("home");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("error","error getting while checking username and password");
		return new ModelAndView("login");
	}
/*
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(loginService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add.", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("users") LoginBean loginBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(loginService.listEmployeess()));
		return new ModelAndView("login", model);
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(@ModelAttribute("users")  LoginBean loginBean,
			BindingResult result) {
		return new ModelAndView("login");
	}
/*	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("users")  LoginBean loginBean,
			BindingResult result) {
		loginService.deleteEmployee(prepareModel(loginBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",  prepareListofBean(loginService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}*/
	
/*	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("users")  LoginBean loginBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareloginBean(loginService.getEmployee(loginBean.getId())));
		model.put("employees",  prepareListofBean(loginService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	*/

	private Login prepareModel(LoginBean loginBean){
		Login users = new Login();
		users.setUsername(loginBean.getUsername());
		users.setPassword(loginBean.getPassword());
		return users;
	}
}
	/*	
	private List<LoginBean> prepareListofBean(List<Login> users){
		List<LoginBean> beans = null;
		if(users != null && !users.isEmpty()){
			beans = new ArrayList<LoginBean>();
			LoginBean bean = null;
			for(Login user : users){
				bean = new LoginBean();
				bean.setId(user.getId());
				bean.setUsername(user.getUsername());
				bean.setPassword(user.getPassword());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private LoginBean prepareloginBean(Login users){
		LoginBean bean = new LoginBean();
		return bean;
	}
}*/


/*
@BindingResult use for validation and Error display purpose
@ModelAndView("name of form") represent form and it's name

*/