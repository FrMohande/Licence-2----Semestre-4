/**
 * (Documentation should be in english...) Premiere version de livre pour un
 * premier contact avec les objets
 * 
 * @author jc
 * @version 1.0
 */

public class Book {

	public boolean equals(Object o) {

		if (o instanceof Book) {
			Book l = (Book) o;
			return (this.publicationYear == l.publicationYear) && this.author.equals(l.author)
					&& this.title.equals(l.title);

		} else {
			return false;
		}

	}

	/**
	 * Construit une instance de la classe Book
	 * 
	 * @param author l'auteur du livre
	 * @param titlele titre du livre
	 * @param year l'annee de parution du livre
	 * @param text le texte du livre
	 */
	public Book(String author, String title, int year, String text) {
		this.author = author;
		this.title = title;
		this.publicationYear = year;
		this.text = text;
	}

	// les attributs de la classe Book
	private String author;
	private String title;
	private int publicationYear;
	private String text;

	// les methodes de la classe Book

	/**
	 * donne l' <t>auteur</t> du livre
	 * 
	 * @return l'<t>auteur</t> du livre
	 */
	public String getAuthor() { // ici pas de modificateur setAuthor,
		return this.author; // a priori quand un livre est cree il
	} // ne change pas d'auteur...

	/**
	 * donne le <t>titre</t> du livre
	 * 
	 * @return le <t>titre</t> du livre
	 */
	public String getTitle() {
		return this.title; // idem pour title;
	}

	/**
	 * affiche les informations sur le livre
	 */
	public void display() {
		System.out.println(this.title + " by " + this.author + " published in " + this.publicationYear);
	}

	/**
	 * lit le livre (affiche le texte)
	 */
	public void read() {
		System.out.println(this.text);
	}

}
