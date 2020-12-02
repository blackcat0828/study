export type NumberTOFunc = (number) => number;
export const add = (a: number): NumberTOFunc => {
    const _add: NumberTOFunc = (b: number):number => {
        return a+b
    }
    return _add
}

