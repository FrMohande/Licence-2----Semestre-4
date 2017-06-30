package trie;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {

	@Test
	public void addContainsTest() {
		Trie someTrie = new Trie();
		someTrie.add("citron");
		someTrie.add("ci");
		someTrie.add("banane");
		assertTrue(someTrie.contains("citron"));
		assertTrue(someTrie.contains("banane"));
		assertFalse(someTrie.contains("banan"));
		assertFalse(someTrie.contains("bananee"));
		assertTrue(someTrie.contains("ci"));
		assertFalse(someTrie.contains("pomme"));
	}

	 // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(trie.TrieTest.class);
    }
}
