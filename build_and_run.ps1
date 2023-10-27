rm -r build
javac -d build ui/UserInterface.java
cp -r resources build/resources
jar -c -f DiceGame2.jar -e ui.UserInterface -C build .
java -jar DiceGame2.jar
