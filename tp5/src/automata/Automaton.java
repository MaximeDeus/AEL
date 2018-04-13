package automata;

import java.io.Writer;
import java.util.Set;

/**
 * Méthodes d'utlisation d'un automate
 *
 * @author Bruno.Bogaert (at) univ-lille1.fr
 *
 */
public interface Automaton extends Recognizer {

	/**
	 * états de l'automate.
	 *
	 * @return états de l'automate
	 */
	Set<State> getStates();

	/**
	 * ensemble des états initiaux
	 *
	 * @return états initiaux
	 */
	Set<State> getInitialStates();

	/**
	 * ensemble des états acceptants
	 *
	 * @return états initiaux
	 */
	Set<State> getAcceptingStates();

	/**
	 * ensemble des lettres utilisées par l'automate
	 *
	 * @return ensemble des lettres utilisées par l'automate
	 */
	Set<Character> usedAlphabet();

	/**
	 * indique si l'état est acceptant
	 *
	 * @param s
	 *            état de l'automate
	 * @return vrai si l'état est acceptant
	 * @throws StateException
	 *             si l'état n'appartient pas à l'automate
	 */
	boolean isAccepting(State s) throws StateException;

	/**
	 * indique si l'état est acceptant
	 *
	 * @param name
	 *            nom d'état
	 * @return vrai si l'état est acceptant
	 * @throws StateException
	 *             si ce nom d'état est invalide
	 */
	boolean isAccepting(String name) throws StateException;

	/**
	 * indique si l'état est acceptant
	 *
	 * @param id
	 *            rang d'un état de l'automate
	 * @return vrai si l'état est acceptant
	 * @throws StateException
	 *             si le rang est invalide
	 */
	boolean isAccepting(Integer id) throws StateException;

	/**
	 * indique si l'état est initial
	 *
	 * @param s
	 *            un état de l'automate
	 * @return vrai si l'état est initial
	 * @throws StateException
	 *             si l'état n'appartient pas à l'automate
	 */
	boolean isInitial(State s) throws StateException;

	/**
	 * indique si l'état est initial
	 *
	 * @param name
	 *            nom d'un état de l'automate
	 * @return vrai si l'état est initial
	 * @throws StateException
	 *             si ce nom d'état est invalide
	 */
	boolean isInitial(String name) throws StateException;

	/**
	 * indique si l'état est initial
	 *
	 * @param id
	 *            id d'un d'état de l'automate
	 * @return vrai si l'état est initial
	 * @throws StateException
	 *             si ce rang est invalide
	 */
	boolean isInitial(Integer id) throws StateException;

	/**
	 * Ensemble des transitions définies pour from, letter
	 *
	 * @param from
	 *            état de départ
	 * @param letter
	 *            lettre
	 * @return transition delta(from,letter). null si la transition est
	 *         indéfinie
	 * @throws StateException
	 *             si l'état n'appartient pas à l'automate
	 */
	Set<State> getTransitionSet(State from, char letter) throws StateException;

	/**
	 * Ensemble des transitions définies pour from, letter
	 *
	 * @param from
	 *            nom de l'état de départ
	 * @param letter
	 *            lettre
	 * @return transition delta(from,letter). null si la transition est
	 *         indéfinie
	 * @throws StateException
	 *             si ce nom d'état est invalide
	 */
	Set<State> getTransitionSet(String from, char letter) throws StateException;

	/**
	 * Ensemble des transitions définies pour from, letter
	 *
	 * @param from
	 *            id de l'état de départ
	 * @param letter
	 *            lettre
	 * @return transition delta(from,letter). null si la transition est
	 *         indéfinie
	 * @throws StateException
	 *             si ce rang est invalide
	 */
	Set<State> getTransitionSet(Integer from, char letter) throws StateException;

	/**
	 * représentation de l'automate en langage Graphviz
	 *
	 * @return représentation de l'automate en langage Graphviz
	 */

	/**
	 * Calcul de l'ensemble des états pouvant être obtenus à partir d'un ensemble d'états
	 * @param fromSet : ensemble d'états
	 * @param letter : lettre de l'alphabet
	 * @return ensemble d'états pouvant être obtenus en lisant letter,
	 * en partant de n'importe lequel des états de l'ensemble fromSet
	 */
	public Set<State> getTransitionSet(Set<State> fromSet, char letter);


	/**
	 *
	 * @return code source, au format Graphviz, d'une représentation graphique de l'automate
	 */
	public String toGraphviz();

	/**
	 * Écrit l'image Graphviz de l'automate dans le writer
	 *
	 * @return writer fourni en argument
	 * @param writer fourni en argument
	 */
	public Writer writeGraphviz(Writer writer);

}
