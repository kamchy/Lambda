JAVA_BIN = $(HOME)/external/pobrane/jdk1.8.0/bin
OUT_DIR = ../bin/
SRC = pl/chyla/lambda/
JFLAGS = -g -Xlint:unchecked -d $(OUT_DIR)
JC = $(JAVA_BIN)/javac
JAVA = $(JAVA_BIN)/java

CLASSES = \
	$(SRC)/FunctionalCollections.java \
	$(SRC)/Main.java \
	$(SRC)/sam/Factory.java

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

