package DAO.Interface;

import java.util.List;

import javax.sql.DataSource;

import model.Account;

public interface AccountDAOInterface {
	public void setDataSource (DataSource datasource);
	public Account search (String usermail, String password, int role);
	public List<Account> getAllAccounts();
}
