all: clean
	javac MntHl.java
clean:
	rm *.class
r: all
	appletviewer MntHl.html
