grammar Lang2;

@header {
	package parser;
}

program
	: statment* EOF
	;

expr
    :   '(' expr ')'                                #parenExpr
    |   varName=expr '.' sub=expr                   #dotExpr

    |   varName=expr '[' sub=expr ']'               #arraySubExpr
    |   varName=expr op=('++'|'--')                 #postfixExpr
    |	func=ID '(' (args=expr ',')* (args=expr)? ')'	#funcExpr

    |   op=('++'|'--') varName=expr                 #prefixExpr
    |   op=('+'|'-') varName=expr                   #prefixExpr
    |   op=('!'|'~') varName=expr                   #prefixExpr

    |   left=expr op=('*'|'/'|'%') right=expr       #infixExpr
    |   left=expr op=('+'|'-') right=expr           #infixExpr

    |   left=expr op=('<<'|'>>') right=expr         #infixExpr

    |   left=expr op=('<'|'<='|'>'|'>=') right=expr #infixExpr

    |   left=expr op=('=='|'!=') right=expr         #infixExpr

    |   left=expr op='&' right=expr                 #infixExpr
    |   left=expr op='|' right=expr                 #infixExpr
    |   left=expr op='^' right=expr                 #infixExpr

    |   left=expr op='&&' right=expr                #infixExpr
    |   left=expr op='||' right=expr                #infixExpr

    |   left=expr op=('='|'+='|'-='|'*='|'/='|'%='|'<<='|'>>='|'&='|'^='|'|=') right=expr   #assignmentExpr
	|	literalExpr									#litExpr
	| 	lambdaExpr									#closureExpr
	|	ID											#varExpr
	;

structExpr
	:	'(' 'struct' name=ID ')' '{' ( '.' field=ID '=' value=expr ',' )* ( '.' field=ID '=' value=expr )? '}'
	;

arrayExpr
	: '(' type=typeExpr '[' ']' ')' '{' (value=expr ',')* (value=expr)? '}'
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
	:	 type=typeExpr name=ID
	;

structDeclExpr
	: 	'struct' name=ID '{' (fields=varDecl ';' )* '}'
	;

varDeclExpr
	:	var=varDecl '=' value=expr
	;

lambdaExpr
	: 	ret_type=typeExpr '(' (args=varDecl ',')* (args=varDecl)? ')' '{' (body=statment)* '}'
	;

funcDeclExpr
	: 	ret_type=typeExpr name=ID '(' (args=varDecl ',')* (args=varDecl)? ')' '{' (body=statment)* '}'
	;

forExpr
	:	'for' '(' initial=statment cond=expr ';' end=expr ')' '{' (body=statment)* '}'
	;

typeExpr
	:	'struct' name=ID 				#structTypeExpr
	|	type=typeExpr '[' ']'			#arrayTypeExpr
	|	type=ID							#plainType
	;

ifStatment
	:	'if' '(' cond=expr ')' '{' (body=statment)* '}' ('else' 'if' '(' cond=expr ')' '{' (body=statment)* '}')* ('else' '{' (body=statment)* '}')?
	;

returnStatment
	:	'return' value=expr
	;

statment
	: 	funcDeclExpr
	|	varDeclExpr ';'
	|	forExpr
	| 	structDeclExpr ';'
	| 	ifStatment
	|	returnStatment ';'
	|	expr ';'
	;

BOOL: 	'true' | 'false';
NULL: 	'null';
NUM :   '-'?[0-9]+;
FLOAT: 	'-'?([0-9]*[.])?[0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;

STR :   '"' (~'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';

WS  :  [ \t\n\r]+ -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\n]* -> skip;
