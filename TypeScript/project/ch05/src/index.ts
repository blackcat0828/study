import * as R from 'ramda'
import Chance from "chance";

let array : number[] = [4,3,78,2,5]
let [first, second, third, ...rest] = array

type obj = {name : string, age? : number}
let array2 : obj[] = [{name : "Jeff", age : 32},{name : "Jeff2"},{name : "Jeff3", age : 322}]

for(let {name, age} of array2){

    console.log("name : "+name+" age : "+age)
}

let num = R.range(1,5);
console.log("range test " + num[3]);
