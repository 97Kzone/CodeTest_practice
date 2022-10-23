from collections import deque

def check(board, q):
    v = len(q) ** (0.5)

    if v % 1 != 0:
        return False

    v = int(v)
    x, y = q.popleft()

    for i in range(x, x+v):
        for j in range(y, y+v):
            if board[i][j] != "#":
                return False
    return True

for t in range(1, int(input())+1):
    n = int(input())
    board = [list(input().rstrip()) for _ in range(n)]

    q = deque()
    for i in range(n):
        for j in range(n):
            if board[i][j] == "#":
                q.append((i, j))

    flag = check(board, q)

    if flag:
        print("#{} yes".format(t))
    else:
        print("#{} no".format(t))