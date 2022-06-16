from collections import deque

M, N = map(int, input().split())

nums = [list(map(int, input())) for _ in range(N)]
check = [[-1] * M for _ in range(N)]

check[0][0] = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
q = deque()
q.append([0, 0])

while q:
    i, j = q.popleft()
    for k in range(4):
        nx = i + dx[k]
        ny = j + dy[k]
        if 0 <= nx < N and 0 <= ny < M:
            if check[nx][ny] == -1:
                if nums[nx][ny] == 0:
                    check[nx][ny] = check[i][j]
                    q.appendleft([nx, ny])
                else: 
                    check[nx][ny] = check[i][j] + 1
                    q.append([nx, ny])
            print(q)
            print(check)

print(check[-1][-1])
