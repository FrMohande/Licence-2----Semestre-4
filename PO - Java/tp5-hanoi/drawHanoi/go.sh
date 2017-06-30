#! /bin/bash

jar xvf   drawing.jar
javac -cp drawing.jar:. TestDraw.java
javac -cp drawing.jar:. TstPlat.java  


java -cp drawing.jar:. TestDraw 

java -cp drawing.jar:. TstPlat 

