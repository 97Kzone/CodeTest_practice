from itertools import combinations as cb

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
h, s = [], []

def check(store, home):
    res = 0
    for i, j in home:
        m = 10000
        for x, y in store:
            m = min(m, abs(i-x) + abs(j-y))
        res += m
    
    return res

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            h.append([i, j])
        elif board[i][j] == 2:
            s.append([i, j])

ans = []
for val in list(cb(s, M)):
    ans.append(check(val, h))

print(min(ans))