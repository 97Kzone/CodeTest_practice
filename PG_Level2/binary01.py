from collections import Counter as C
def solution(s):
    idx, cnt = 0, 0
    while s != "1":
        idx += 1
        cnt += C(s)["0"]
        s = s.replace("0", "", len(s))                
        s = format(len(s), 'b')

    
    return [idx, cnt]