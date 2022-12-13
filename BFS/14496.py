import sys
from collections import deque
input = sys.stdin.readline

def BFS(v):
    q = deque()
    q.append((v, 0))
    visit = [0] * (N+1)
    visit[v] = 1

    while q:
        x, cnt = q.popleft()

        if x == e:
            print(cnt)
            return
        
        for num in nums[x]:
            if not visit[num]:
                visit[num] = 1
                q.append((num, cnt+1))
                
    print(-1)
    return

s, e = map(int, input().split())
N, M = map(int, input().split())
nums = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    nums[a].append(b)
    nums[b].append(a)
BFS(s)
