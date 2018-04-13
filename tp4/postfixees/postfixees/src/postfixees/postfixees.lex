package postfixees;

%%

%unicode
%line
%column

MOT_USUEL=[:letter:]+
ENTIER_SIMPLE=[0-9]+
PLUS=[+]|plus
MOINS=[-]|moins
MULT=[*]|mult
QUO=[/]|quo

%%

{ENTIER_SIMPLE}
      { return new Valeur(yytext()); }
{PLUS}
      { return new Plus(yytext()); }
{MOINS}
      { return new Moins(yytext()); }
{MULT}
      { return new Mult(yytext()); }
{QUO}
      { return new Quo(yytext()); }



/* ajouter le cas des espaces et fins de ligne */
[:space:][\n][MOT_USUEL]
  {}

/* ajouter les autres tokens */
