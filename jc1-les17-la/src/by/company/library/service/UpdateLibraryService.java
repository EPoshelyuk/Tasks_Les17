package by.company.library.service;

import by.company.library.bean.Book;
import by.company.library.service.exception.ServiceException;

public interface UpdateLibraryService {
	public boolean addNewBook(Book book) throws ServiceException;

	public boolean deleteBook(Book book) throws ServiceException;
}
