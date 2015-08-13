package huy.bui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import huy.bui.model.Employee;

public class EmployeeJDBCTemplate implements EmployeeDAO {

	@Autowired
	DataSource dataSource;
	
	public List<Employee> getEmployeeList() {
		String sql = "SELECT * FROM employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Employee> list = jdbcTemplate.query(sql, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee empl = new Employee();
				empl.setId(rs.getInt("id"));
				empl.setName(rs.getString("name"));
				empl.setAge(rs.getInt("age"));

				return empl;
			}
		});
		return list;
	}

	public Employee getEmloyee(int id) {
		// TODO Auto-generated method stub
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				String sql = "SELECT * FROM employee WHERE id = " + id;
				return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

					public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						if (rs.next()) {
							Employee empl = new Employee();
							empl.setId(rs.getInt("id"));
							empl.setName(rs.getString("name"));
							empl.setAge(rs.getInt("age"));

							return empl;
						} else {
							return null;
						}
					}
				});
	}

	public void addEmployee(Employee employee) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO employee(name,age) VALUES (?,?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getAge());
		
	}

	public void updateEmployee(Employee employee) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE employee SET name = ?, age = ? where id = ?";
		jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getId());
		
	}

	public void deleteEmployee(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE from employee where id = " + id;
		jdbcTemplate.update(sql);
		
	}

}
