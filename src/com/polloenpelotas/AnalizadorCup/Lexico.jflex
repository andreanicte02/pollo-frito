/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones
package com.polloenpelotas.AnalizadorCup;
import java_cup.runtime.*;

%%
/*----------------------------------------------------------------------------
--------------------- 2da. Area: Opciones y Declaraciones
----------------------------------------------------------------------------*/

%{
    String cadenita ="";
    //-------> Codigo de usuario en sintaxis java
%}

//-------> Directivas
%public
%class Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//-------> Expresiones Regulares
numero          = [0-9]+
decimal         = [0-9]+"."[0-9]+


letter          = [a-zA-Z]
letterDigit     = [a-zA-Z0-9]
more            = ({letter}| "."{letter})
identifier      = {more} ({letterDigit}|"_"|".")*

//-------> Palabras Reservadas
c     = "c"
print = "print"
truee = "true"
falsee = "false"
list = "list"
nothing = "nothing"

//-------> Estados
%state COMENT_SIMPLE
%state COMENT_MULTI
%state cadena1
%state cadena2

%%
/*-------------------------------------------------------------------
--------------------- 3ra. y ultima area: Reglas Lexicas
-------------------------------------------------------------------*/

//-------> Comentarios
<YYINITIAL> "#*"                {yybegin(COMENT_MULTI);}
<COMENT_MULTI> "*#"             {yybegin(YYINITIAL);}
<COMENT_MULTI>  .               {/* Omitir como es un comentario :D */}
<COMENT_MULTI> [ \t\r\n\f]      {}

<YYINITIAL> "#"            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> [^"\n"]     {}
<COMENT_SIMPLE> "\n"        {yybegin(YYINITIAL);}
<COMENT_SIMPLE>  .          {/* Omitir como es un comentario :D */}

//--------> Caracteres de escape
<YYINITIAL> "\"" { yybegin (cadena1); cadenita="";}
<cadena1>   "\\" { yybegin (cadena2); }
<cadena1>   "\"" { yybegin (YYINITIAL);  return new Symbol(Simbolos.cadena,yyline,yycolumn,cadenita.replace("\"","")); }
<cadena1> .      { cadenita+= yytext();}

<cadena2>        {
            "'"  { cadenita+= "'"; yybegin(cadena1);}
            "\"" { cadenita+= "\""; yybegin(cadena1);}
            "?"  { cadenita+= "?"; yybegin(cadena1);}
            "\\" { cadenita+= "\\"; yybegin(cadena1);}
            "0"  { cadenita+= '\0'; yybegin(cadena1);}
            "a"  { yybegin(cadena1); }
            "b"  { cadenita+= '\b'; yybegin(cadena1);}
            "f"  { cadenita+= '\f'; yybegin(cadena1);}
            "n"  { cadenita+= "\n"; yybegin(cadena1);}
            "r"  { cadenita+= '\r'; yybegin(cadena1);}
            "t"  { cadenita+= '\t'; yybegin(cadena1);}
            "v"  { yybegin(cadena1);}
            "u"  { cadenita+= '\0'; yybegin(cadena1);}
            "U"  { yybegin(cadena1);}

}
//-------> Simbolos
<YYINITIAL> ";"         {   return new Symbol(Simbolos.pComa, yycolumn, yyline, yytext());}
<YYINITIAL> "="         {   return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}
<YYINITIAL> "("         {   return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}
<YYINITIAL> ")"         {   return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}


<YYINITIAL> "+"         {   return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}
<YYINITIAL> "-"         {   return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}
<YYINITIAL> "*"         {   return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}
<YYINITIAL> "/"         {   return new Symbol(Simbolos.dividir, yycolumn, yyline, yytext());}
<YYINITIAL> "^"         {   return new Symbol(Simbolos.potenciar, yycolumn, yyline, yytext());}
<YYINITIAL> "%%"        {   return new Symbol(Simbolos.modulo, yycolumn, yyline, yytext());}

<YYINITIAL> "=="        {   return new Symbol(Simbolos.igualQue, yycolumn, yyline, yytext());}
<YYINITIAL> "!="        {   return new Symbol(Simbolos.difQue, yycolumn, yyline, yytext());}


<YYINITIAL> ">"         {   return new Symbol(Simbolos.mayorQue, yycolumn, yyline, yytext());}
<YYINITIAL> ">="        {   return new Symbol(Simbolos.mayorIgualQue, yycolumn, yyline, yytext());}

<YYINITIAL> "<"         {   return new Symbol(Simbolos.menorQue, yycolumn, yyline, yytext());}
<YYINITIAL> "<="        {   return new Symbol(Simbolos.menorIgualQue, yycolumn, yyline, yytext());}

<YYINITIAL> "&"         {   return new Symbol(Simbolos.and, yycolumn, yyline, yytext());}
<YYINITIAL> "|"         {   return new Symbol(Simbolos.or, yycolumn, yyline, yytext());}
<YYINITIAL> "!"         {   return new Symbol(Simbolos.not, yycolumn, yyline, yytext());}
<YYINITIAL> "?"         {   return new Symbol(Simbolos.tern, yycolumn, yyline, yytext());}
<YYINITIAL> ":"         {   return new Symbol(Simbolos.dosp, yycolumn, yyline, yytext());}
<YYINITIAL> "["         {   return new Symbol(Simbolos.abra, yycolumn, yyline, yytext());}
<YYINITIAL> "]"         {   return new Symbol(Simbolos.cbra, yycolumn, yyline, yytext());}
<YYINITIAL> ","         {   return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}




//-------> PR

<YYINITIAL> {c}             {  return new Symbol(Simbolos.c, yyline, yycolumn, yytext()); }
<YYINITIAL> {print}         {  return new Symbol(Simbolos.print, yyline, yycolumn, yytext()); }
<YYINITIAL> {truee}         {  return new Symbol(Simbolos.truee, yyline, yycolumn, yytext()); }
<YYINITIAL> {falsee}        {  return new Symbol(Simbolos.falsee, yyline, yycolumn, yytext()); }
<YYINITIAL> {list}          {  return new Symbol(Simbolos.list, yyline, yycolumn, yytext()); }
<YYINITIAL> {nothing}          {  return new Symbol(Simbolos.nothing, yyline, yycolumn, yytext()); }

//-------> ER

<YYINITIAL> {identifier}    {   return new Symbol(Simbolos.identifier, yycolumn, yyline, yytext());}

<YYINITIAL> {decimal}       {   return new Symbol(Simbolos.decimal, yycolumn, yyline, yytext());}

<YYINITIAL> {numero}        {   return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}


//-------> Espacios
[ \t\r\n\f]                 {/* Espacios en blanco, se ignoran */ }

//-------> Errores Lexicos
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> Linea: "+yyline+" ,Columna: "+yycolumn);}