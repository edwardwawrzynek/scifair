grammar Lang2;

@header {
	package parser;
}

program
	: statement* EOF
	;

expr
    :   '(' expr ')'                                #parenExpr
    |   varName=expr '.' sub=expr                   #dotExpr

    |   varName=expr '[' sub=expr ']'               #arraySubExpr
    |   varName=expr op=('++'|'--')                 #postfixExpr
    |	func=expr '(' (args=expr ',')* (args=expr)? ')'	#funcExpr

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
	: 	ret_type=typeExpr '(' (args=varDecl ',')* (args=varDecl)? ')' '{' (body=statement)* '}'
	;

funcDeclExpr
	: 	ret_type=typeExpr name=ID '(' (args=varDecl ',')* (args=varDecl)? ')' '{' (body=statement)* '}'
	;

forExpr
	:	'for' '(' initial=statement cond=expr ';' end=expr ')' '{' (body=statement)* '}'
	;

typeExpr
	:	'struct' name=ID 				#structTypeExpr
	|	type=typeExpr '[' ']'			#arrayTypeExpr
	|	type=ID							#plainType
	;

ifStatementBody
	:	statement+
	;

ifStatement
	:	'if' '(' cond=expr ')' '{' (body=ifStatementBody) '}' ('else' 'if' '(' cond=expr ')' '{' (body=ifStatementBody) '}')* ('else' '{' (body=ifStatementBody) '}')?
	;

returnStatement
	:	'return' value=expr
	;

statement
	: 	funcDeclExpr
	|	varDeclExpr ';'
	|	forExpr
	| 	structDeclExpr ';'
	| 	ifStatement
	|	returnStatement ';'
	|	expr ';'
	| 	lineComment
	| 	blankLine
	;

lineComment
	:	LINE_COMMENT
	;

blankLine
	:	BLANK_LINE
	;

BOOL: 	'true' | 'false';
NULL: 	'null';
NUM :   '-'?[0-9]+;
FLOAT: 	'-'?([0-9]*[.])?[0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;

STR :   '"' (~'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';

WS  :  ('\n'|[ \t])[ \t]* -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\n]*;
BLANK_LINE: '\n''\n';
