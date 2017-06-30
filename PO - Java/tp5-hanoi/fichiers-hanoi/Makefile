all: jar
	
tst: DiscTest.class
	java -jar test-1.7.jar DiscTest

tst2: TowerTest.class
	java -jar test-1.7.jar TowerTest

tst3: PlateauTest.class
	java -jar test-1.7.jar PlateauTest

clean:
	rm -rf classes
	rm -f test/*.class

doc:
	cd src; \
	javadoc hanoi hanoi.util -d ../docs -author

jar: doc compile
	cd classes; \
	jar cvfm ../hanoi.jar ../manifest-ex hanoi io
	jar cvfm hanoi.jar manifest-ex docs test -C classes hanoi io

compile:
	mkdir classes; \
	cd src; \
	javac hanoi/Hanoi.java -d ../classes

PlateauTest.class:
	javac -classpath test-1.7.jar test/PlateauTest.java

DiscTest.class:
	javac -classpath test-1.7.jar test/DiscTest.java

TowerTest.class:
	javac -classpath test-1.7.jar test/TowerTest.java
