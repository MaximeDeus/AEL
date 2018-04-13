#!/usr/bin/env bash

# TP2: Les expressions régulieres avec 'egrep'
# Les réponses aux question 1 - 4 de l'exercice 1
# Auteur: DEROISSART Maxime et SASU Daniel

# Préparation alias

#BEGIN

# Question 1
echo ""
echo "** Q1 :"
egrep --color=auto 'nez'  Cyrano.txt

# Question 2
echo ""
echo "** Q2 :"
egrep --color=auto '[(*)]' Cyrano.txt

# Question 3
echo ""
echo "** Q3 :"
egrep --color=auto '\<[[:alpha:]]{4}\>' Cyrano.txt

# Question 4
echo ""
echo "** Q4 :"
egrep --color=auto '^[[:alpha:]]*[[:space:]]:' Cyrano.txt

#EOF
