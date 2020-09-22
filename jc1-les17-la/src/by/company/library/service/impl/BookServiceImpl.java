package by.company.library.service.impl;

import by.company.library.bean.Book;
import by.company.library.dao.BookDao;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class BookServiceImpl implements UpdateLibraryService {

	@Override
	public boolean addNewBook(Book book) throws ServiceException {
		boolean res = false;
		if (book.getName().isEmpty() || book.getName() == null) {
			throw new ServiceException("Incorrect name");
		}
		if (book.getAuthor().isEmpty() || book.getAuthor() == null) {
			throw new ServiceException("Incorrect author");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			BookDao bookDAO = daoFactory.getBookDAO();
			bookDAO.addBook(book);
			res = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {
		boolean res = false;
		if (book.getName().isEmpty() || book.getName() == null) {
			throw new ServiceException("Incorrect name");
		}
		if (book.getAuthor().isEmpty() || book.getAuthor() == null) {
			throw new ServiceException("Incorrect author");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			BookDao bookDAO = daoFactory.getBookDAO();
			bookDAO.deleteBook(book);
			res = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;
	}

}
