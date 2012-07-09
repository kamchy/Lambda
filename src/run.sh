JAVA_BIN="$HOME/external/jdk1.8.0/bin"
$JAVA_BIN/javac -Xlint:unchecked -d ../bin/ pl/chyla/lambda/FunctionalCollections.java && $JAVA_BIN/java -cp ../bin pl.chyla.lambda.FunctionalCollections
