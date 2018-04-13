package automata;

import java.util.Set;

/**
 * 
 * Implémentation d'un automate non déterministe.
 * Version incomplète.
 * 
 * @author Bruno.Bogaert (at) univ-lille1.fr
 *
 */
public class NDAutomatonIncomplete extends AbstractNDAutomaton implements Recognizer, AutomatonBuilder {

	/**
	 * Fake implementation : always return false.
	 */
	public boolean accept(String word) {
		//  Ceci n'est pas une implémentation !
		return false;
	}

	public Set<State> getTransitionSet(Set<State> fromSet, char letter) {
		// TODO Auto-generated method stub
		return null;
	}



}
