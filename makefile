
JFLAGS =
JC = javac
JCC = javacc
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES	= \
	Exp.java \
	Bin.java \
	Una.java \
	Ins.java \
	Print.java \
	Eval2.java \
	AST.java \
	Val.java \
	Var.java \
	Context.java \
	GenCtx.java \
	LetIn.java \
	Bool.java \
	For.java \
	While.java \
	CharC.java \
	ErrorType.java \
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
	$(JCC) Jagger.jj
	make classes
	$(JC) Jagger.java
	
test: test.txt
	java Jagger test.txt
	
clean: 
	$(RM) *.class