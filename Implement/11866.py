from collections import deque

N, K = map(int, input().split())
q = deque([i for i in range(1, N+1)])

res = "<"
while q:
    for _ in range(K-1):
        q.append(q.popleft())

    res += str(q.popleft())
    if q:
        res += ", "
print(res + ">")