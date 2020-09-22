package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.company.library.bean.Book;
import by.company.library.dao.BookDao;
import by.company.library.dao.exception.DAOException;

public class BookDaoImpl implements BookDao {

	private final String PATH = "D:/workspace/jc1-les17-la/src/resources/Book";

	@Override
	public boolean addBook(Book book) throws DAOException {
		boolean res = false;

		StringBuffer str = new StringBuffer("name=" + book.getName() + ", author=" + book.getAuthor() + ", year="
				+ book.getYear() + ", onlyForAdults=" + book.isOnlyForAdults());

		FileWriter writer = null;

		try {
			writer = new FileWriter(PATH, true);
			writer.write(str + "\n");
			res = true;
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);

		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return res;
	}

	@Override
	public boolean deleteBook(Book book) throws DAOException {
		boolean res = false;

		StringBuffer str = new StringBuffer("name=" + book.getName() + ", author=" + book.getAuthor() + ", year="
				+ book.getYear() + ", onlyForAdults=" + book.isOnlyForAdults());

		File sourceFile = new File(PATH);
		File outputFile = new File("TEMP_PATH");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String line;

		try {
			reader = new BufferedReader(new FileReader(sourceFile));
			writer = new BufferedWriter(new FileWriter(outputFile));

			while ((line = reader.readLine()) != null) {
				if (!line.equals(str.toString())) {
					writer.write(line);
					writer.newLine();
				}
			}
			res = true;

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
		return res;
	}
}