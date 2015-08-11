package huy.bui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import huy.bui.dao.EmployeeJDBCTemplate;
import huy.bui.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeJDBCTemplate employeeDAO;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployee() {
		List<Employee> list = employeeDAO.getEmployeeList();
		ModelAndView mv = new ModelAndView("employeelist");
		mv.addObject("listEmployee", list);
		return mv;
	}

	@RequestMapping(value = "/addpage")
	public ModelAndView addPage() {
		ModelAndView mv = new ModelAndView("addemployee");
		Employee emp = new Employee();
		mv.addObject("newEmp", emp);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmlpoyee(@ModelAttribute Employee emp) {
		ModelAndView mv = new ModelAndView("addemployee");

		employeeDAO.addEmployee(emp);

		mv.addObject("newEmp", emp);
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(int id) {

		employeeDAO.deleteEmployee(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/updatepage")
	public ModelAndView updatePage(@RequestParam(value = "id") int id) {
		ModelAndView mv = new ModelAndView("detailemployee");
		Employee emp = new Employee();
		emp.setId(id);
		mv.addObject("newEmp", emp);
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee emp) {
		ModelAndView mv = new ModelAndView("detailemployee");
		employeeDAO.updateEmployee(emp);
		mv.addObject("newEmp", emp);
		return "redirect:/list";

	}
}
