# TP1 - Automates et Langages

### _AUTEURS - DEROISSART Maxime | SASU Daniel_

##### __Sujet : Manipulation d'expressions régulières__

* [Question-1](#-question-1-mots-composés-de-lettres-ascii)
* [Question-2](#-question-2-les-numéros-de-téléphone-en-france)
* [Question-3](#-question-3-les-identifiants-de-département)
* [Question-4](#-question-4-les-identificateurs-de-variable)
* [Question-5](#-question-5-les-nombres-entiers-en-java)
* [Question-6](#-question-6-les-listes-didentificateurs-séparés-par-une-virgule)
* [Question-7](#-question-7-les-littéraux-chaînes-de-caractères-version-1)
* [Question-8](#-question-8-les-littéraux-chaînes-de-caractères-version-2)
* [Question-9](#-question-9-les-littéraux-chaînes-de-caractères-version-3)
* [Question-10](#-question-10-noms-xml)
* [Question-11](#-question-11-réferences-dentité-xml)
* [Question-12](#-question-12-valeurs-dattribut-en-xml)
* [Question-13](#-question-13-balises-ouvrantes-xml)

-Question 1: Mots composés de lettres ASCII
--------------------------------------------
### Expression: `[A-Z][A-Za-z]*`

> #### Explications:
> La première lettre est nécessairement une majuscule,
> suivie d'un nombre potentiellement infini de caractères ASCII.

| Mot    | Résultat |
|--------|----------|
| (eps   | ko       |
|Mordor  | ok       |
|MMORDOR | ok       |
|hello   | ko       |
| HELLo  | ok       |
| BiLbo  | ok       |
| Hé     | ko       |
|H2ô     | ko       |
|A2      | ko       |
|Aaaa2   | ko       |


-Question 2: Les numéros de téléphone en France
-------------
### Expression: `[+][3]{2}[1-9][0-9]{8}`

> ####  Explications:
> Les trois premiers caractères sont forcément +33, suivi d'un chiffre différent de > zéro.
>Enfin, 8 chiffres viennent terminer le mot

| Mot         | Résultat |
|-------------|----------|
|+33635384333 | ok       |
|+33035384333 | ko       |
|033035384333 | ko       |
|+3360000000  | ko       |
|+33600000001 | ok       |
|+30600000001 | ko       |

-Question 3: Les identifiants de département
---------------------------------------------
### Expression: `[0][1-9]|[1][0-9]|[2][1-9]|[3-8][0-9]|[9][0-5]|[9][7][1-6]|[2][AB]`

> #### Explications:
> On commence par la première liste de mots autorisés, donc de 01 à 09.
> Ensuite, on a 10 à 19, puis 21 à 89 et enfin 90 à 95. On termine par les départements
> Outre-mer et enfin la Corse.

| Mot        | Résultat |
|------------|----------|
|2C          | ko	|
|2A	     | ok	|
|977	     | ko	|
|976   	     | ok	|
|971	     | ok	|
|970	     | ko	|
|100	     | ko	|
|1	     | ko	|
|96	     | ko	|
|95	     | ok	|
|21	     | ok	|
|20	     | ko	|
|19	     | ok	|
|10	     | ok	|
|01	     | ok	|
|00	     | ko	|
|e	     | ko	|

-Question 4: les identificateurs de variable
---------------------------------------------
### Expression: `[A-Za-z](([A-Za-z]|[0-9])*(_?)([A-Za-z]|[0-9])+)*`

> #### Explications:
> On commence par le premier caractère, qui doit être une lettre majuscule
> ou minuscule. Ensuite, on a une classe de caractères possible que l'on met entre un
> possible et unique underscore, et qui ne peut pas terminer le mot. On répète ensuite ce même schéma.

| Mot    | Résultat |
|--------|----------|
|T_est	 | ok	    |
|_Test	 | ko	    |
|Test__t | ko	    |
|Test_t	 | ok	    |
|Test_	 | ko	    |
|Test	 | ok	    |
|T	 | ok	    |

-Question 5: les nombres entiers en Java
-----------------------------------------
### Expression: ` 0(x([0-9A-F]*_?[0-9A-F]+)*|o([0-7]*_?[0-7]+)*)|([0-9]*_?[0-9]+)*`

> #### Explications:
> On commence par définir le cas hexadecimal, puis octal, ces deux cas
> sont traités lorsque le premier chiffre est un zéro. Sinon, on écrit des nombres décimaux.
> On garde la même contrainte que lors de la question précédente concernant les underscore.



| Mot                   | Résultat |
|-----------------------|----------|
|1			| ok	   |
|0			| ok	   |
|0o012345678		| ko	   |
|0o01234567		| ok	   |
|0o0123456789ABCDEF	| ko	   |
|0x0123456789ABCDEF_F_	| ko	   |
|0x0123456789ABCDEF__F	| ko	   |
|0x0123456789ABCDEF_F	| ok	   |
|0x0123456789ABCDEFG	| ko	   |
|0x0123456789ABCDEF	| ok	   |



-Question 6: les listes d’identificateurs séparés par une virgule
------------------------------------------------------------------
### Expression: `*(( *[A-Za-z](([A-Za-z]|[0-9])*(_?)([A-Za-z]|[0-9])+)* *)(,( *[A-Za-z](([A-Za-z]|[0-9])*(_?)([A-Za-z]|[0-9])+)* *))?)*`

> #### Explications:
>Pour établir la liste, on place un premier mot (un identificateur), suivi d'un autre si et seulement si
>il sont séparés d'une virgule. On répète ensuite ce schéma.

| Mot          | Résultat |
|--------------|----------|
|,Test , ament | ko       |
|Test , ament, | ko       |
|Test , ament  | ok       |
|Test,ament    | ok       |
|Test,	       | ko       |
|Test_	       | ko       |
|T__est	       | ko       |
|T_est	       | ok       |
|Test	       | ok       |


-Question 7: les littéraux chaînes de caractères (version 1)
------------------------------------------------------------
### Expression : `"([^"]*)"`

> #### Explications:
> N'importe quels caractères (excepté la double quote) entre double quote.

| Mot   | Résultat |
|-------|----------|
|""""a	| ko       |
|"""a"	| ok       |
|""a""	| ko       |
|"a"""	| ok       |
|""""	| ok       |
|"ab""c"| ok       |

-Question 8: les littéraux chaînes de caractères (version 2)
------------------------------------------------------------
### Expression : `("([^"]*)")*`

> #### Explications:
> Même schéma que précédemment mais répété

| Mot      | Résultat |
|----------|----------|
|""""a	   | ko       |
|"""a"	   | ok       |
|""a""	   | ko       |
|"a"""	   | ok       |
|""""      | ok       |
|"ab""c"   | ok       |



-Question 9: les littéraux chaînes de caractères (version 3)
------------------------------------------------------------
### Expression : `("(([^"\\]*(\\(\\|"))?[^"\\]*)*)")*`

>#### Explications:
>Cette fois-ci les mots entre double quote peuvent contenir un caractère d'échappement
>, qui doit être immédiatement suivi d'un deuxième ou bien d'une double quote.

| Mot      | Résultat |
|----------|----------|
|"\\\"	   | ko       |
|"a\"	   | ko       |
|"a\c"	   | ko       |
|"a"b"	   | ko       |
|"a\\b\"c" | ok       |
|"\\\""	   | ok       |

-Question 10: Noms XML
-----------------------
### Expression : `[A-Za-z:_][A-Za-z:\-_0-9\.]*`

> #### Explications:
> On commence par caractériser la première lettre, ensuite le reste.

| Mot       | Résultat |
|-----------|----------|
|_test.:-_" | ko       |
|_test.:-_  | ok       |
|_	    | ok       |
|:	    | ok       |
|a	    | ok       |

-Question 11: Réferences d’entité XML
--------------------------------------
### Expression : `&[A-Za-z:_]?[A-Za-z:\-_0-9\.]*;`

> #### Explications:
>Même chose que précedemment, excepté le début et la fin

| Mot          | Résultat |
|--------------|----------|
|&_test;&grtg; | ko       |
|_test;	       | ko       |
|&_test;       | ok       |
|&_test	       | ko       |
|_test	       | ko       |

-Question 12: Valeurs d’attribut en XML
---------------------------------------
### Expression : `"&?[^<&"]*"`
> #### Explications:
> Le mot est entre double quote, et il peut éventuellement contenir uniquement en premier caractère un &.
> Le mot ne peut contenir de balise ouvrante ou de double quote.

| Mot    | Résultat |
|--------|----------|
|"test>" | ok       |
|"test<" | ko       |
|"test"" | ko       |
|"test&" | ko       |
|"test"	 | ok       |
|"&test" | ok       |
|""	 | ok       |

-Question 13: Balises ouvrantes XML
------------------------------------
### Expression : `<([A-Za-z:_][A-Za-z:\-_0-9\.]*)( +[a-z]* *= *"&?[^<&"]*")* *>`

#### Explications:
> On commence par une balise ouvrante, suivie d'un nom, et d'attribut(s) ou non.
> Lorsqu'il y a un attribut, il doit être suivi d'un = puis d'un nom XML. deux attributs sont
> séparés par au moins un espace. On ferme le tout avec une balise fermante.

| Mot                                                | Résultat |
|----------------------------------------------------|----------|
|`<balise attribut="valeur" attributdeux = "valeur2">` |	ok      |
|`<balise attribut="valeur" attributdeux="valeur2" >`  |	ok      |
|`< balise attribut="valeur" attributdeux="valeur2">`  |	ko      |
|`<balise attribut="valeur" attributdeux="valeur2">`   |	ok      |
|`<balise attribut="v&aleur">`			     |  ko      |
|`<balise attribut="&valeur">`			     |  ok      |
|`<balise attribut="valeur">`			     |  ok      |
|`<balise attribut=valeur>`			     |  ko      |
|`<balise attribut=>`				     |  ko      |
|`<balise attribut>`				     |  ko      |
|`<balise>`					     |  ok      |
