package by.company.library.bean;

public class Book {

	private String name;
	private String author;
	private int year;
	private boolean onlyForAdults;

	public Book(String name, String author, int year, boolean onlyForAdults) {
		this.name = name;
		this.author = author;
		this.year = year;
		this.onlyForAdults = onlyForAdults;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public boolean isOnlyForAdults() {
		return onlyForAdults;
	}

	public void setOnlyForAdults(boolean onlyForAdults) {
		this.onlyForAdults = onlyForAdults;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (onlyForAdults ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (onlyForAdults != other.onlyForAdults)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", year=" + year + ", onlyForAdults=" + onlyForAdults
				+ "]";
	}

}
