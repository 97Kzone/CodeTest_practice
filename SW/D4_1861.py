from collections import defaultdict, deque

def BFS(x, y, i, cnt):
    global res
    q = deque()
    q.append((x, y, i, cnt))

    while q:
        x, y, now, cnt = q.popleft()

        if board[x][y] == N**2:
            if res[1] < cnt:
                res = [i, cnt]
            return

        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if board[nx][ny] == now+1:    
                    q.append((nx, ny, now+1, cnt+1))
    
    if res[1] < cnt:
        res = [i, cnt]

for t in range(1, int(input())+1):
    N = int(input())
    check = defaultdict(list)
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    board = []
    for i in range(N):
        row = list(map(int, input().split()))
        for j in range(N):
            check[row[j]] = (i, j)
        board.append(row)

    res = [0, 0]
    for i in range(1, (N**2)+1):
        x, y = check[i]
        BFS(x, y, i, 1)

    print("#{} {} {}".format(t, res[0], res[1]))