
/**
 * (Documentation should be in english...)
 * un regroupement de livres
 * 
 * @author JC
 * @version 1.0
 */

import java.util.*;

/**
 * Pour simplifier dans cet exemple introductif, les livres sont stockes dans un
 * tableau.
 */
public class Library {
	// definition d'une constante pour le nombre max de livres
	private static final int NB_BOOKS_MAX = 10;
	// les attributs de la classe Library

	/** le tableau de livres */
	private Book[] theBooks;
	/** le nombre de livres actuellement dans la bibliotheque */
	private int nbBooks;

	/**
	 * Constructor for objects of class Library
	 */
	public Library() {
		this.theBooks = new Book[NB_BOOKS_MAX];
		this.nbBooks = 0;
	}

	// les methodes de la classe Library

	/**
	 * ajoute un livre a la bibliotheque si il y a de la place, sinon rien ne se
	 * passe
	 * 
	 * @param book
	 *            le livre a ajouter
	 */
	public void addBook(Book book) {
		if (nbBooks < theBooks.length) {
			this.theBooks[nbBooks] = book;
			nbBooks = nbBooks + 1;
		}
	}

	/**
	 * affiche la liste des livres
	 */
	public void displayAllBooks() {
	    System.out.println("Books in this library : ");
		int cpt = 0;
		while (cpt < this.nbBooks) {
			this.theBooks[cpt].display();
			cpt = cpt + 1;
		}
	}

	/**
	 * retourne le nombre de livres de la bibliotheques
	 */
	public int getNumberOfBooks() {
		return this.nbBooks;
	}

}
