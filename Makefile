
JAVA_COMMAND = java -jar .\javacpp.jar -properties windows-mingw Lab1.java -exec


all:
	$(JAVA_COMMAND)
