
/**
 * (Documentation should be in english...) Les informations sur un auteur de
 * <i>Book</i>
 * 
 * @author JC
 * @version 1.0
 */

public class Author {
	/**
	 * Constructor for objects of class Author
	 */
	public Author(String name, String firstname, int birthYear) {
		this.name = name;
		this.firstname = firstname;
		this.birthYear = birthYear;
	}

	// les attributs de la classe Author
	private String name;
	private String firstname;
	private int birthYear;
	private int deathYear;

	// les methodes de la classe Author

	/**
	 * affiche les informations sur l'auteur
	 */
	public void display() {
		System.out.println(this.firstname + " " + this.name + " born in " + this.birthYear);
	}

	/**
	 * met a jour la date de deces
	 *
	 * @param deathYear
	 *            la date de deces de l'auteur
	 */
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
}
