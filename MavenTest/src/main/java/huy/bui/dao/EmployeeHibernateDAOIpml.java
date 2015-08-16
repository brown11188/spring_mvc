package huy.bui.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import huy.bui.model.Employee;

@Repository
public class EmployeeHibernateDAOIpml implements EmployeeDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Employee> getEmployeeList() {
		Session session = this.sessionFactory.openSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		session.close();
		return employeeList;
	}

	public Employee getEmloyee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEmployee(Employee employee) {
		 Session session = this.sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 session.persist(employee);
		 tx.commit();
		 session.close();
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub

	}

}
