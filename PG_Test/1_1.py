from collections import Counter as C

def solution(X, Y):
    answer = ''
    x, y = C(X), C(Y)

    std = []
    for i in range(10):
        if str(i) in x and str(i) in y:
            std.append((i, min(x[str(i)], y[str(i)])))
    
    std.sort(key = lambda x : x[0], reverse = True)

    if len(std) == 0:
        return "-1"

    if len(std) == 1 and std[0][0] == 0:
        return "0"

    for k, v in std:
        answer += str(k) * v    

    return answer