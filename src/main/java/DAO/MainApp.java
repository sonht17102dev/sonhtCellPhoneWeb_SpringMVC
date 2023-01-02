package DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import model.Account;
import DAO.*;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("login-servlet.xml");

		AccountJDBCTemplate accountJDBCTemplate = (AccountJDBCTemplate) context.getBean("accountJDBCTemplate");

//		Account adAccount = accountJDBCTemplate.search("duongdt@fpt.com.vn", "123",1);
//		System.out.println(adAccount.toString());
		List<Account> accounts = accountJDBCTemplate.getAllAccounts();
		for (Account account : accounts) {
			System.out.println(account.toString());
		}
	}

}
