package controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.wls.shaded.org.apache.xalan.xsltc.dom.ForwardPositionIterator;

import DAO.AccountJDBCTemplate;
import model.Account;

@Controller
public class LoginController {
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		ApplicationContext context = new ClassPathXmlApplicationContext("login-servlet.xml");

		AccountJDBCTemplate accountJDBCTemplate = (AccountJDBCTemplate) context.getBean("accountJDBCTemplate");
		// tim mot account co email, password and role cua admin: account_role=1
		Account ad = accountJDBCTemplate.search(username1, password1, 1);

		// tim mot account co email, password and role cua user: account_role=0
		Account user = accountJDBCTemplate.search(username, password, 0);

		if (username != null && password != null) {
			if (username.trim().equals("") && password.trim().equals("")) {
				return new ModelAndView("login", "error", "Please enter username and password");
			} else if (user != null && username.equalsIgnoreCase(user.getUsermail())
					&& password.equals(user.getPassword()) && user.getAccount_role() == 0) {
				return new ModelAndView("confirmation", "username", "Welcome<br/>" + user.getUser_name());
			} else if (ad != null && username1.equalsIgnoreCase(ad.getUsermail()) && password1.equals(ad.getPassword())
					&& ad.getAccount_role() == 1) {
				return new ModelAndView("admin", "username", "Welcome<br/>" + ad.getUser_name());
			} else {
				return new ModelAndView("login", "error", "Username or password is invalid");
			}
		}

		return new ModelAndView("login", "error", "");
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.removeAttribute("username");
		return new ModelAndView("home", "username", "");
	}

	/**
	 * Ý tưởng là bắt bất kỳ url nào có phần mở rộng là html và chỉ bắt tên tệp sau
	 * đó sẽ trả về chế độ xem có tên của tên tệp (chế độ xem trong thư mục
	 * web-inf/jsp/) nếu tên tệp giống với bất kỳ url RequestMapping nào sẽ gọi
	 * phương thức ánh xạ
	 * 
	 * @param fileName
	 * @return
	 */
	@RequestMapping("/{fileName}.html")
	public String Filter(@PathVariable String fileName) {
		return fileName;
	}
}
