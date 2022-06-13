from collections import deque

N, K = map(int, input().split())
q = deque()
std = [-1] * 100001
std[N] = 0

def bfs():
    q.append(N)
    while q:
        val = q.popleft()
        if val == K:
            print(std[val])
            break

        if val*2 <= 100000 and std[val*2] == -1:
            std[val*2] = std[val]
            q.appendleft(val*2)
        
        for i in (val-1, val+1):
            if 0 <= i <= 100000 and std[i] == -1:
                std[i] = std[val] + 1
                q.append(i)


if K <= N:
    print(N-K)          

bfs()