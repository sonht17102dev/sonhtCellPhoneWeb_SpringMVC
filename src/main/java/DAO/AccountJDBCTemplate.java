package DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import DAO.Interface.AccountDAOInterface;
import model.Account;

public class AccountJDBCTemplate implements AccountDAOInterface{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	/*
	 * Ham search thuc hien truy van trong database tra ve Account 
	 * dua vao usermail, password, account_role
	 */
	@Override
	public Account search(String usermail, String password, int role) {
		String sql = "select * from account where user_mail=? and password=? and account_role=?";
		List<Account> acc = (List<Account>) jdbcTemplateObject.query(sql, new AccountMapper(), new Object[] {usermail,password, role});
		if (acc.size()==0) return null;
		return acc.get(0);
	}
	@Override
	public List<Account> getAllAccounts() {
		String sql = "select * from account";
		List<Account> accoutList = jdbcTemplateObject.query(sql, new AccountMapper());
		return accoutList;
	}
	
}
