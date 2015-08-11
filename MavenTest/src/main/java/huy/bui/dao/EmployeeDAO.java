package huy.bui.dao;

import java.util.List;

import huy.bui.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployeeList();
	public Employee getEmloyee(int id);
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);
}
