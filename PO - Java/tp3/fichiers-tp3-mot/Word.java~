/**
 * Word class : methods on Words (tp3) licence S4 - UE POO
 * 
 * @author : Eddy El Khatib
 */

public class Word {

	// ATTRIBUTS
        /* contains the string that represents the charcter of this word */
	private String value;


	public static void main (String[] args){
		Word monWord = new Word(args[0]);
		Word wordVideBug = new Word("");
		System.out.println(wordVideBug.nbOfChars());
		System.out.println(wordVideBug.isProperNoun());
		System.out.println(monWord.nbOfChars());
		System.out.println(monWord.toString());
		Word word2 = monWord.reverse();
		System.out.println(word2.toString());
		System.out.println(word2.nbOccurrencesOfChar('o'));
		Word word3 = new Word("eon");
		System.out.println(monWord.rhymesWith(word3));
		System.out.println(monWord.contains(word3));
		Word[] tab = monWord.extractBefore('o');
		System.out.println(tab[0].toString());
		System.out.println(tab[1].toString());
		Word word4 = new Word("kayak");
		System.out.println(word4.isPalindrome());
		System.out.println(monWord.isAnagram(word4));
		Word word5 = new Word("MotiLeon");
		System.out.println(monWord.isAnagram(word5));
		System.out.println(word4.isProperNoun());
		System.out.println(word5.isProperNoun());
	}

	// CONSTRUCTEURS
	public Word(String s) {
		this.value = s;
	}

	// METHODES
	/**
	 * returns <code>true</code> if <code>o</code> is equals to this word object, ie if
	 * <code>o</code> is a Word and its value is the same as this word's value
	 * 
	 * @param o
	 *            the object to be compared with this Word
	 * @return <code>true</code> iff <code>o</code> is a Word with the same value as this word.
	 */
	public boolean equals(Object o) {
		if (o instanceof Word) {
			Word theOther = (Word) o;
			return this.value.equals(theOther.value);
		} else {
			return false;
		}
	}

	/**
	 * returns the length of this word object, "value" attribute
	 * @return an integer representing this Word object's "value" attribute length.
	 */
	public int nbOfChars() {
		return this.value.length();
	}

	/**
	 * returns the value attribute of this Word object.
	 * @return the value attribute of this Word object.
	 */
	public String toString() {
		return this.value;
	}

	/**
	 * returns the number of occurences of the character <code>c</code> in this Word object "value" attribute.
	 * Warning: that method also detects Uppercase character as occurences of Lowercase ones "Kayak" has 2 occurences of 'k'
	 *
	 * @param c
	 * 			the character which the occurences in this Word "value" attribute will be counted.
	 * @return an integer representing the number of times the character <code>c</code> appears in the Word.
	 */
	public int nbOccurrencesOfChar(char c) {
		int cpt = 0 ;
		char lowChar = Character.toLowerCase(c);
		int lastId = this.value.toLowerCase().indexOf(c,0);
		while(lastId!= (-1)) {
			cpt++;
			lastId = this.value.toLowerCase().indexOf(c, lastId+1);
		}
		return cpt;
	} // nbOccurrencesOfChar

	/**
	 * returns a Word object which the "value" attribute is the mirror word of this object "value" attribute.
	 *
	 * @return a Word containing the mirror word of this object "value" attribute or containing an empty string 
	 * 			if this object is also empty.
	 */
	public Word reverse() {
		String monString = "" ;
		int nbChar = this.nbOfChars() ;

		if(nbChar > 0){
			for(int i = nbChar-1; i>=0;i--){
				monString += this.value.charAt(i);
			}
		}

		return new Word(monString);
	}

	/**
	 * returns <code>true</code> if this Word object value attribute is a palindrome ("kayak" for exemple is a palindrome).
	 *
	 * @return <code>true</code> if this word object is equal to his reverse.
	 */
	public boolean isPalindrome() {
		return this.reverse().equals(this);
	} // estPalindrome

