package by.company.library.dao;

import by.company.library.bean.User;
import by.company.library.dao.exception.DAOException;

public interface UserDao {

	public boolean registerUser(User user) throws DAOException;

	public boolean logination(String login, int password) throws DAOException;

	public boolean changeToAdult(String name, String surname) throws DAOException;

}
