package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class DeleteBook implements Command {
	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String author = mas[2];
			int year = Integer.valueOf(mas[3]);
			boolean onlyForAdults = Boolean.valueOf(mas[4]);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UpdateLibraryService bookservice = serviceFactory.getLibraryService();

			Book book = new Book(name, author, year, onlyForAdults);
			boolean res = bookservice.deleteBook(book);
			if (res) {
				response = "The book was deleted";
			} else {
				response = "The book wasn't deleted";
			}
		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error duiring procedure.";
		}

		return response;
	}

}
