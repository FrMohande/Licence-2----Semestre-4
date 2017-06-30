package trie;

import java.util.*;

/**
 * @author : Eddy El Khatib
 */

public class CompactTrie {
	private Map<Character,CompactTrie> children;
	private boolean endOfWord ;
	private String value ;
	private static int nodeNumber = 0;

	public CompactTrie() {
		this.children = new HashMap<Character,CompactTrie>();
		this.endOfWord = false;
		this.value = "";
	}

	private CompactTrie(String s){
		this.children = new HashMap<Character, CompactTrie>();
		this.endOfWord = true ;
		this.value = s;
	}

	/**
	 *	Adds a word in this CompactTrie, according to 
	 *	the instructions given for the exercise
	 *	@param s
	 *		the word to be added in the CompactTrie
	 */

	public void add(String s){
		if(this.value.isEmpty()) {
			char c = s.charAt(0);
			if(this.children.containsKey(c))
				this.children.get(c).add(s);
			else
				this.children.put(c, new CompactTrie(s));
		}
		
		String prefix = greatestCommonPrefix(s, this.value);
		String reste = s.substring(prefix.length());
		String resteThis = this.value.substring(prefix.length());
		if(!prefix.isEmpty()){
			if(prefix.equals(s))
				this.endOfWord = true;
			else
				this.endOfWord = false;
			this.value = prefix;
		} 
		if(!resteThis.isEmpty()){
			CompactTrie tmp = new CompactTrie(resteThis);
			for(Map.Entry<Character,CompactTrie> x : this.children.entrySet()){
				tmp.children.put(x.getKey(), x.getValue());
			}
			this.children.clear();
			this.children.put(resteThis.charAt(0), tmp);
		}
		if(!reste.isEmpty()){
			char c = reste.charAt(0);
			if(this.children.containsKey(c))
				this.children.get(c).add(reste);
			else
				this.children.put(c,new CompactTrie(reste));
		}
		
			
	}


	/**
	 *	This Add function allows the function not to add words, but directly 
	 *	CompactTries (used in the "add" function, to transfer CompactTries from
	 *	one to another when a new one as to be put between to other)
	 *	Exemple : Citron -> nier | ADD "Ci" | Ci -> tron -> [nier]) the 
	 *	part of word [nier], had to be moved from the "Citron" CompactTrie 
	 *	to the "tron" one.
	 *	@param	x
	 *		The compact trie to be transfered
	 */
	public void add(CompactTrie x){
		this.children.put(x.value.charAt(0), x);
	}

	/**
	 *	Determines the greatest common prefix of between two words
	 *	@param a
	 *		the first word
	 *	@param b
	 *		the second word
	 *	@return a string representing the 
	 */

	private static String greatestCommonPrefix(String a, String b) {
    	int minLength = Math.min(a.length(), b.length());
    	for (int i = 0; i < minLength; i++) {
        	if (a.charAt(i) != b.charAt(i)) {
            	return a.substring(0, i);
        	}
    	}
    	return a.substring(0, minLength);
	}	


	/**
	 *	Determines if this CompactTrie contains the word
	 *	given in parameter
	 *	@param s
	 *		the word to be searched in the CompactTrie
	 *	@return <tt>true</tt> if the word is contained in the CompactTrie
	 */
	public boolean contains(String s){
		boolean start = false;
		String reste = "";
		String prefix = "";
		CompactTrie tmp ;
		char c;
		if(s.equals(this.value)) {
			return this.endOfWord;
		}else{
			prefix = greatestCommonPrefix(this.value, s);
			reste = s.substring(prefix.length());
			c = reste.charAt(0);
			if(!prefix.equals(this.value) || !this.children.containsKey(c)) {
				return false;
			}
			return this.children.get(c).contains(reste);
		}
	}


	/**
	 *	Print the CompactTrie following the syntax given 
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
		int currentNumber = CompactTrie.nodeNumber;
		CompactTrie tmp ;
		for(char tmpKey : this.children.keySet()){
				CompactTrie.nodeNumber ++;
				tmp = this.children.get(tmpKey);
				if(tmp.endOfWord)
					System.out.println("  " + CompactTrie.nodeNumber + " [style=filled,color=blue];");
				else
					System.out.println("  " + CompactTrie.nodeNumber + " [style=filled,color=pink];");
				System.out.println("  " + currentNumber + " -> " + CompactTrie.nodeNumber + " [label=\" " + tmp.value + "\"];");
				tmp.printUtil();
		}
	}
}
