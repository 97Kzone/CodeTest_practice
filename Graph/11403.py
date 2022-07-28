import sys
from collections import deque
from collections import defaultdict
input = sys.stdin.readline

def check(i):
    q = deque()
    q.append(dic[i])
    
    while q:
        val = q.popleft()
        for v in val:
            if res[i][v] == 0:
                res[i][v] = 1
                q.append(dic[v])

N = int(input())
dic = defaultdict(list)
board = [list(map(int, input().split())) for _ in range(N)]
res = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            dic[i].append(j)

for i in range(N):
    check(i)

for nums in res:
    print(" ".join(str(n) for n in nums))
