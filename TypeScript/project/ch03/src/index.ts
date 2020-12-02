import * as T from './utils/prac'

let fn: T.NumberTOFunc = T.add(1)

let result = fn(2)
console.log(result)
console.log(T.add(1)(2))
console.log(T.add(1))



