const normal = (cb: (number) => number): void => {}
const error = (cb: (number, number?) => number): void => {} // TS2300: Duplicate identifier 'number' 발생
const fixed = (cb: (a: number, number?)=>number): void => {} // 함수 시그니처 변수에 a:타입 을 직접 지정해서 오류 해결.