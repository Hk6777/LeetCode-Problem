import * as lCode from './public/leetcode.js'

async function main(){

    let s = "{}()[]";
    const valid = await lCode.lisValid(s)
    console.log(valid)

}

main()