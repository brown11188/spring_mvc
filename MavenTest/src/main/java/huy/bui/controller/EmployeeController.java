package huy.bui.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import huy.bui.dao.EmployeeHibernateDAOIpml;
import huy.bui.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeHibernateDAOIpml employeeDAO;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Locale locale, Model mv) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		Locale locale2 = LocaleContextHolder.getLocale();

		String formatedDateTime = dateFormat.format(date);
		mv.addAttribute("serverTime", formatedDateTime);
		mv.addAttribute("currentLocale", locale2);
		return "home";
	}

	@RequestMapping("/ajax")
	public ModelAndView helloAjaxTest() {
		return new ModelAndView("ajax", "message", "Hello hello hello");
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody String getTime() {
		Random random = new Random();
		float r = random.nextFloat() * 100;
		String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
		System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
		return result;
	}

	// @RequestMapping(value = "/json")
	// public @ResponseBody List<Employee> getJSON() {
	// List<Employee> list = (List<Employee>)employeeDAO.getEmployeeList();
	// return list;
	// }
	//
	// @RequestMapping(value = "/jsonemp")
	// public @ResponseBody Employee getJSONEmp() {
	// Employee emp = new Employee(14, "name", 13);
	// return emp;
	// }

	@RequestMapping(value = "/addpage")
	public ModelAndView addPage() {
		ModelAndView mv = new ModelAndView("addemployee");
		Employee emp = new Employee();
		mv.addObject("newEmp", emp);
		return mv;
	}

	@RequestMapping(value = "/updatepage")
	public ModelAndView updatePage(@RequestParam(value = "id") int id) {
		Employee emp = employeeDAO.getEmloyee(id);
		ModelAndView mv = new ModelAndView("detailemployee");
		mv.addObject("newEmp", emp);
		return mv;
	}

	@RequestMapping(value = "/listhibernate", method = RequestMethod.GET)
	public ModelAndView listHibernateEmployee() {

		List<Employee> list = employeeDAO.getEmployeeList();
		ModelAndView mv = new ModelAndView("employeelist");
		mv.addObject("listEmployee", list);
		return mv;
	}

	@RequestMapping(value = "/addhibernate", method = RequestMethod.POST)
	public String addHibernateEmployee(@Valid @ModelAttribute("newEmp") Employee employee,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("addemployee");
		if (bindingResult.hasErrors()) {
			return "addemployee";
		} else {
			employeeDAO.addEmployee(employee);
			mv.addObject("newEmp", employee);
			return "redirect:/listhibernate";
		}
	}

	@RequestMapping(value = "/updatehibernate", method = RequestMethod.POST)
	public String updateHibernateEmployee(@Valid @ModelAttribute("newEmp") Employee employee,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("detailemployee");
		if (bindingResult.hasErrors()) {
			return "detailemployee";
		} else {
			employeeDAO.updateEmployee(employee);
			mv.addObject("newEmp", employee);
			return "redirect:/listhibernate";
		}
	}

	@RequestMapping(value = "/deletehibernate", method = RequestMethod.GET)
	public String deleteHibernateEmployee(int id) {
		employeeDAO.deleteEmployee(id);
		return "redirect:/listhibernate";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
}
