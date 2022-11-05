from collections import deque

moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
def BFS(s):
    visit = [[0]*16 for _ in range(16)]
    visit[s[0]][s[1]] = 1

    q = deque()
    q.append(s)

    while q:
        x, y = q.popleft()

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < 16 and 0 <= ny < 16:
                if board[nx][ny] == 3:
                    return True

                if board[nx][ny] == 0 and visit[nx][ny] == 0:
                    visit[nx][ny] = 1
                    q.append((nx, ny))

    return False

for _ in range(10):
    board = []
    t = int(input())
    for i in range(16):
        r = list(map(int, list(input())))
        for j in range(16):
            if r[j] == 2:
                start = (i, j)
            
        board.append(r)
    
    res = 1 if BFS(start) else 0
    print("#{} {}".format(t, res))