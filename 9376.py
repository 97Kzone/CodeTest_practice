from cmath import inf
from collections import deque

T = int(input())
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def find(maps, l):
    for i in range(N+2):
        for j in range(M+2):
            if maps[i][j] == "$":
                l.append([i, j])
    return l

def bfs(x, y):
        q = deque()
        q.append([x, y])

        check = [[-1] * (M+2) for _ in range(N+2)]
        check[x][y] = 0

        while q:
            x, y = q.popleft()

            for dx, dy in move:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < N+2 and 0 <= ny < M+2:
                    if check[nx][ny] == -1:
                        if maps[nx][ny] == "." or maps[nx][ny] == "$":
                            check[nx][ny] = check[x][y]
                            q.appendleft([nx, ny])
                        elif maps[nx][ny] == "#":
                            check[nx][ny] = check[x][y] + 1
                            q.append([nx, ny])
        return check

for _ in range(T):
    N, M = map(int, input().split())

    maps = [list("." * (M+2))]
    for _ in range(N):
        maps.append(list("." + input().strip() + "."))
    maps.append(list("." * (M+2)))

    men = find(maps, [])

    res = []
    for x, y in men:
        res.append(bfs(x, y))
    res.append(bfs(0, 0))

    ans = inf
    for i in range(N+2):
        for j in range(M+2):
            if res[0][i][j] != -1 and res[1][i][j] != -1 and res[2][i][j] != -1:
                temp = res[0][i][j] + res[1][i][j] + res[2][i][j]
                if maps[i][j] == "*":
                    continue

                if maps[i][j] == "#":
                    temp -= 2
                
                ans = min(ans, temp)

    print(ans)
