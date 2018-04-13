#!/usr/bin/env bash

# TP2: Les expressions régulieres avec 'egrep'
# Les réponses aux question 1 - 3 de l'exercice 2
# Auteur: DEROISSART Maxime et SASU Daniel

#BEGIN

valeurAttribut='&?"[^<"&]*"'
nomXML='[[:alpha:]\:_]([[:alnum:]\.-\:_])*'
refEntite='&'$nomXML';'
baliseOuvrante='<'$nomXML'([[:space:]]'$nomXML'=''([[:space:]]?'$valeurAttribut')*)?>'


# Question 1
echo ""
echo "** Q1 :"
echo "ValeurAttribut"
egrep --color -m 10 $valeurAttribut html/fil.html

# Question 2
echo ""
echo "** Q2 :"
echo "nomXML"
egrep --color=auto -m 10 $nomXML html/fil.html
echo "refEntite"
egrep --color=auto -m 10 $refEntite html/fil.html
echo "baliseOuvrante"
egrep --color=auto -m 10 $baliseOuvrante html/fil.html



# Question 3

echo ""
echo "** Q3 :"

egrep -o --color=auto '\+33.{18}|03.20.{9}' html/*


#EOF
