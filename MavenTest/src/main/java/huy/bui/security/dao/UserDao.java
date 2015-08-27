package huy.bui.security.dao;

import huy.bui.security.model.User;

public interface UserDao {

	User findByUserName(String username);

}