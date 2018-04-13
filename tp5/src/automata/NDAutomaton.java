package automata;

import java.util.*;

/**
 *
 * Implémentation d'un automate non déterministe.
 * Version incomplète.
 *
 * @author Bruno.Bogaert (at) univ-lille1.fr | DEROISSART Maxime | SASU Daniel
 *
 */
public class NDAutomaton extends AbstractNDAutomaton implements Recognizer, AutomatonBuilder {

	/**
	 * Teste si un mot est compris dans le langage
	 * @param word : le mot testé
	 * @return vrai si le mot est accepté, faux sinon
	 */
	public boolean accept(String word) {

		int i;
		Set<State> nextStates = this.getInitialStates();
		for (i = 0 ; i < word.length() ; i++)  /* Indice des lettres */
		{
			if (nextStates.isEmpty())  /* Si aucune transition */
			{
				System.out.println("Le mot " + word.toString() + " n'est pas accepté");
				return false;
			}
		nextStates = this.getTransitionSet(nextStates,word.charAt(i));  /* On avance dans l'automate */
		}

		Iterator <State> itNextStates = nextStates.iterator();  /* A la fin du mot, on regarde s'il existe des états acceptants */
		{
			while (itNextStates.hasNext())
			{
				if (this.isAccepting(itNextStates.next()))
				{
					System.out.println("Le mot " + word.toString() + " est accepté");
					return true;
				}
			}
		}
		System.out.println("Le mot " + word.toString() + " n'est pas accepté");
		return false;

		}


	/**
   *
   * Calcul de l’ensemble des états pouvant être obtenus depuis un ensemble d’états
   * @param fromSet : ensemble d’états
   * @param letter : lettre de l’alphabet
   * @return ensemble d’états pouvant être obtenus en lisant letter,
   * en partant de n’importe lequel des états de l’ensemble fromSet
	 */

	public Set<State> getTransitionSet(Set<State> fromSet, char letter) {
		Set <State> result = new PrintSet<State>();
		Iterator <State> itFromSet = fromSet.iterator();
		while (itFromSet.hasNext()) /* On parcourt chaque état de fromSet */
		{
			Set <State> getTransitionSetOfEachState  = this.getTransitionSet(itFromSet.next() , letter); /* On récupère ses transitions (Automate ND mais n états initiaux) */
			Iterator <State> itGetTransitionSetOfEachState = getTransitionSetOfEachState.iterator();

		while (itGetTransitionSetOfEachState.hasNext())
		{
			result.add(itGetTransitionSetOfEachState.next()); /* On ajoute au résultat, on supprimant les potentiels doublons */
		}

	  }

		return result;
	}



}
