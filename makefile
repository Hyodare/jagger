
JFLAGS =
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES	= \
	Exp.java \
	Bin.java \
	Una.java \
	Ins.java \
	Print.java \
	AST.java \
	Visitor.java \
	VisitorVoid.java \
	PrettyPrinter.java 
	
default: classes compile

classes: $(CLASSES:.java=.class)

complet:
	make clean
	make compile
	make test
compile:Jagger.jj
	javacc Jagger.jj
	$(JC) Jagger.java
	make classes
test: test.txt
	java Jagger test.txt
	
clean: 
	$(RM) *.class