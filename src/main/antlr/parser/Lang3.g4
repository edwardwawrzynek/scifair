grammar Lang3;

@header {
	package parser;
}

@parser::members {
    /**
     * Based on code from antlr4 golang grammar https://github.com/antlr/grammars-v4
     * Returns true iff on the current index of the parser's
     * token stream a token exists on the HIDDEN channel which
     * either is a line terminator, or is a multi line comment that
     * contains a line terminator.
         */

    private boolean lineTerminatorAhead() {
        // Get the token ahead of the current index.
        int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
        Token ahead = _input.get(possibleIndexEosToken);
        if (ahead.getChannel() != Lexer.HIDDEN) {
            // We're only interested in tokens on the HIDDEN channel.
            return false;
        }

        if (ahead.getType() == TERMINATOR) {
            // There is definitely a line terminator ahead.
            return true;
        }

        if (ahead.getType() == WS) {
            // Get the token ahead of the current whitespaces.
            possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 2;
            ahead = _input.get(possibleIndexEosToken);
        }

        // Get the token's text and type.
        String text = ahead.getText();
        int type = ahead.getType();

        // Check if the token is, or contains a line terminator.
        return (type == COMMENT && (text.contains("\r") || text.contains("\n"))) ||
                (type == TERMINATOR);

    }
}


program
	: statement* EOF
	;

expr
    :   '(' expr ')'                                #parenExpr
    |   varName=expr '.' sub=expr                   #dotExpr

    |   varName=expr '[' sub=expr ']'               #arraySubExpr
    |   varName=expr op=('++'|'--')                 #postfixExpr
    |	func=expr (args=expr ',')* (args=expr) 		#funcExpr
    |	func=expr '(' ')'							#noArgsFuncExpr

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
	:	'struct' name=ID '{' ( field=ID ':' value=expr ',' )* ( field=ID ':' value=expr )? '}'
	;

arrayExpr
	: '[' ']' type=typeExpr '[' (value=expr ',')* (value=expr)? ']'
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
	:	 name=ID ':' type=typeExpr
	;

structDeclExpr
	: 	'struct' name=ID '{' (fields=varDecl eos )* '}'
	;

varDeclExpr
	:	var=varDecl '=' value=expr
	;

lambdaExpr
	: '(' (args=varDecl ',')* (args=varDecl)? ')' '->' ret_type=typeExpr  '{' (body=statement)* '}'
	| '(' (args=varDecl ',')* (args=varDecl)? ')' '->' ret_type=typeExpr  '=>' (body=statement)
	;

funcDeclExpr
	: 	'fn' name=ID '(' (args=varDecl ',')* (args=varDecl)? ')' '->' ret_type=typeExpr '{' (body=statement)* '}'
	|	'fn' name=ID '(' (args=varDecl ',')* (args=varDecl)? ')' '->' ret_type=typeExpr '=>' body=statement
	;

forInitialExpr
	: expr | varDeclExpr
	;

forExpr
	:	'for'  initial=forInitialExpr ',' cond=expr ',' end=expr '{' (body=statement)* '}'
	;

typeExpr
	:	'struct' name=ID 				#structTypeExpr
	|	'[' ']' type=typeExpr			#arrayTypeExpr
	|	type=ID							#plainType
	;

ifStatementBody
	:	statement+
	;

ifStatement
	:	'if' cond=expr '{' (body=ifStatementBody) '}' ('elsif' cond=expr '{' (body=ifStatementBody) '}')* ('else' '{' (body=ifStatementBody) '}')?
	;

inlineIfStatement
	: 	body=inlineIfBodyStatement 'if' cond=expr
	;

unlessIfStatement
	: 	'unless' cond=expr '{' (body=ifStatementBody) '}'
	;

switchCase
	:	(cond=expr|'else') '->' '{' (body=statement)* '}'
	;

switchStatement
	:	'switch' value=expr '{' (conds=switchCase)* '}'
	;

returnStatement
	:	'return' value=expr
	;

// Inline if's have a limited set of statements which they can hold
inlineIfBodyStatement
	: 	funcDeclExpr		#inlineIfFuncDeclStatement
	|	varDeclExpr			#inlineIfVarDeclStatement
	|	forExpr				#inlineIfForStatement
	| 	structDeclExpr		#inlineIfStructDeclStatement
	| 	ifStatement			#inlineIfIfStatement
	|	switchStatement		#inlineIfSwitchStatement
	| 	unlessIfStatement	#inlineIfUnlessIfStatement
	|	returnStatement		#inlineIfReturnStatement
	|	expr				#inlineIfExprStatement
	;

statement
	: 	funcDeclExpr				#statementFuncDeclStatement
	|	varDeclExpr eos				#statementVarDeclStatement
	|	forExpr						#statementForStatement
	| 	structDeclExpr eos			#statementStructDeclStatement
	| 	ifStatement					#statementIfStatement
	| 	inlineIfStatement eos		#statementInlineIfStatement
	| 	unlessIfStatement			#statementUnlessIfStatement
	|	switchStatement				#statementSwitchStatement
	|	returnStatement eos			#statementReturnStatement
	|	expr eos					#statementExprStatement
	| 	lineComment					#statementLineComment
	;

eos
    : EOF
    | {lineTerminatorAhead()}?
    | {_input.LT(1).getText().equals("}") }?
    ;


lineComment
	:	LINE_COMMENT
	;

BOOL: 	'true' | 'false';
NULL: 	'null';
NUM :   '-'?[0-9]+;
FLOAT: 	'-'?([0-9]*[.])?[0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;

STR :   '"' (~'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';

WS  :  [ \t]+ -> channel(HIDDEN);
COMMENT:   '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '#' ~[\n]*;
TERMINATOR: [\n]+ -> channel(HIDDEN);