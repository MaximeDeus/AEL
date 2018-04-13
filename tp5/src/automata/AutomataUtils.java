package automata;

import java.util.*;
/**
 *
 * @author Bruno.Bogaert (at) univ-lille.fr | DEROISSART Maxime | SASU Daniel
 *
 */
public class AutomataUtils {

	/**
	 * Extends automaton a, so that it accepts also this word.
	 * Created states are prefixed by 'q_'
	 * @param word : word to be accepted
	 * @param a : target automaton
	 */
	public static void addSingleton(String word, AutomatonBuilder a) {
		addSingleton(word, a, "q");
	}

	/**
	 * Extends automaton a so that it accepts also this word.
	 * Created states are prefixed by namePrefix followed by '_'
	 * @param word : word to be accepted
	 * @param a : target automaton
	 * @param namePrefix : prefix to use for state names.
	 */
	public static void addSingleton(String word, AutomatonBuilder a, String namePrefix) {
		int i = 0;
		char letter;
		String nameTransitionPrevious;
		String nameTransitionNext;
		nameTransitionPrevious = namePrefix+"_epsilon";
		try
		{
		a.addNewState(nameTransitionPrevious);
		a.setInitial(nameTransitionPrevious);
		}
		catch(Exception e)
		{
			/*Si l'état existe déjà, on ne fait rien */
		}


		for (i = 0 ; i < word.length() ; i++) /* On parcourt chaque lettre */
		{
			letter = word.charAt(i);
			nameTransitionNext = namePrefix + "_" + word.substring(0,i+1);
			try
			{
			a.addNewState(nameTransitionNext);
			a.addTransition(nameTransitionPrevious, letter, nameTransitionNext); /*Construction du singleton */
			}
			catch(Exception e)
			{
				/*Même raison que précédemment */
			}
			nameTransitionPrevious = nameTransitionNext;
		}
		a.setAccepting(nameTransitionPrevious);

	}



	/**
	 * Extends automaton a so that it accepts also this finite language
	 * created states are prefixed by namePrefix followed by '_'
	 * @param finiteLanguage : set of words to be accepted
	 * @param a : target automaton
	 */
	public static void addFiniteSet(Iterable<String> finiteLanguage, AutomatonBuilder a) {
		Iterator<String> itFiniteLanguage = finiteLanguage.iterator();
		while(itFiniteLanguage.hasNext())
		{
			AutomataUtils.addSingleton(itFiniteLanguage.next(),a); /* On rajoute chaque mot du langage dans l'automate */
		}
	}

	/**
	 * Extends automaton a so that it accepts also language denoted by exp
	 * created states are prefixed by namePrefix followed by '_'
	 * @param exp : flat regular expression (only letters and *)
	 * @param a : target automaton
	 */
	public static void addFlatExp(String exp, AutomatonBuilder a) {
		addFlatExp(exp, a, "q");
	}

	/**
	 * Extends automaton a so that it accepts also language denoted by exp
	 * created states are prefixed by namePrefix followed by '_'
	 * @param exp : flat regular expression (only letters and *)
	 * @param a : target automaton
	 * @param namePrefix : prefix to use for state names.
	 */
	public static void addFlatExp(String exp, AutomatonBuilder a, String namePrefix) {
		int i = 0;
		char letter;
		char nextLetter;
		String nameTransitionPrevious;
		String nameTransitionNext;
		nameTransitionPrevious = namePrefix+"_epsilon";
		try
		{
		a.addNewState(nameTransitionPrevious);
		a.setInitial(nameTransitionPrevious);
		}
		catch(Exception e)
		{
			/*Si l'état existe déjà, on ne fait rien */
		}


		for (i = 0 ; i < exp.length() ; i++) /* On parcourt chaque lettre */
		{
			letter = exp.charAt(i);
			try
			{
			nextLetter = exp.charAt(i+1); /* Sert à savoir si étoile de Kleene */
			}

			catch (Exception e)
			{
				nextLetter = 'z'; /* Savoir si on est à la fin de l'expression.  NOTE : z n'a pas de valeur utile*/
			}

			nameTransitionNext = namePrefix + "_" + exp.substring(0,i+1);

			if (letter != '*')
			{
			try
			{
				if (nextLetter == '*')
				{
					a.addTransition(nameTransitionPrevious, letter, nameTransitionPrevious); /* Boucle */
				}
				else
				{
					a.addNewState(nameTransitionNext);
					a.addTransition(nameTransitionPrevious, letter, nameTransitionNext); /*Construction du singleton */
					nameTransitionPrevious = nameTransitionNext;
				}
			}
			catch(Exception e)
			{
				/*Même raison que précédemment */
			}
			}




	}
	a.setAccepting(nameTransitionPrevious);
}


