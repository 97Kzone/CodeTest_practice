from collections import deque

N = int(input())
x1, y1, x2, y2 = map(int, input().split())
cal = [[-2, -1], [-2, 1], [0, -2], [0, 2], [2, -1], [2, 1]]
check = [[-1] * N for _ in range(N)]

def bfs(x, y):
    q = deque()
    q.append([x1, y1])
    check[x][y] = 0

    while q:
        x, y = q.popleft()

        for c1, c2 in cal:
            dx = x + c1
            dy = y + c2        

            if 0 <= dx < N and 0 <= dy < N and check[dx][dy] == -1:
                q.append([dx, dy])
                check[dx][dy] = check[x][y] + 1

bfs(x1, y1)
print(check[x2][y2])
