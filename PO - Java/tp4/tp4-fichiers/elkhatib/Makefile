all: jar monBoxTest.class doc

doc: jar
	jar cvfm appli.jar manifest-ex docs test -C classes example

tst: compile monBoxTest.class
	java -jar test-1.7.jar monBoxTest
	
run: compile jar
	java -classpath classes example.Robot

jar: compile
	jar cvf appli.jar classes/example
	
clean:
	rm -rf classes
	rm -f test/*.class

compile:
	mkdir classes; \
	cd src; \
	javac example/Robot.java -d ../classes

monBoxTest.class: compile
	javac -classpath test-1.7.jar test/monBoxTest.java
