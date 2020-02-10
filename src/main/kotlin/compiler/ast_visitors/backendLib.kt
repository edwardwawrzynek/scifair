package compiler.ast_visitors

/** header for all generated code by the JSBackend to provide builtins */
val jsBackendCodeHeader = """
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
"""

val jsBackendPostHeader = """
/** invoke generated main function **/
main(process.argv.slice(2));
"""