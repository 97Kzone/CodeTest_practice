from collections import Counter as C
res = []
for i in range(1, int(input())+1):
    c = C(list(str(i)))
    cnt = c["3"] + c["6"] + c["9"]
    
    v = i if cnt == 0 else "-" * cnt
    res.append(v)

print(*res)
        