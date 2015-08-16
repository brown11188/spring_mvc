package huy.bui.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import huy.bui.dao.EmployeeHibernateDAOIpml;
import huy.bui.dao.EmployeeJDBCTemplate;

@org.springframework.context.annotation.Configuration
@ComponentScan("huy.bui")
@EnableWebMvc
public class Configuration extends WebMvcConfigurerAdapter {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/employee");
//		dataSource.setUsername("root");
//		dataSource.setPassword("");
//		return dataSource;
//	}

//	@Bean(name = "employeeDAO")
//	public EmployeeJDBCTemplate getEmployeeJDBCTemplate() {
//		EmployeeJDBCTemplate employeeDAO = new EmployeeJDBCTemplate();
//
//		return employeeDAO;
//	}
	
//	public EmployeeHibernateDAOIpml getEmployeeHibernate(){
//		EmployeeHibernateDAOIpml employeeDAO = new EmployeeHibernateDAOIpml();
//		return employeeDAO;
//	}

}
