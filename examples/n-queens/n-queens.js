/** --- Generated JS output from file n-queens.lg1 --- **/
/** builtin functions **/
var __fs = require("fs");
var __fs_input = "";

let print = (msg) => {
    console.log(msg);
    return 0;
};

let printnum = (num) => {
    console.log(num);
    return 0;
}

let input = () => {
    if(__fs_input == "") {
        __fs_input = __fs.readFileSync(0);
    }

    let res = "";
    let c = '';
    do {
        if(__fs_input.length == 0) break;
        c = __fs_input[0];
        res += String.fromCharCode(c);
        __fs_input = __fs_input.slice(1);
    } while(c != 10);

    return res;
};
/* N-Queens problem solver example program*/;
/* Author: Edward Wawrzynek*/;
/**/;
let makeIntArray = ((size, val, ) => {
let res = [];
for (let i = 0; (i) < (size); i = (i) + (1)) {
(res).push(val, );
};
return res;
});
/**/;
class board {
constructor({size, yloc, }) {
this.size = size;
this.yloc = yloc;
}
};
/**/;
/* make a blank board*/;
let makeBoard = ((n, ) => {
return (new board({size: n, yloc: makeIntArray(n, -1, ), }));
});
/**/;
/* print out a board*/;
let printBoard = ((board, ) => {
for (let y = 0; (y) < ((board).size); y = (y) + (1)) {
let line = "";
for (let x = 0; (x) < ((board).size); x = (x) + (1)) {
if ((((board).yloc)[x]) == (y)) {
line = (line) + (" Q");
}else if (true) {
line = (line) + (" .");
};
};
print(line, );
};
let l = "";
for (let n = 0; (n) < ((board).size); n = (n) + (1)) {
l = (l) + ("--");
};
print(l, );
return 0;
});
/**/;
/* check that a board is valid*/;
let checkBoard = ((b, ) => {
/* check that no row has two pieces*/;
let rowsFilled = makeIntArray((b).size, 0, );
for (let x = 0; (x) < ((b).size); x = (x) + (1)) {
if ((((b).yloc)[x]) != (-1)) {
if (!(((rowsFilled)[((b).yloc)[x]]) != (1))) {
return false;
};
(rowsFilled)[((b).yloc)[x]] = 1;
};
};
/* check diagonals*/;
/* left-down diagonals*/;
let diag1 = makeIntArray((((b).size) * (2)) - (1), 0, );
/* right-down diagonals*/;
let diag2 = makeIntArray((((b).size) * (2)) - (1), 0, );
for (let n = 0; (n) < ((b).size); n = (n) + (1)) {
if ((((b).yloc)[n]) != (-1)) {
if (((diag1)[(n) + (((b).yloc)[n])]) == (1)) {
return false;
};
if (((diag2)[(((n) + ((b).size)) - (1)) - (((b).yloc)[n])]) == (1)) {
return false;
};
(diag1)[(n) + (((b).yloc)[n])] = 1;
(diag2)[(((n) + ((b).size)) - (1)) - (((b).yloc)[n])] = 1;
};
};
return true;
});
/**/;
/* solve a board by brute force*/;
let solve = ((b, x, ) => {
if ((x) == ((b).size)) {
printBoard(b, );
return 1;
}else if (true) {
for (let y = 0; (y) < ((b).size); y = (y) + (1)) {
((b).yloc)[x] = y;
if (checkBoard(b, )) {
solve(b, (x) + (1), );
};
((b).yloc)[x] = -1;
};
};
});
/**/;
let main = ((args, ) => {
let b = makeBoard(8, );
solve(b, 0, );
});

/** invoke generated main function **/
main(process.argv.slice(2));
