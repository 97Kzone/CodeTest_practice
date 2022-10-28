from collections import Counter
res = []
for t in range(1, int(input())+1):
    s = list(input().rstrip())

    w = []
    cnt = Counter(s)
    for k, v in cnt.items():
        if v % 2 == 1:
            w.append(k)
    
    w.sort()
    res.append("Good" if len(w) == 0 else "".join(w))

for i in range(1, t+1):
    print("#{} {}".format(i, res[i-1]))
