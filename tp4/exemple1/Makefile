all: ex

ex:
	java -jar ../jflex-1.6.1.jar src/exemple1/exemple1.lex
	javac -cp src -d bin src/exemple1/TestEx1.java 
	java -cp bin exemple1.TestEx1 test.txt

