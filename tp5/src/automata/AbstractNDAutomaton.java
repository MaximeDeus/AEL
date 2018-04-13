package automata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * Implémentation d'un automate non déterministe.
 * Version à compléter ou à étendre 
 * Toutes les méthodes sont implémentées SAUF accept()
 * 
 * @author Bruno.Bogaert (at) univ-lille1.fr
 *
 */
public abstract class AbstractNDAutomaton extends AbstractAutomaton implements Recognizer, Automaton, AutomatonBuilder {

	protected Set<State> initialStates;
	protected HashMap<Key, Set<State>> delta;
	
	
	/**
	 * local initialisation
	 */
	private void initialise() { 
		initialStates = new PrintSet<State>();
		delta = new HashMap<Key, Set<State>>();		
	}
	
	public void clear() {
		super.clear();
		this.initialise();
	}

	public AbstractNDAutomaton() {
		super();
		initialise();
	}
	
	@Override
	public boolean isInitial(String name) throws StateException {
		return isInitial(states.get(name));
	}

	@Override
	public boolean isInitial(Integer id) throws StateException {
		return isInitial(states.get(id));
	}

	@Override
	public Set<State> getTransitionSet(State from, char letter) {
		Set<State> s = delta.get(new Key(from, letter));
		if (s==null)
			return Collections.emptySet();
		else
			return Collections.unmodifiableSet(s);
	}

	@Override
	public Set<State> getTransitionSet(String from, char letter) {
		return getTransitionSet(states.get(from), letter);
	}

	@Override
	public Set<State> getTransitionSet(Integer from, char letter) {
		return getTransitionSet(states.get(from), letter);
	}

	@Override
	public Set<State> getInitialStates() {
		return Collections.unmodifiableSet(this.initialStates);
	}

	@Override
	public void setInitial(State s) {
//		checkState(s);
		initialStates.add(s);
	}

	@Override
	public boolean isInitial(State s) {
		return initialStates.contains(s);
	}
	@Override
	public void addTransition(State from, Character letter, State to) {
//		checkState(from);
//		checkState(to);
		alphabet.add(letter);
		Key k = new Key(from, letter);
		Set<State> arrival = delta.get(k);
		if (arrival == null) {
			arrival = new PrintSet<State>();
		}
		if (!arrival.contains(to)) {
			arrival.add(to);
			delta.put(k, arrival);
		}
	}


}
