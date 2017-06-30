
/**
 * (Documentation should be in english...) Seconde version de livre pour un
 * premier contatc avec les objets
 * 
 * @author jc
 * @version 1.0
 */

public class Book {
	/**
	 * 
	 * @param author l'auteur du livre
	 * @param titlele titre du livre
	 * @param year l'annee de parution du livre
	 * @param text le texte du livre
	 */
	public Book(Author author, String title, int publicationYear, String text) {
		this.author = author;
		this.title = title;
		this.publicationYear = publicationYear;
		this.text = text;
	}

	// les attributs de la classe Book

	private Author author;
	private String title;
	private int publicationYear;
	private String text;

	// les methodes de la classe Book

	/**
	 * affiche les informations sur le livre
	 */
	public void display() {
		System.out.println(this.title);
		System.out.println(" by ");
		this.author.display();
		System.out.println(" published in " + publicationYear);
	}

	/**
	 * lit le livre (affiche le texte)
	 */
	public void read() {
		System.out.println(this.text);
	}

	/**
	 * retourne l'auteur de livre
	 * 
	 * @return l'auteur du livre
	 */
	public Author getAuthor() {
		return this.author;
	}
}
