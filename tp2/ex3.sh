#!/usr/bin/env bash

# TP2: Les expressions régulieres avec 'egrep'
# Les réponses aux question 1 - 3 de l'exercice 3
# Auteur: DEROISSART Maxime et SASU Daniel


#BEGIN

# Question 1

echo ""
echo "** Q1 :"

egrep -o --color=auto '[[:digit:]]*(BIS|TER),[^,]*,[0-9 ]*,[^,]*' bano-59009.csv

# Question 2

echo ""
echo "** Q2 :"

egrep -o --color=auto '[[:digit:]]*,Ruelle [^,]*,[0-9 ]*,[^,]*' bano-59009.csv


# Question 3

echo ""
echo "** Q3 :"

egrep -o --color=auto '[[:alnum:]]*,[[:upper:] ]*,[0-9 ]*,[^,]*' bano-59009.csv


#EOF
