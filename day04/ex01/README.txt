COMPILE
javac --release 8 -d target ImagesToChar/src/java/edu.school21.printer/*/*.java && cp -r src/resources target
RE-COMPILE
rm -rf target && javac --release 8 -d target src/java/edu.school21.printer/*/*.java && cp -r src/resources target
JAR CREATION
jar cvfm images-to-chars-printer.jar src/manifest.txt target
EXECUTE
java -cp target edu.school21.printer.app.Program . 0