	/**
	 * Transpose automaton
	 * Note : mirror is cleared before the operation.
	 *
	 * @param original : automaton to be transposed
	 * @param mirror : receive the transposed automaton
	 */
	public static void transpose(Automaton original, AutomatonBuilder mirror) {
		int i;
		int indexOfUnderscore;
		char letter ;
		char nextLetter;
		String nameTransitionPrevious;
		String nameTransitionNext;
		String nameInitialState;
		String nameAcceptingStates;


		Set<State>allInitialStates = new HashSet<State>();
		allInitialStates = original.getInitialStates();
		Iterator <State> itAllInitialStates = allInitialStates.iterator();
		Set<State>allAcceptingStates = new HashSet<State>();
		allAcceptingStates = original.getAcceptingStates();
		Iterator <State> itAllAcceptingStates = allAcceptingStates.iterator();


		mirror.clear();


		while (itAllAcceptingStates.hasNext())
		{
			nameAcceptingStates = itAllAcceptingStates.next().getName();
			indexOfUnderscore = nameAcceptingStates.indexOf('_');

			mirror.addNewState(nameAcceptingStates);
			mirror.setInitial(nameAcceptingStates);
			nameTransitionPrevious = nameAcceptingStates;

			for (i = 1 ; i < nameAcceptingStates.length()-indexOfUnderscore-1; i++)
			{
				try{
					nameTransitionNext = nameTransitionPrevious.substring(0,nameAcceptingStates.length() - i);
					letter = nameAcceptingStates.charAt(nameAcceptingStates.length() - i);
					mirror.addNewState(nameTransitionNext);
					mirror.addTransition(nameTransitionPrevious, letter, nameTransitionNext);
					nameTransitionPrevious = nameTransitionNext;
				}
				catch (Exception e)
				{

				}



			}
			letter = nameAcceptingStates.charAt(nameAcceptingStates.length() - i);
			nameInitialState = itAllInitialStates.next().getName();
			mirror.addNewState(nameInitialState);
			mirror.addTransition(nameTransitionPrevious, letter, nameInitialState);
			mirror.setAccepting(nameInitialState);
		}


	}

	/**
	 * Determinization of nfa automaton.
	 * Note : dfa is cleared before the operation.
	 * @param nfa : non deterministic automaton (to be determinize)
	 * @param dfa : receive determinization result
	 */
	public static void determinize(Automaton nfa, AutomatonBuilder dfa) {
		// For each computed state set from nfa, a corresponding state has to be created in dfa
		// map represents relationship  between nfa state set (key) and created dfa state (value)
		Map<Set<State>, State> map = new HashMap<Set<State>, State>();

		// stack todo contains state sets whose transitions have not yet been computed
		Stack<Set<State>> todo = new Stack<Set<State>>();

		dfa.clear();

		Set<State> startSet = nfa.getInitialStates();


		todo.push(startSet); // put it in todo list.

		while (! todo.isEmpty()) {
			Set<State> fromSet = todo.pop(); // pick a state from todo list


			Set<State> allAcceptingStates = new HashSet<State>();
			allAcceptingStates = nfa.getAcceptingStates();

			/*addSingleton déterminise déjà :x */
			for (State s : allAcceptingStates)
			{
				String word = s.getName();
				word = word.substring(2,word.length());
				if (word.contains("epsilon")) /*Si l'automate a été transposé (mot acceptant = epsilon), on réinverse les états pour récupérer le bon mot*/
				{
					Set<State> allInitialStates = nfa.getInitialStates();
					{
						for (State si : allInitialStates)
						{
							AutomataUtils.addSingleton(word = si.getName().substring(si.getName().indexOf("_")+1),dfa); /*On ajoute les mots*/
						}

					}
				}
				else
				{
				AutomataUtils.addSingleton(word,dfa);
				}
			}

	}

}

public static void minimalise(Automaton a, AutomatonBuilder dest)
{
	dest.clear();
	AutomatonBuilder a_transpose = new NDAutomaton();
	AutomatonBuilder a_transpose_determinise = new NDAutomaton();
	AutomatonBuilder a_transpose_determinise_transpose = new NDAutomaton();

	AutomataUtils.transpose(a,a_transpose);
	AutomataUtils.determinize(a_transpose,a_transpose_determinise);
	AutomataUtils.transpose(a_transpose_determinise,a_transpose_determinise_transpose);
	AutomataUtils.determinize(a_transpose_determinise_transpose,dest);


}


}
