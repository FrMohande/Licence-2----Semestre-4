all: figure1 figure2 doc test

doc : src/trie/Trie.java test/trie/TrieTest.java
	cd src; \
	javadoc trie -d ../docs -author

classes/trie/Trie.class : src/trie/Trie.java
	javac -d classes -cp classes -sourcepath src src/trie/Trie.java

TrieMain : classes/TrieMain.class

classes/TrieMain.class : src/TrieMain.java classes/trie/Trie.class
	javac -d classes -cp classes -sourcepath src src/TrieMain.java

figure1 : classes/TrieMain.class
	java -cp classes TrieMain > test1.dot
	dot -Tpdf test1.dot -otest1.pdf

clean:
	rm -f test?.pdf test?.dot
	rm -f classes/*.class classes/trie/*.class
	rm -f test/trie/*.class

classes/trie/CompactTrie.class : src/trie/CompactTrie.java
	javac -d classes -cp classes -sourcepath src src/trie/CompactTrie.java

CompactTrieMain : classes/CompactTrieMain.class

classes/CompactTrieMain.class : src/CompactTrieMain.java classes/trie/CompactTrie.class
	javac -d classes -cp classes -sourcepath src src/CompactTrieMain.java

figure2 : classes/CompactTrieMain.class
	java -cp classes CompactTrieMain > test2.dot
	dot -Tpdf test2.dot -otest2.pdf

TrieTest.class : test/trie/TrieTest.java
	javac -classpath test-1.7.jar test/trie/TrieTest.java

CompactTrieTest.class : test/trie/CompactTrieTest.java
	javac -classpath test-1.7.jar test/trie/CompactTrieTest.java

test: classes/trie/CompactTrie.class TrieTest.class CompactTrieTest.class
	java -jar test-1.7.jar trie.TrieTest
	java -jar test-1.7.jar trie.CompactTrieTest






