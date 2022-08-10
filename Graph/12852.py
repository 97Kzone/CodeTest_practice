from collections import deque
N = int(input())
visit = [0 for _ in range(N+1)]

def check(n, std):
    q = deque()
    q.append((n, std))
    visit[n] = 1
    while q:
        n, std = q.popleft()

        if n == 1:
            print(len(std))
            print(*(std + [n]))
            return

        if n % 3 == 0:
            if visit[n//3] == 0:
                visit[n//3] = 1
                q.append((n//3, std + [n]))
        
        if n % 2 == 0:
            if visit[n//2] == 0:
                visit[n//2] = 1
                q.append((n//2, std + [n]))

        if visit[n-1] == 0:
            visit[n-1] = 1
            q.append((n-1, std + [n]))
        

check(N, [])