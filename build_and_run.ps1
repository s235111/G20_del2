rm -r build
javac -d build ui/UserInterface.java
cp -r resources build/resources
cd build
java ui/UserInterface
