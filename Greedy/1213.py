import sys
from collections import Counter as C

words = list(sys.stdin.readline().rstrip())
res = ["" for _ in range(len(words))]
cnt = C(words)

std, i = "", 0
for c, n in cnt.items():
    if n % 2 == 1:
        i += 1
        std = c   

    if i == 2:
        print("I'm Sorry Hansoo")
        exit()

i, j = 0, len(words)-1
for v in range(65, 91):
    for _ in range(cnt[chr(v)]//2):
        res[i] = chr(v)
        res[j] = chr(v)

        i += 1
        j -= 1

    if cnt[chr(v)] % 2 == 1:
        res[len(words)//2] = chr(v) 
    
print("".join(res))