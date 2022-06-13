from collections import deque
import sys

N, M, K = map(int, input().split())
map = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
move = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs():
    q = deque()
    q.append([0, 0, 0])
    check = [[[0] * (K+1) for _ in range(M)] for _ in range(N)]
    check[0][0][0] = 1

    while q:
        x, y, h = q.popleft()

        if x == N-1 and y == M-1:
            return check[x][y][h]

        for dx, dy in move:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if check[nx][ny][h] == 0:
                    if map[nx][ny] == '1' and h < K:
                        check[nx][ny][h+1] = check[x][y][h] + 1
                        q.append([nx, ny, h+1])

                    elif map[nx][ny] == '0':
                        check[nx][ny][h] = check[x][y][h] + 1
                        q.append([nx, ny, h])
    return -1

print(bfs())

