package ex.aaronfae.graduation.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ex.aaronfae.graduation.configuration.security.JwtAuthenticatioToken;
import ex.aaronfae.graduation.model.vo.HttpResult;
import ex.aaronfae.graduation.model.vo.LoginVO;
import ex.aaronfae.graduation.util.SecurityUtils;

@RestController
/**
 * 登录控制器
 *
 */
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * 登录接口
	 */
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginVO loginBean, HttpServletRequest request) throws IOException {
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();

		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);

		return HttpResult.ok(token);
	}

}