rm -r build
javac -d build game/GameController.java
cp -r resources build/resources
cd build
java game/GameController
