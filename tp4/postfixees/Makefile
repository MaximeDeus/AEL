all: ex

ex:
	java -jar ../jflex-1.6.1.jar src/postfixees/postfixees.lex
	javac -cp src -d bin src/postfixees/Evaluateur.java 
	java -cp bin postfixees.Evaluateur testPost.txt

clean:  
	rm -f bin/postfixees/*.class ;

	

