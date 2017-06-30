all: jar tst clean
	
tst: ImageTest.class GrayColorTest.class PixelTest.class
	java -jar test-1.7.jar image.color.GrayColorTest
	java -jar test-1.7.jar image.PixelTest
	java -jar test-1.7.jar image.ImageTest


clean:
	rm -rf classes
	rm -f test/image/*.class
	rm -f test/image/color/*.class

run: jar
	java -jar image.jar

doc:
	cd src; \
	javadoc image image.color -d ../docs -author

jar: doc compile
	jar cvfm image.jar manifest-ex docs images test -C classes image

compile:
	mkdir classes; \
	cd src; \
	javac image/ImageMain.java -d ../classes

ImageTest.class:
	javac -classpath test-1.7.jar test/image/ImageTest.java

GrayColorTest.class:
	javac -classpath test-1.7.jar test/image/color/GrayColorTest.java

PixelTest.class:
	javac -classpath test-1.7.jar test/image/PixelTest.java
