package huy.bui.security.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="user_roles")
public class UserRole {
	
	@Id
	@Column(name="user_role_id")
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userRoleId;
	
	@Column(name="user_name")
	@NotNull
	@OneToMany(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="role")
	@NotNull
	private String role;

	public UserRole() {
	}

	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
