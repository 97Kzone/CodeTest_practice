from collections import deque

M, N = map(int, input().split())
board = [list(input()) for _ in range(N)]
move = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def find():
    std = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == "C":
                std.append([i, j])
    
    return std

def bfs(S, E):
    q = deque()
    q.append(S)
    check = [[100000] * M for _ in range(N)]
    check[S[0]][S[1]] = -1

    while q:
        x, y = q.popleft()

        if x == E[0] and y == E[1]:
            return check[x][y]      
        
        for dx, dy in move:
            nx = x + dx
            ny = y + dy

            while 1:
                if not (0 <= nx < N and 0 <= ny < M):
                    break
                    
                if board[nx][ny] == "*":
                    break

                if check[nx][ny] < check[x][y] + 1:
                    break

                q.append([nx, ny])
                check[nx][ny] = check[x][y] + 1
                nx += dx
                ny += dy
            print(check)

temp = find()
start, end = temp[0], temp[1]
print(bfs(start, end))
