import sys
input = sys.stdin.readline

N = int(input())
cnt = 0
words = []
for _ in range(N):
    r = list(input().split())
    cnt += len(r)
    words.append(r)
std = list(input().split())

if cnt == len(std):
    for s in std:
        for i, word in enumerate(words):
            if word:
                if s == word[0]:
                    words[i].pop(0)
                    break
        else:
            res = "Impossible"
            break
    else:
        res = "Possible"
else:
    res = "Impossible"

print(res)
