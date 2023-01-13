import sys
input = sys.stdin.readline

N, M = map(int, input().split())
words = [input().rstrip("\n") for _ in range(N)]
comp = [input().rstrip("\n") for _ in range(M)]

res = 0
for com in comp:
    for word in words:
        if word.startswith(com):
            res += 1
            break

print(res)