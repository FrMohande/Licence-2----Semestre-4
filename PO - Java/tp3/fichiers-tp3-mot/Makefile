all: Word.class WordTest.class doc

doc:
	javadoc Word.java -d docs

tst: Word.class
	java -jar test-1.7.jar WordTest
	
run: Word.class
	java Word timoleon
	
clean:
	rm Word.class

Word.class: Word.java
	javac Word.java

WordTest.class: WordTest.java
	javac WordTest.java
	
