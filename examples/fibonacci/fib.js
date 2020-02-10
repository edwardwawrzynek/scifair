/** --- Generated JS output from file fib.lg1 --- **/
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
/* Fibonacci Example Program*/;
/* Author: Edward Wawrzynek*/;
/**/;
/* return the n-th fibonacci number*/;
let fib = ((n, ) => {
let a = 0;
let b = 1;
for (let i = 0; (i) < (n); i = (i) + (1)) {
let tmp = b;
b = (a) + (b);
a = tmp;
};
return a;
});
/**/;
/* calculate the first 100 fib numbers*/;
let main = ((args, ) => {
for (let n = 0; (n) < (100); n = (n) + (1)) {
printnum(fib(n, ), );
};
});

/** invoke generated main function **/
main(process.argv.slice(2));
