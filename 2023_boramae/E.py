from collections import deque

a, b, c, K = map(int, input().split())

#a 좌 b 우 c 뒤
q = deque()
q.append((a, 3, 1))
q.append((b, 1, 1))
q.append((c, 2, 1))

res = [10**9, -1]
while q:
    k, s, cnt = q.popleft()

    if k == K:
        if cnt < res[0]:
            res[0] = cnt
            res[1] = s
        continue
    
    if k+a <= K:
        q.append((k+a, abs((s-1)%4), cnt+1))
    
    if k+b <= K:
        q.append((k+b, (s+1)%4, cnt+1))
    
    if k+c <= K:
        q.append((k+c, (s+2)%4, cnt+1))

if res[1] == 0:
    print(res[0] if res[0] != 10**9 else -1)
else:
    print(-1)