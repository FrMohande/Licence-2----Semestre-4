package trie;


import java.util.*;


/**
 * @author : Eddy El Khatib
 */

public class Trie {
	private boolean endOfWord ;
	private Map<Character,Trie> children;
	private static int nodeNumber = 0;

	public Trie(){
		this.children = new HashMap<Character,Trie>();
		this.endOfWord = false;
	}


	/**
	 *	Adds a word in this Trie, according to 
	 *	the instructions given for the exercise
	 *	@param s
	 *		the word to be added in the Trie
	 */

	public void add(String s){
		if(s.isEmpty()) {
			this.endOfWord = true;
		}else{
			char c = s.charAt(0);
			if(this.children.containsKey(c))
				this.children.get(c).add(s.substring(1));
			else{
				Trie tmp = new Trie();
				this.children.put(c,tmp);
				tmp.add(s.substring(1));
			}
		}
	}

	/**
	 *	Determines if this Trie contains the word
	 *	given in parameter
	 *	@param s
	 *		the word to be searched in the Trie
	 *	@return <tt>true</tt> if the word is contained in the Trie
	 */

	public boolean contains(String s){
		if(s.isEmpty()) return this.endOfWord;
		if(!this.children.containsKey(s.charAt(0))) return false;
		else return this.children.get(s.charAt(0)).contains(s.substring(1));
	}

	/**
	 *	Print the Trie following the syntax given 
	 *	in the instructions to create a cool Dot graphic  
	 */
	public void print(){
		System.out.println("digraph G {");
		this.printUtil();
		System.out.println("}");
	}

	/**
	 *	Function to complete print task
	 */

	private void printUtil(){
		int currentNumber = Trie.nodeNumber;
		Trie tmp ;
		for(char tmpKey : this.children.keySet()){
			Trie.nodeNumber++;
			tmp = this.children.get(tmpKey);
			if(tmp.endOfWord)
				System.out.println("  " + Trie.nodeNumber + " [style=filled,color=blue];");
			else
				System.out.println("  " + Trie.nodeNumber + " [style=filled,color=pink];");
			System.out.println("  " + currentNumber + " -> " + Trie.nodeNumber + " [label=\" " + tmpKey + "\"];");
			tmp.printUtil();
		} 
	}
}
