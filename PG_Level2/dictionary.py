from itertools import product as pd

def solution(word):
    items = ["A", "E", "I", "O", "U"]
    ch = []
    for i in range(1, 6):
        for v in pd(items, repeat=i):
            ch.append("".join(v))
    
    ch.sort()

    return ch.index(word) + 1