from collections import deque

l, s = map(int, input().split())
g = [i for i in range(101)]
check = [-1] * 101

for i in range(l + s):
    x, y = map(int, input().split())
    g[x] = y

q = deque()
q.append(1)
check[1] = 0

while q:
    idx = q.popleft()
    for i in range(1, 7):
        move = idx + i

        if move > 100:
            continue

        move = g[move]
        if check[move] == -1 or check[move] > check[idx] + 1:
            check[move] = check[idx] + 1
            q.append(move)

print(check[-1])