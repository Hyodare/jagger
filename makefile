
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES	= \
	Exp.java \
	Bin.java \
	Add.java \
	Mul.java \
	Div.java \
	Sub.java \
	Visitor.java \
	VisitorVoid.java 
	
default: classes

classes: $(CLASSES:.java=.class)

clean: 
	$(RM) *.class