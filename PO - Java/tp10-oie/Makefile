all: compile jar tst run clean
	
tst: compile WarpCellTest.class WaitCellTest.class TrapCellTest.class StartCellTest.class NormalCellTest.class GooseCellTest.class GooseBoardTest.class
	java -jar test-1.7.jar goosegame.WarpCellTest
	java -jar test-1.7.jar goosegame.WaitCellTest
	java -jar test-1.7.jar goosegame.TrapCellTest
	java -jar test-1.7.jar goosegame.NormalCellTest
	java -jar test-1.7.jar goosegame.GooseCellTest
	java -jar test-1.7.jar goosegame.GooseBoardTest

clean:
	rm -rf classes
	rm -f test/goosegame/*.class

run:
	java -jar GooseGame.jar

doc: compile
	cd src; \
	javadoc goosegame -d ../docs -author

jar: compile doc
	jar cvfm GooseGame.jar manifest-ex docs test -C classes goosegame

compile:
	mkdir classes; \
	cd src; \
	javac goosegame/GooseMain.java -d ../classes

WarpCellTest.class:
	javac -classpath test-1.7.jar test/goosegame/WarpCellTest.java

WaitCellTest.class:
	javac -classpath test-1.7.jar test/goosegame/WaitCellTest.java

TrapCellTest.class:
	javac -classpath test-1.7.jar test/goosegame/TrapCellTest.java
StartCellTest.class:
	javac -classpath test-1.7.jar test/goosegame/StartCellTest.java
NormalCellTest.class:
	javac -classpath test-1.7.jar test/goosegame/NormalCellTest.java
GooseCellTest.class: 
	javac -classpath test-1.7.jar test/goosegame/GooseCellTest.java
GooseBoardTest.class:
	javac -classpath test-1.7.jar test/goosegame/GooseBoardTest.java
	




