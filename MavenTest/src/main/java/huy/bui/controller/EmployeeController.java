package huy.bui.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import huy.bui.dao.EmployeeJDBCTemplate;
import huy.bui.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeJDBCTemplate employeeDAO;

	@RequestMapping(value = "/json")
	public @ResponseBody List<Employee> getJSON() {
		List<Employee> list = (List<Employee>)employeeDAO.getEmployeeList();
		return list;
	}
	
	@RequestMapping(value = "/jsonemp")
	public @ResponseBody Employee getJSONEmp() {
		Employee emp = new Employee(14, "name", 13);
		return emp;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployee() {
		List<Employee> list = employeeDAO.getEmployeeList();
		ModelAndView mv = new ModelAndView("employeelist");
		mv.addObject("listEmployee", list);
		return mv;
	}

	@RequestMapping(value = "/addpage")
	public @ResponseBody ModelAndView addPage() {
		ModelAndView mv = new ModelAndView("addemployee");
		Employee emp = new Employee();
		mv.addObject("newEmp", emp);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmlpoyee(@Valid @ModelAttribute("newEmp") Employee emp, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("addemployee");

		if (bindingResult.hasErrors()) {
			return "addemployee";

		} else {
			employeeDAO.addEmployee(emp);
			mv.addObject("newEmp", emp);
			return "redirect:/list";
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/updatepage")
	public ModelAndView updatePage(@RequestParam(value = "id") int id) {
		Employee emp = employeeDAO.getEmloyee(id);
		ModelAndView mv = new ModelAndView("detailemployee");
		mv.addObject("newEmp", emp);
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@Valid @ModelAttribute("newEmp") Employee emp, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("detailemployee");
		if (bindingResult.hasErrors()) {
			return "detailemployee";
		} else {
			employeeDAO.updateEmployee(emp);
			mv.addObject("newEmp", emp);
			return "redirect:/list";
		}

	}

	// @RequestMapping(value="/add", method=RequestMethod.POST)
	// public void checkPersonal(@Valid @ModelAttribute("userForm") Employee
	// employee, BindingResult bindingResult){
	// if(bindingResult.hasErrors()) {
	// System.out.println("Right");
	//
	// } else {
	// System.out.println("Wrong");
	//
	// }
	// }
	//

}
