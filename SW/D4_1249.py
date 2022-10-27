from collections import deque
moves = [(0, -1), (0, 1), (-1, 0), (1, 0)]

def BFS(board, N):
    global res
    
    dp = [[0] * N for _ in range(N)]
    visit = [[0] * N for _ in range(N)]
    visit[0][0] = 1

    q = deque()
    q.append((0, 0, 0))

    while q:
        x, y, c = q.popleft()

        if x == N-1 and y == N-1:
            res = min(res, c)
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N:
                nc = c + board[nx][ny]
                if visit[nx][ny] == 0:
                    dp[nx][ny] = nc
                    q.append((nx, ny, nc))
                    visit[nx][ny] = 1
                else:
                    if nc < dp[nx][ny]:
                        dp[nx][ny] = nc
                        q.append((nx, ny, nc)) 
                
for t in range(1, int(input())+1):
    global res
    N = int(input())
    board = [list(map(int, list(input().rstrip()))) for _ in range(N)]
    
    res = 10**9
    BFS(board, N)
    
    print("#{} {}".format(t, res))