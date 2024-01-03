COMPILE
javac --release 8 -d target src/java/edu.school21.printer/*/*.java
RE-COMPILE
rm -rf target && javac --release 8 -d target src/java/edu.school21.printer/*/*.java
EXECUTE
java -cp target edu.school21.printer.app.Program ../it.bmp . 0
