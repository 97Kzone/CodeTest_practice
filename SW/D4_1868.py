from collections import deque
moves = [(-1, 0), (-1, -1), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

def check(i, j):
    for dx, dy in moves:
        nx = i + dx
        ny = j + dy

        if 0 <= nx < N and 0 <= ny < N:
            if board[nx][ny] == "*":
                return False

    return True

def flip(i, j):
    q = deque()
    q.append((i, j))
    board[i][j] = 1
    
    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if board[nx][ny] == ".":
                    if check(nx, ny):
                        q.append((nx, ny))
                    board[nx][ny] = 1

for t in range(1, int(input())+1):
    N = int(input())
    board = [list(input()) for _ in range(N)]

    res = 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == '.':
                if check(i, j):
                    res += 1
                    flip(i, j)

    print(board)
    for i in range(N):
        for j in range(N):
            if board[i][j] == ".":
                res += 1
    
    print("#{} {}".format(t, res))