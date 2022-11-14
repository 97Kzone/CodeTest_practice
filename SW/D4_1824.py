from collections import deque

moves = [(-1, 0), (1, 0), (0, -1), (0, 1)] #상하좌우 순
for t in range(1, int(input())+1):
    r, c = map(int, input().split())
    board =  [list(input()) for _ in range(r)]    
    visit = [[set() for _ in range(c)] for _ in range(r)]
    res = "NO"

    q = deque()
    q.append((0, 0, 0, 1, 0))
    while q:
        x, y, dx, dy, m = q.popleft()

        if board[x][y] == "@":
            res = "YES"
            break

        if board[x][y].isdigit():
            m = int(board[x][y])
        elif board[x][y] == "<":
            dx, dy = moves[2]
        elif board[x][y] == ">":
            dx, dy = moves[3]
        elif board[x][y] == "^":
            dx, dy = moves[0]
        elif board[x][y] == "v":
            dx, dy = moves[1]
        elif board[x][y] == "_":
            dx, dy = moves[3] if m == 0 else moves[2]
        elif board[x][y] == "|":
            dx, dy = moves[1] if m == 0 else moves[0]
        elif board[x][y] == "+":
            m = m+1 if m != 15 else 0
        elif board[x][y] == "-":
            m = m-1 if m != 0 else 15
        elif board[x][y] == ".":
            pass

        next = moves if board[x][y] == "?" else [(dx, dy)] 
        for dx, dy in next:
            if (dx, dy, m) not in visit[x][y]:
                nx = (x+dx)%r
                ny = (y+dy)%c
                q.append((nx, ny, dx, dy, m))
                visit[x][y].add((dx, dy, m))

    print("#{} {}".format(t, res))        

