JC = javac
JVM = java
JD = javadoc
CLASSES =		AbstractNDAutomaton.class \
			AbstractAutomaton.class \
			AutomataUtilsSkeleton.class \
			AutomatonBuilder.class \
			Automaton.class \
			AutomatonStateSet.class \
			NDAutomatonIncomplete.class \
			NDAutomaton.class \
			package-info.class \
			PrintSet.class \
			Recognizer.class \
			StateException.class \
			State.class \
			TestND.class


TEST =


.PHONY: clean, docs, all_tests

jar: all
	cd classes; jar cvfm ../rental.jar ../manifest rental

doc:
	$(JD) -author -sourcepath src -subpackages automata -d docs


#Compiling all sources
all: $(CLASSES)


#Compiling source files
%.class: %.java
	$(JC) -sourcepath src -classpath classes src/automata/*.java -d classes

clean:
	rm -rf classes/automata/
	rm -rf test/automata/*.class
	rm -rf *~
	rm -f *.dot
	rm -f *.dot.pdf
	rm -rf docs

compil:
	javac -sourcepath src -classpath classes src/automata/*.java -d classes

dot: compil
	java -classpath classes automata.TestND

pdf: dot
	dot -T pdf -O automate-test.dot
	dot -T pdf -O automate-b.dot
	dot -T pdf -O automate-c.dot
	dot -T pdf -O automate-d.dot
	dot -T pdf -O automate-c-determinise.dot
