/* Exemple 1 */
package exemple1;

%%

%unicode

IDENTIFICATEUR = [A-Za-z][A-Za-z0-9_]*
OPERATEUR=[\" \\ \[ \] \^ \- \? \. \* \+ \| \( \) \$ \/ \{ \} \% \< \>]+
MOT_USUEL=[:letter:]+
ENTIER_SIMPLE=[0-9]+

%% 

{OPERATEUR}|{ENTIER_SIMPLE}|{IDENTIFICATEUR}
      {return new Yytoken(yytext());}


[^MOT_USUEL]
      {}  
