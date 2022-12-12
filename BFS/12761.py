from collections import deque
A, B, N, M = map(int, input().split())
moves = [-1, 1, -A, A, -B, B, A, B]

visit = [0] * 100001
visit[N] = 1
q = deque()
q.append((N, 0))

while q:
    x, cnt = q.popleft()
    
    if x == M:
        print(cnt)
        break

    for i, v in enumerate(moves):
        if i < 6:
            nx = x + v
        else:
            nx = x * v

        if 0 <= nx < 100001 and not visit[nx]:
            visit[nx] = 1
            q.append((nx, cnt+1))
