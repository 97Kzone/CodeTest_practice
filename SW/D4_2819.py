from collections import deque

moves = [(-1, 0), (1, 0), (0 ,-1), (0, 1)]
def check(x, y):
    global res
    s = ""
    q = deque()
    q.append((x, y, s+str(board[x][y])))

    while q:
        x, y, s = q.popleft()

        if len(s) == 7:
            res.add(s)
            continue
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < 4 and 0 <= ny < 4:
                q.append((nx, ny, s+str(board[nx][ny])))
    

for t in range(1, int(input())+1):
    board = [list(map(int, input().split())) for _ in range(4)]
    
    global res
    res = set()
    for i in range(4):
        for j in range(4):
            check(i, j)
        
    print("#{} {}".format(t, len(res)))