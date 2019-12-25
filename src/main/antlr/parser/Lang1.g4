grammar Lang1;

@header {
	package parser;
}

program
	: expr* EOF
	;

funcName
	: 	ID
	| 	'+'
	| 	'-'
	|	'*'
	| 	'/'
	|	'%'
	|	'='
	|	'>>'
	|	'<<'
	|	'>='
	|	'<='
	|	'>'
	|	'<'
	|	'=='
	|	'!='
	|	'&&'
	|	'||'
	|	'|'
	|	'&'
	|	'^'
	|	'~'
	|	'!'
	;

funcCallExpr
	:	'(' func=funcName (args=expr)* ')'
	;

structExpr
	:	'(' 'struct' name=ID ( '(' field=ID value=expr ')' )* ')'
	;

arrayExpr
	: '(' 'array' type=typeExpr (value=expr)* ')'
	;

literalExpr
	:	structExpr		#structLiteral
	|	arrayExpr		#arrayLiteral
	| 	value=STR		#strLiteral
	|	value=NUM		#numLiteral
	| 	value=NULL		#nullLiteral
	|	value=FLOAT		#floatLiteral
	|	value=BOOL		#booleanLiteral
	;

varDecl
	:	'(' name=ID type=typeExpr ')'
	;

structDeclExpr
	: 	'(' 'defstruct' name=ID '(' (fields=varDecl)* ')' ')'
	;

varDeclExpr
	:	'(' 'setq' var=varDecl value=expr ')'
	;

lambdaExpr
	: 	'(' 'lambda' ret_type=typeExpr '(' (args=varDecl)* ')' (body=expr)* ')'
	;

funcDeclExpr
	: 	'(' 'defun' name=ID ret_type=typeExpr '(' (args=varDecl)* ')' (body=expr)* ')'
	;

forExpr
	:	'(' 'for' initial=expr cond=expr end=expr '(' (body=expr)* ')' ')'
	;

typeExpr
	:	'(' 'struct' name=ID ')' 		#structTypeExpr
	|	'(' 'array' type=typeExpr ')'	#arrayTypeExpr
	|	type=ID							#plainType
	;

expr
	: 	funcDeclExpr
	| 	lambdaExpr
	|	varDeclExpr
	|	forExpr
	|	literalExpr
	| 	structDeclExpr
	|	typeExpr
	|	funcCallExpr
	;



BOOL: 	'true' | 'false';
NULL: 	'null';
NUM :   '-'?[0-9]+;
FLOAT: 	'-'?([0-9]*[.])?[0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;

STR :   '"' (~'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';

WS  :  [ \t\n\r]+ -> channel(HIDDEN);
LINE_COMMENT: ';' ~[\n]* -> skip;
