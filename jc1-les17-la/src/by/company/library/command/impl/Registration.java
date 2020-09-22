package by.company.library.command.impl;

import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String surname = mas[2];
			boolean adult = Boolean.valueOf(mas[3]);
			String login = mas[4];
			int password = Integer.valueOf(mas[5]);

			User user = new User(name, surname, adult, login, password);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userservice = serviceFactory.getUserService();

			if (userservice.registration(user)) {
				response = "Registration was successfully completed.";
			} else
				response = "Registration was not completed.";
		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error duiring registration";
		}

		return response;
	}

}
