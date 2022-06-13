from itertools import combinations as cb

L, C = map(int, input().split())
words = sorted(input().split())

std = {'a', 'e', 'i', 'o', 'u'}

def make_word():
    res = []
    for word in list(cb(words, L)):
        vow, con = 0, 0
        for c in word:
            if c in std:
                vow += 1
            else:
                con += 1
        
        if vow > 0 and con > 1:
            res.append("".join(word))

    return res

for val in make_word():
    print(val)