	/**
	 * returns <code>true</code> if this Word object value attribute contains <code>m</code>'s one.
	 * for example, if this value attribute is "kamehameha" and <code>m</code>'s one is "kame", then <code>true</code>
	 * will be returned.
	 *
	 * @param m
	 *			word object which this Word object value will be compared to, in order to confirm or not, that <code>m</code>
	 *			is contained in it.
	 * @return <code>true</code> if the <code>m</code> value attribute is contained in this one. 
	 * 
	 */
	public boolean contains(Word m) {
		int taille = m.nbOfChars();

		if(this.nbOfChars() >= taille){
			int lastId = this.value.indexOf(m.toString().charAt(0));
			while(lastId != -1){
				try{
					if(m.toString().equals(this.value.substring(lastId, lastId+taille))){
						return true;
					}else {
						lastId = this.value.indexOf(m.toString().charAt(0), lastId+1);
					}
				}catch(StringIndexOutOfBoundsException x){
					lastId = -1;
				}
			}
		}

		return false;
	}

	/**
	 * returns <code>true</code> if the <code>m</code> Word rhymes with this Word object. (if the last 3 characters of the
	 * <code>m</code> word value attribute are the same characters as the last 3 characters of this Word value last
	 * 3 characters.
	 * 
	 * @param m
	 *			the word object which the value attributes last 3 characters are compared to this Word object value last 3 characters
	 * @return <code>true</code> if the m Word object rhymes with this Word Object
	 */
	public boolean rhymesWith(Word m) {
		if(m.nbOfChars() >= 3 && this.nbOfChars() >= 3) {
			return this.value.endsWith(m.toString().substring(m.nbOfChars()-3));
		}else {
			return false ;
		}

		 
	}

	/**
	 * returns <code>true</code> if this Word object is a proper noun (if its value attribute begins with an uppercase)
	 *
	 * @return <code>true</code> if this Word object is a proper noun 
	 */
	public boolean isProperNoun() {
		boolean properNounConfirm = false;
		if(this.nbOfChars() > 0)
			properNounConfirm = Character.isUpperCase(this.value.charAt(0));
		return properNounConfirm;
	}

	/**
	 * returns <code>true</code> if this <code>m</code> word object value is an anagram of this word object value 
	 * "kayak" for example is an anagram of "akayk", also that method works for Uppercase characters : "Kayak" is an anagram of "yakak"
	 *
	 * @param m
	 *			the Word object which is compared to this word object to determine whether or not it is one 
	 *			of its anagrams. 
	 * @return <code>true</code> if this Word object value attribute's letters have the exact same number of
	 * 			occurences as the <code>m</code> Word value attribute.
	 */
	public boolean isAnagram(Word m) {
		int taille = this.nbOfChars() ;
		boolean anagramConfirm = false ;
		if(taille == m.nbOfChars()){
			anagramConfirm = true ;
			int i = 0;
			while(i<taille && anagramConfirm){
				char currentChar = this.value.charAt(i);
				if(this.nbOccurrencesOfChar(currentChar) != m.nbOccurrencesOfChar(currentChar))
					anagramConfirm = false;
				i++;
			}
		}
		return anagramConfirm;
	}

	/**
	 * returns an Array of 2 Word objects, the first word object contains this word object value attribute until the first
	 * occurence of the <code>c</code> character. The second Word object contains the rest of this word object value attribute
	 * (the part from the first letter after the first occurence of <code>c</code>, until the end of value). If the word doesn't
	 * contain the character <code>c</code>, the first Word of the Array will be an empty one.
	 *
	 * @param c
	 *			the character that will serve as a separator in order to create the Word objects to return in the Array
	 * @return a 2 Word objects Array, the first Word value is the first part of this Word value attribute until <code>c</code>
	 *			 occurs	or an empty String if it never occurs, the second Word value will contain the rest of this Word value attribute.
	 */
	public Word[] extractBefore(char c) {
		int taille = this.nbOfChars() ;
		int index = this.value.toLowerCase().indexOf(c);

		Word w1 = new Word(this.value.substring(0,index+1));
		Word w2 = new Word(this.value.substring(index+1,taille));
		Word[] tab = {w1,w2};

		return tab;
	}

}
