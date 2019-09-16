package Tiny;

import java_cup.runtime.*;
//import otros.*;

%%
/* Habilitar la compatibilidad con el interfaz CUP para el generador sintactico*/
%cup
/* Llamar Scanner a la clase que contiene el analizador Lexico */
%class Scanner

/*-- DECLARACIONES --*/
%{
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
		lineanum=0;
		debug=true;
	}
	private SymbolFactory sf;
	private int lineanum;
	private boolean debug;
%}
%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}

/* Acceso a la columna y fila actual de analisis CUP */
%line
%column



digito		= [0-9]
numero		= {digito}+
letra			= [a-zA-Z]
identificador	= {letra}+
nuevalinea		= \n | \n\r | \r\n
espacio		= [ \t]+
%%
"if"            {	if(debug) System.out.println("token IF");
			return sf.newSymbol("IF",sym.IF);
			}
"then"          { if(debug) System.out.println("token THEN");
			return sf.newSymbol("THEN",sym.THEN);
			}
"else"          {	if(debug) System.out.println("token ELSE");
			return sf.newSymbol("ELSE",sym.ELSE);
			}
"end"           {	if(debug) System.out.println("token END");
			return sf.newSymbol("END",sym.END);
			}
"repeat"        {	if(debug) System.out.println("token REPEAT");
			return sf.newSymbol("REPEAT",sym.REPEAT);
			}
"until"         {	if(debug) System.out.println("token UNTIL");
			return sf.newSymbol("UNTIL",sym.UNTIL);
			}
"while"         {	if(debug) System.out.println("token WHILE");
			return sf.newSymbol("WHILE",sym.WHILE);
			}
"endwhile"         {	if(debug) System.out.println("token ENDWHILE");
			return sf.newSymbol("ENDWHILE",sym.ENDWHILE);
			}
"for"         {	if(debug) System.out.println("token FOR");
			return sf.newSymbol("FOR",sym.FOR);
			}
"endfor"         {	if(debug) System.out.println("token ENDFOR");
			return sf.newSymbol("ENDFOR",sym.ENDFOR);
			}
"read"          {	if(debug) System.out.println("token READ");
			return sf.newSymbol("READ",sym.READ);
			}
"write"         {	if(debug) System.out.println("token WRITE");
			return sf.newSymbol("WRITE",sym.WRITE);
			}
"array"			{	if(debug) System.out.println("token ARRAY");
			return sf.newSymbol("ARRAY",sym.ARRAY);
			}
"size"			{	if(debug) System.out.println("token SIZE");
			return sf.newSymbol("SIZE",sym.SIZE);
			}
":="            {	if(debug) System.out.println("token ASSIGN");
			return sf.newSymbol("ASSIGN",sym.ASSIGN);
			}
"="             {	if(debug) System.out.println("token EQ");
			return sf.newSymbol("EQ",sym.EQ);
			}
"<"             {	if(debug) System.out.println("token LT");
			return sf.newSymbol("LT",sym.LT);
			}
"<="             {	if(debug) System.out.println("token MI");
			return sf.newSymbol("MI",sym.MI);
			}
">"             {	if(debug) System.out.println("token GT");
			return sf.newSymbol("GT",sym.GT);
			}
">="             {	if(debug) System.out.println("token MAI");
			return sf.newSymbol("MAI",sym.MAI);
			}
"<>"             {	if(debug) System.out.println("token DIS");
			return sf.newSymbol("DIS",sym.DIS);
			}
"and"             {	if(debug) System.out.println("token CONJ");
			return sf.newSymbol("CONJ",sym.CONJ);
			}
"or"             {	if(debug) System.out.println("token DISY");
			return sf.newSymbol("DISY",sym.DISY);
			}
"not"             {	if(debug) System.out.println("token NEG");
			return sf.newSymbol("NEG",sym.NEG);
			}
"+"             {	if(debug) System.out.println("token PLUS");
			return sf.newSymbol("PLUS",sym.PLUS);
			}
"-"             {	if(debug) System.out.println("token MINUS");
			return sf.newSymbol("MINUS",sym.MINUS);
			}
"*"             {	if(debug) System.out.println("token TIMES");
			return sf.newSymbol("TIMES",sym.TIMES);
			}
"/"             {	if(debug) System.out.println("token OVER");
			return sf.newSymbol("OVER",sym.OVER);
			}
"("             {	if(debug) System.out.println("token LPAREN");
			return sf.newSymbol("LPAREN",sym.LPAREN);
			}
")"             {	if(debug) System.out.println("token RPAREN");
			return sf.newSymbol("RPAREN",sym.RPAREN);
			}
"["             {	if(debug) System.out.println("token LCOR");
			return sf.newSymbol("LCOR",sym.LCOR);
			}
"]"             {	if(debug) System.out.println("token RCOR");
			return sf.newSymbol("RCOR",sym.RCOR);
			}
";"             {	if(debug) System.out.println("token SEMI");
			return sf.newSymbol("SEMI",sym.SEMI);
			}
{numero}        {	if(debug) System.out.println("token NUM");
			return sf.newSymbol("NUM",sym.NUM,new String(yytext()));
			}
{identificador}	{	if(debug) System.out.println("token ID");
				return sf.newSymbol("ID",sym.ID,new String(yytext()));
			}
{nuevalinea}       {lineanum++;}
{espacio}    { /* saltos espacios en blanco*/}
"{"[^}]+"}"  { /* salto comentarios */ if(debug) System.out.println("token COMENTARIO"); }
.               {System.err.println("Caracter Ilegal encontrado en analisis lexico: " + yytext() + "\n");}