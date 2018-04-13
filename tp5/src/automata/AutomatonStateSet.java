package automata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author Bruno.Bogaert (at) univ-lille1.fr
 * 
 *         Ensemble d'états. Au sein de l'ensemble, chaque état est identifiable
 *         par son rang de création (entier &ge;0) et un nom. Iterable par ordre
 *         de création des états.
 *
 */
class AutomatonStateSet extends PrintSet<State> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2399556128614952083L;
	/**
	 * 
	 */
	private ArrayList<State> byRank;
	private HashMap<String, State> byName;
	private final Automaton automaton;

	@Override
	public boolean add(State element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends State> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<State> iterator() {
		return byRank.iterator();
	}

	public ArrayList<State> getList() {
		return byRank;
	}

	public HashMap<String, State> getByName() {
		return byName;
	}

	public Automaton getAutomaton() {
		return automaton;
	}

	public AutomatonStateSet(Automaton automaton) {
		this.automaton = automaton;
		byName = new HashMap<String, State>();
		byRank = new ArrayList<State>();
	}

	private class StateImpl implements State {
		final String name;
		final int rank;

		public String getName() {
			return name;
		}

		public int getId() {
			return rank;
		}

		public Automaton getAutomaton() {
			return AutomatonStateSet.this.automaton;
		}

		StateImpl(String name) throws StateException {
			this.rank = AutomatonStateSet.this.size();
			if (name == null)
				name = "q" + this.rank;
			this.name = name;
			if (byName.containsKey(this.name))
				throw new StateException();
			byName.put(this.name, this);
			byRank.add(this);
			AutomatonStateSet.super.add(this);
		}

		StateImpl() throws StateException {
			this(null);
		}

		public String toString() {
			return this.name;
		}
	}

	/**
	 * 
	 * @param name
	 *            nom de l'état
	 * @return état créé
	 * @throws StateException
	 *             si le nom est déjà utilisé
	 */
	public State addNewState(String name) throws StateException {
		return new StateImpl(name);
	}

	/**
	 * 
	 * @return état créé
	 */
	public State addNewState() throws StateException {

		return new StateImpl();
	}

	/**
	 * 
	 * @return état selon son rang
	 * @throws IncorrectStateException 
	 */
	public State get(int rank) throws StateException {
		State s;
		try {
			s = byRank.get(rank);
		}
		catch (IndexOutOfBoundsException e){
			throw new StateException(e);
		}		
		return s;
	}

	/**
	 * 
	 * @return état selon son nom
	 * @throws IncorrectStateException 
	 */
	public State get(String name) throws StateException {
		State s = byName.get(name);
		if (s == null)
			throw new StateException("\""+name+"\" : unknown state");
		return s;
	}

	public String toString() {
		if (this.isEmpty())
			return "{}";
		StringBuffer buff = new StringBuffer();
		buff.append("{");
		for (State elt : this) {
			buff.append(elt.toString());
			buff.append(',');
		}
		buff.deleteCharAt(buff.length() - 1);
		buff.append("}");
		return buff.toString();
	}

}
