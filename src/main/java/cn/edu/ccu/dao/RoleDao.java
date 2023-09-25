package cn.edu.ccu.dao;

import java.util.List;

import cn.edu.ccu.domain.Role;

public interface RoleDao {

	public Role selectUserByUsernameAndPassword(String username, String password);
}
