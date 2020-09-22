package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import by.company.library.bean.User;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;

public class UserDaoImpl implements UserDao {

	private final String PATH = "D:/workspace/jc1-les17-la/src/resources/User";

	@Override
	public boolean registerUser(User user) throws DAOException {
		boolean respond;
		StringBuffer str = new StringBuffer("name=" + user.getName() + ", surname=" + user.getSurname() + ", adult="
				+ user.isAdult() + ", " + "login=" + user.getLogin() + ", password=" + user.getPassword());
		FileWriter writer = null;

		try {
			writer = new FileWriter(PATH, true);
			writer.write(str + "\n");
			respond = true;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return respond;

	}

	@Override
	public boolean logination(String login, int password) throws DAOException {
		boolean respond = false;
		FileReader reader = null;
		Scanner sc = null;
		try {
			reader = new FileReader(PATH);
			sc = new Scanner(reader);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains(login)) {
					String strPassword = String.valueOf(password);
					if ((line.contains(strPassword))) {
						respond = true;
					}
				}
			}
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			sc.close();
		}
		return respond;
	}

	@Override
	public boolean changeToAdult(String name, String surname) throws DAOException {
		boolean respond = false;
		File sourceFile = new File(PATH);
		File outputFile = new File("TEMP_PATH");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(sourceFile));
			writer = new BufferedWriter(new FileWriter(outputFile));

			while ((line = reader.readLine()) != null) {

				if (line.contains(name) & line.contains(surname) == false) {
					writer.write(line);
					writer.newLine();

				} else {
					String newLine = line.replace("false", "true");
					writer.write(newLine);
				}
				respond = true;
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);

		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			sourceFile.delete();
			outputFile.renameTo(sourceFile);
		}

		return respond;

	}

}