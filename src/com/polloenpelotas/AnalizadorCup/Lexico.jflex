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



//-------> Estados
%state COMENT_SIMPLE
%state COMENT_MULTI

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


//-------> Simbolos
<YYINITIAL> ";"         {   return new Symbol(Simbolos.pComa, yycolumn, yyline, yytext());}
<YYINITIAL> "+"         {   return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}
<YYINITIAL> "-"         {   return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}
<YYINITIAL> "*"         {   return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}
<YYINITIAL> "/"         {   return new Symbol(Simbolos.dividir, yycolumn, yyline, yytext());}
<YYINITIAL> "^"         {   return new Symbol(Simbolos.potenciar, yycolumn, yyline, yytext());}
<YYINITIAL> "++"        {   return new Symbol(Simbolos.aumento, yycolumn, yyline, yytext());}
<YYINITIAL> "--"        {   return new Symbol(Simbolos.decremento, yycolumn, yyline, yytext());}
<YYINITIAL> "("         {   return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}
<YYINITIAL> ")"         {   return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}
<YYINITIAL> "="         {   return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}


//-------> Dato



<YYINITIAL> {identifier}        {   return new Symbol(Simbolos.identifier, yycolumn, yyline, yytext());}

<YYINITIAL> {decimal}           {   return new Symbol(Simbolos.decimal, yycolumn, yyline, yytext());}

<YYINITIAL> {numero}            {   return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}


//-------> Espacios
[ \t\r\n\f]                 {/* Espacios en blanco, se ignoran */ }

//-------> Errores Lexicos
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> Linea: "+yyline+" ,Columna: "+yycolumn);}