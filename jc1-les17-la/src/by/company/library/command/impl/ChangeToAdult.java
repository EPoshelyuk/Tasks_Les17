package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class ChangeToAdult implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String surname = mas[2];

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userservice = serviceFactory.getUserService();

			boolean res = userservice.changeToAdult(name, surname);

			if (res) {
				response = "The change was successfully completed.";
			} else {
				response = "The change was not completed.";
			}
		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error duiring procedure.";
		}

		return response;
	}

}
