package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class Logination implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");

		String login = mas[1];
		int password = Integer.valueOf(mas[2]);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userservice = serviceFactory.getUserService();

		try {
			boolean res = userservice.logination(login, password);
			if (res) {
				response = "Logination was successfully completed.";
			} else {
				response = "The user is not found";
			}

		} catch (ServiceException e) {
			response = "Error duiring login procedure.";
		}

		return response;
	}

}
