import * as R from "./utils/range";
let numbers: number[] = R.range(1, 10);
console.log(numbers)

let sum1: number = 0;
let sum2: number = 0;

for (let i = 0; i < 101; i++) {
    sum1 += i;
}

for (let i = 0; i < 101; ++i) {
    sum2 += i;
}

console.log("sum1 : "+sum1)
console.log("sum2 : "+sum2)