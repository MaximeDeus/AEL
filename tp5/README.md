#   TDM 5 - Automates et Langages




> #### Important:
> Toute manipulation(commande) décrite dans ce fichier est effectuée depuis le dossier racine du projet (tp5).


Présentation du TP et de ses objectifs
---------------------------------------

- Ce TD machine est consacré à l’implémentation des automates en Java
- Divers automates sont demandés :
  ```
  Singleton
  Expressions plates
  Determinisation
  Transposition
  ```


Arborescence du projet
----------------------

```
.
├── classes
├── Makefile
└── src
    └── automata
        ├── AbstractAutomaton.java
        ├── AbstractNDAutomaton.java
        ├── AutomataUtils.java
        ├── AutomataUtilsSkeleton.java
        ├── AutomatonBuilder.java
        ├── Automaton.java
        ├── AutomatonStateSet.java
        ├── NDAutomatonIncomplete.java
        ├── NDAutomaton.java
        ├── package-info.java
        ├── PrintSet.java
        ├── README.md
        ├── Recognizer.java
        ├── StateException.java
        ├── State.java
        └── TestND.java

3 directories, 17 files

```

Comment récupérer le projet
-----------------------------

```
$ git@gitlab-etu.fil.univ-lille1.fr:sasu/AEL.git
```

Comment générer la documentation
---------------------------------

```
$ make doc
```

Compilation et exécution des programmes
----------------------------------------
```
Pour compiler tous les fichier:

$ make compil

Pour générer les fichiers dot

$ make dot

Pour générer les fichiers pdf

$ make pdf

```

Comment "nettoyer" le projet
------------------------------

```
$ make clean
```

> #### Note:
> Cela supprimera les fichiers compilés ainsi les fichiers .dot .pdf ainsi que la documentation
