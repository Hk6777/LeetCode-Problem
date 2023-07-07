

export const lisValid = async (s) => {

    const ss = [];

    for (let i = 0; i < s.length; i++) {

        if (s == "(" || s == "[" || s == "{") {

            ss.push(s)

        } else {

            const last = ss.pop()

            if ((s == ')' && last != '(') || (s == ']' && last != '[') || (s == '}' && last != '{')) {
                return false
            }
        }

    }

    return ss.length === 0;
};