/**
 * 
 * <h1>Implémentation d'automates en Java.</h1>
 * 
 * La modélisation des automates est principalement structurée par deux <strong>interfaces</strong> :
 * <ul>
 * <li><code>Automaton</code> : méthodes permettant de connaître l'automate et de l'utiliser</li>
 * <li><code>AutomatonBuilder</code> : méthodes permettant de définir incrémentalement un automate</li>
 * </ul>
 *
 * <p>La modélisation proposée correspond à la définition des automates <strong>non</strong> déterministes (DFA automata).
 *  <strong>sans</strong> 𝜀-transitions.
 * </p>
 * <p>La classe abstraite <code>AbstractNDAutomaton</code>  implémente la plupart des méthodes,
 * à l'exception de 2 d'entre-elles : 
 * {@link Recognizer#accept(String)}, 
 * {@link Automaton#getTransitionSet(java.util.Set, char)}
 * 
 * </p>
 *   @see Automaton
 *   @see AutomatonBuilder
 *   @see AbstractNDAutomaton
* 
 * @author Bruno.Bogaert (at) univ-lille.fr
 *
 */
package automata;