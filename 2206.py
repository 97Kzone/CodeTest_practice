from collections import deque

N, M = map(int, input().split())
map = [list(input()) for _ in range(N)]
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs():
    q = deque()
    q.append([0, 0, 1])
    check = [[[0, 0] for _ in range(M)] for _ in range(N)]
    check[0][0][1] = 1

    while q:
        x, y, h = q.popleft()

        if x == N-1 and y == M-1:
            return check[x][y][h]

        for dx, dy in move:
            nx = x + dx
            ny = y + dy
        
            if 0 <= nx < N and 0 <= ny < M:
                if map[nx][ny] == '1' and h:
                    check[nx][ny][0] = check[x][y][h] + 1
                    q.append([nx, ny, 0])

                elif map[nx][ny] == '0' and check[nx][ny][h] == 0:
                    check[nx][ny][h] = check[x][y][h] + 1
                    q.append([nx, ny, h])
    return -1

res = bfs()
print(res)