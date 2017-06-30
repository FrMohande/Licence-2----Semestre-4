all: compile jar tst clean
	
tst: PlayerTest.class ShapeTest.class 
	java -jar test-1.7.jar rps.PlayerTest
	java -jar test-1.7.jar rps.ShapeTest


clean:
	rm -rf classes
	rm -f test/rps/*.class
	rm -f test/rps/strategy/*.class

run:
	java -jar Game.jar

doc: compile
	cd src; \
	javadoc rps rps.strategy -d ../docs -author

jar: compile doc
	jar cvfm Game.jar manifest-ex docs test -C classes rps classes/util

compile:
	mkdir classes; \
	cd src; \
	javac rps/GameMain.java util/Input.java -d ../classes

PlayerTest.class:
	javac -classpath test-1.7.jar test/rps/PlayerTest.java

ShapeTest.class:
	javac -classpath test-1.7.jar test/rps/ShapeTest.java
