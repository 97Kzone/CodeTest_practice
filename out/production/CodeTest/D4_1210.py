from collections import deque
moves = [(0, 1), (0, -1), (1, 0)]

def check(i, j):
    global board
    visit = [[0] * 100 for _ in range(100)]
    visit[i][j] = 1

    q = deque()
    q.append((i, j))

    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < 100 and 0 <= ny < 100:
                if board[nx][ny] == 2:
                    return [True, j]
                    
                if board[nx][ny] == 1 and visit[nx][ny] == 0:
                    q.append((nx, ny))
                    visit[nx][ny] = 1
                    break
        
    return [False, -1]
    
for _ in range(10):
    global board
    t = int(input())

    board, start = [], []  
    for i in range(100):
        r = list(map(int, input().split()))
        for j in range(100):
            if i == 0 and r[j] == 1:
                start.append((i, j))
        board.append(r)

    for x, y in start:
        flag, res = check(x, y)

        if flag:
            print("#{} {}".format(t, res))
            break
