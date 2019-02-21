package ex.aaronfae.graduation.service;

import java.util.Set;

import ex.aaronfae.graduation.entity.User;

/**
 * 用户服务接口
 * 
 * @author AaronFae
 *
 */
public interface UserService {

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 查找用户的菜单权限标识集合
	 * 
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String username);

}