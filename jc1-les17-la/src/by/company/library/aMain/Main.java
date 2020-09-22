package by.company.library.aMain;
import java.io.IOException;
import java.text.ParseException;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.command.exception.CommandException;
import by.company.library.command.impl.DeleteBook;
import by.company.library.command.impl.Logination;
import by.company.library.command.impl.Registration;
import by.company.library.controller.Controller;
import by.company.library.dao.exception.DAOException;
import by.company.library.dao.impl.BookDaoImpl;
import by.company.library.dao.impl.UserDaoImpl;
import by.company.library.service.exception.ServiceException;
import by.company.library.service.impl.BookServiceImpl;
import by.company.library.service.impl.UserServiceImpl;

public class Main {
	public static void main(String[] args) throws DAOException, CommandException, ServiceException {

	
		//Controller con=new Controller();
		//System.out.println(con.doAction("LOGINATION  Masha 77779"));
		
		//Controller con=new Controller();
		//System.out.println(con.doAction("REGISTRATION Petrov Petr false PP 963"));
	
		//Controller con=new Controller();
		//System.out.println(con.doAction("DELETE_BOOK Pet_Sematary Stephen_king 2006 true"));
		//name=Pet_Sematary, author=Stephen_king, year=2006, onlyForAdults=true
		
		//Controller con=new Controller();
		//System.out.println(con.doAction("ADD_NEW_BOOK Pet_Sematary Stephen_king 2006 true"));
		
		//Controller con=new Controller();
		//System.out.println(con.doAction("CHANGE_TO_ADULT Ivanov Vasiliy"));
		
	}

}
