
JFLAGS =
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES	= \
	Exp.java \
	Bin.java \
	Visitor.java \
	VisitorVoid.java 
	
default: classes compile

classes: $(CLASSES:.java=.class)

compile:Jagger.jj
	javacc Jagger.jj
	$(JC) Jagger.java
test: test.txt
	java Jagger test.txt
	
clean: 
	$(RM) *.class