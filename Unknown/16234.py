from collections import deque

N, L, R = map(int, input().split())
world = [list(map(int, input().split())) for _ in range(N)]

move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(i, j):
    q = deque()
    q.append([i, j])
    std = [[i, j]]
    while q:
        x, y = q.popleft()

        for dx, dy in move:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if check[nx][ny] == 0:
                    if L <= abs(world[nx][ny] - world[x][y]) <= R:
                        check[nx][ny] = 1
                        q.append([nx, ny])
                        std.append([nx, ny])
    
    return std

res = 0
while True:
    check = [[0] * N for _ in range(N)]
    flag = 0

    for i in range(N):
        for j in range(N):
            if not check[i][j]:
                check[i][j] = 1
                temp = bfs(i, j)

                if len(temp) > 1:
                    flag = 1
                    np = sum([world[x][y] for x, y in temp]) // len(temp)
                    for x, y in temp:
                        world[x][y] = np
    
    if not flag:
        break
    res += 1        

print(res)         