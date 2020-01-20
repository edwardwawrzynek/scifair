/*user defined types*/;
class person {
constructor({name, age, parent, }) {
this.name = name;
this.age = age;
this.parent = parent;
}
};
/* user defined type literals*/;
let a = (new person({age: 0, name: "hello", parent: (new person({age: 1, name: "test", parent: null, })), }));
let variable = [0, 1, 2, 3, ];
let nested = [[0, 1, ], [3, 4, ], ];
/* variable definition*/;
/* Function calls*/;
print("hello, world", );
/* Conditionals*/;
;
/* Conditionals (alternate forms)*/;
/* ast->src conversion: use this form if a single conditional with a body of one expression is present*/;
;
/* ast->src conversion: use this form if a conditonal is a negation*/;
;
/* ast->src conversion: use this form if a conditional chain with at least two equality checks on the same variable is present*/;
;
/* Function expressions*/;
((a, b, ) => {
print("test func", )return (a) + (b);});
/* Named functions*/;
let sum = ((a, b, ) => {
print("test func", )return (a) + (b);});
/* functions (alternate form)*/;
/*ast->src conversion: use these forms if single expression body is present*/;
/* if we have type inference, specifying return type will be unnessesary*/;
((a, b, ) => {
return (a) + (b);});
let sum_inline = ((a, b, ) => {
return (a) + (b);});
/* Loops (note: this would be converted to a range automatically)*/;
;
/* Loops alternate forms*/;
/*ast->src conversion: use this form for a for loop with a starting assignment, less than check, and increment by one*/;
/* this form could easily support type inference*/;
/*range i: int in 0..5 {*/;
/*}*/;
let people = [(new person({name: "p1", age: 1, parent: null, })), (new person({name: "p2", age: 2, parent: null, })), ];
/* foreach form (type inference could be easily supported):*/;
/*foreach p: person, index: int in people {*/;
/*  printnum index*/;
/*  print p.name*/;
/*}*/;
/* the above loop would be matched to this form*/;
/*for index: int = 0, i < people.length, i++ {*/;
/*  p = people[i]*/;
/*  printnum index*/;
/*  print p.name*/;
/*}*/;
/* potentially also match this form (inline array index)*/;
/*for index: int = 0, i < people.length, i++ {*/;
/*  printnum index*/;
/*  print people[i].name*/;
/*}*/;
/* map espression*/;
/*names: []string = map elem: person, i: int in people => elem.name*/;
/* many loops could be pattern matched to a map, but we should at least support this form:*/;
/*names: []string = []*/;
/*foreach elem: person, i: int in people {*/;
/*  names.push(elem.name)*/;
/*}*/;
