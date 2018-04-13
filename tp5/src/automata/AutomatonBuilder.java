package automata;

/**
 * 
 * Méthodes de construction incrémentales d'un automate
 * 
 * @author Bruno.Bogaert (at) univ-lille1.fr
 *
 */
public interface AutomatonBuilder extends Automaton {
	/**
	 * Crée un nouvel état
	 * 
	 * @param name
	 *            nom attribué à l'état
	 * @return état créé
	 * @throws StateException 
	 *             si le nom est incorrect (déjà attribué, par exemple)
	 */
	State addNewState(String name) throws StateException;

	/**
	 * Crée un nouvel état. Son nom sera attribué automatiquement.
	 * 
	 * @return état créé
	 * @throws StateException : si la création de l'état est impossible
	 */
	State addNewState() throws StateException;

	/**
	 * Rend l'état s acceptant
	 * 
	 * @param s : état à rendre acceptant
	 * @throws StateException
	 *             si s est invalide
	 */
	void setAccepting(State s) throws StateException;;

	/**
	 * Rend l'état acceptant
	 * 
	 * @param name
	 *            nom de l'état
	 * @throws StateException
	 *             si s est invalide
	 */
	void setAccepting(String name) throws StateException;;

	/**
	 * Rend l'état acceptant
	 * 
	 * @param id
	 *            : identifiant de l'état
	 * @throws StateException
	 *             si s est invalide
	 */
	void setAccepting(int id) throws StateException;

	/**
	 * Rend l'état initial
	 * 
	 * @param s : état à rendre initial
	 * @throws StateException
	 *             si s est invalide
	 */
	void setInitial(State s) throws StateException;

	/**
	 * Rend l'état initial
	 * 
	 * @param name : nom de l'état à rendre initial
	 * @throws StateException
	 *             si name est invalide
	 */
	void setInitial(String name) throws StateException;

	/**
	 * Rend l'état initial
	 * 
	 * @param id : id de l'état à rendre initial
	 * @throws StateException : si l'id ne représente pas un état valide dans cet automate
	 */
	void setInitial(int id) throws StateException;

	/**
	 * Ajoute une transition
	 * 
	 * @param from : état de départ
	 * @param letter : lettre de transition
	 * @param to : état d'arrivée
	 * @throws StateException
	 *             Si l'un des états est invalide
	 */
	void addTransition(State from, Character letter, State to) throws StateException;

	/**
	 * Ajoute une transition
	 * 
	 * @param from : nom de l'état de départ
	 * @param letter : lettre de transition
	 * @param to : nom de l'état d'arrivée
	 * @throws StateException
	 *             Si l'un des états est invalide
	 */
	void addTransition(String from, Character letter, String to) throws StateException;

	/**
	 * Ajoute une transition
	 * 
	 * @param from : id de l'état de départ
	 * @param letter : lettre de transition
	 * @param to : id de l'état d'arrivée
	 * @throws StateException
	 *             Si l'un des état est invalide
	 */
	void addTransition(int from, Character letter, int to) throws StateException;
	
	/**
	 * Remet l'automate à zéro (ensemble d'états vide)
	 */
	void clear();
}
