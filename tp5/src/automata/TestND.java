package automata;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Bruno.Bogaert (at) univ-lille.fr | DEROISSART Maxime | SASU Daniel
 *
 */


public class TestND {

	/*
	 * Écriture de la représentation graphviz de l'automate dans un fichier
	 *
	 */
	private static void dotToFile(Automaton a, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter sortieDot = new PrintWriter(f);
			sortieDot.println(a.toGraphviz());
			sortieDot.close();
		} catch (IOException e) {
			System.out.println("création du fichier " + fileName + " impossible");
		}
	}

	/*
	 * Test de la méthode accept()
	 */
	private static void testAccept(Automaton a) {
		if (a.accept(""))
			System.out.println("Le mot vide est accepté. ");
		else
			System.out.println("Le mot vide n'est pas accepté. ");

		Scanner in = new Scanner(System.in);
		System.out.println("Mot non vide à tester ? (mot vide pour terminer)");
		String word = in.nextLine();
		while (word.length() != 0) {
			System.out.print("> " + word);
			if (a.accept(word))
				System.out.print(" est accepté. ");
			else
				System.out.print(" n'est pas accepté.");
			System.out.println("Mot non vide à tester ? (mot vide pour terminer)");
			word = in.nextLine();
		}

	}

	public static void main(String[] args) throws StateException {

		/* Fabrication de l'automate */

		AutomatonBuilder a = new NDAutomaton();

		/*
		 * Définition des états Notez que les états sont numérotés 0, 1, 2, ... dans
		 * l'ordre de leur création dans l'automate par défaut les états sont nommés
		 * "qi", où i est leur numéro On peut leur choisir un autre nom en le passant en
		 * paramètre de la méthode addNewState
		 */

		a.addNewState();
		a.addNewState();
		a.addNewState();
		a.addNewState();
		// a.addNewState("NomQuiMePlait");

		/*
		 * Définition des états initiaux et des états acceptants Le paramètre est
		 * indifféremment le numéro ou le nom d'un état
		 */
		a.setAccepting("q0");
		a.setInitial("q0");
		a.setAccepting("q2");
		a.setInitial("q2");

		/*
		 * Définition des transitions
		 */
		a.addTransition("q0", 'a', "q1");
		a.addTransition("q1", 'b', "q0");
		a.addTransition("q2", 'b', "q3");
		a.addTransition("q3", 'a', "q2");






		/*
		 * Affichage de l'automate, en mode texte
		 */
		System.out.println(a);

		/*
		 * Test de la méthode accept() à réactiver quand vous aurez développé une classe
		 * avec une vraie méthode accept()
		 */

		 	AutomatonBuilder b = new NDAutomaton();
			AutomatonBuilder c = new NDAutomaton();
			AutomatonBuilder c_determinise = new NDAutomaton();
			AutomatonBuilder d = new NDAutomaton();
			AutomatonBuilder b_transpose = new NDAutomaton();
			AutomatonBuilder d_transpose = new NDAutomaton();

		  String mot_vide = "";
			String mot_a = "a";
			String mot_b = "b";
			String mot_c = "c";
			String mot_ab = "ab";
			String mot_ba = "ba";
			String mot_bab = "bab";
			String mot_abc = "abc";
			String mot_cba = "cba";
			String mot_def = "def";
			String mot_fed = "fed";
			String mot_hello = "hello";
			String mot_hallo = "hallo";

			System.out.println("\nAuteurs des tests : DEROISSART Maxime | SASU Daniel\n");

			System.out.println("-------------------------");
			System.out.println("           TP5");
			System.out.println("-------------------------");


			System.out.println("\nTests de base\n");

		  a.accept(mot_vide);
			a.accept(mot_a);
			a.accept(mot_b);
			a.accept(mot_c);
			a.accept(mot_ab);
			a.accept(mot_ba);
			a.accept(mot_bab);



			System.out.println("\n2.3.1 Automate pour singleton \n");

			b.accept(mot_abc);
			b.accept(mot_def);

			System.out.println("\nRéalisation de l'exemple \n");
			AutomataUtils.addSingleton(mot_abc,b,"q1");
			AutomataUtils.addSingleton(mot_def,b,"q2");

			b.accept(mot_abc);
			b.accept(mot_def);



			System.out.println("\n2.3.1 Automate pour langage fini\n");

			c.accept(mot_hello);
			c.accept(mot_hallo);

			System.out.println("\nAjout des mots hello | hallo \n");

			Set<String> finiteLanguage = new HashSet<String>();

			finiteLanguage.add(mot_hello);
			finiteLanguage.add(mot_hallo);

			AutomataUtils.addFiniteSet(finiteLanguage , c);

			c.accept(mot_hello);
			c.accept(mot_hallo);



			System.out.println("\n2.3.2 Automate pour expression régulière «plate»\n");

			d.accept("11");
			d.accept("101");
			d.accept("1001");

			System.out.println("\nAjout de l'expression régulière 10*1 \n");

			AutomataUtils.addFlatExp("10*1",d);
			d.accept("11");
			d.accept("101");
			d.accept("1001");


			System.out.println("\n2.3.3 Automate Transposé \n");



			b_transpose.accept(mot_cba);
			b_transpose.accept(mot_fed);

			System.out.println("\nAjout de l'automate transposé de b \n");


			AutomataUtils.transpose(b, b_transpose);

			b_transpose.accept(mot_cba);
			b_transpose.accept(mot_fed);


			System.out.println("\n2.3.4 Automate déterminisé \n");

			c_determinise.accept(mot_hello);
			c_determinise.accept(mot_hallo);

			System.out.println("\nAjout de l'automate déterminisé de c \n");

			AutomataUtils.determinize(c,c_determinise);

			c_determinise.accept(mot_hello);
			c_determinise.accept(mot_hallo);



			/*
			 * Dessin de l'automate (fabrication d'un fichier Graphviz)
			 */
			dotToFile(a, "automate-test.dot");
			dotToFile(b, "automate-b.dot");
			dotToFile(c, "automate-c.dot");
			dotToFile(d, "automate-d.dot");
			dotToFile(b_transpose, "automate-b-transpose.dot");
			dotToFile(d_transpose, "automate-d-transpose.dot");
			dotToFile(c_determinise, "automate-c-determinise.dot");

		System.out.println("That's all folks");

	}
}
