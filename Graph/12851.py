from collections import deque, defaultdict

N, M = map(int, input().split())
check = [0] * 100001
check[N] = 1
res = defaultdict(int)

q = deque()
q.append((N, 0))
while q:
    x, cnt = q.popleft()
    check[x] = 1
    if x == M:
        res[cnt] += 1
    else:
        if 0 <= x-1 and not check[x-1]:
            q.append([x-1, cnt+1])

        if  x+1 < 100001 and not check[x+1]:
            q.append([x+1, cnt+1])

        if  x*2 < 100001 and not check[x * 2]:
            q.append([x*2, cnt+1])

for k in res.keys():
    print(k)
    print(res[k])
    break