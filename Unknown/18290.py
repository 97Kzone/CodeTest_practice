N, M, K = map(int, input().split())

dx = [0, 0, 1, -1]
dy = [1, -1, 0 ,0]
def DFS(x, y, cnt, sum):
    if cnt == K:
        global res
        res = max(res, sum)
        return

    for i in range(x, N):
        for j in range(y if i == x else 0, M):        
            #방문을 했는가?
            if check[i][j]:
                continue
            #상하좌우 방문 확인
            flag = True
            for idx in range(4):
                nx, ny = i + dx[idx], j + dy[idx]
                if 0 <= nx < N and 0 <= ny < M and check[nx][ny]:
                    flag = False
            #상하좌우 방문 안했으면 재귀호출
            if flag:
                check[i][j] = True
                DFS(i, j, cnt+1, sum+board[i][j])
                check[i][j] = False

board = [list(map(int, input().split())) for _ in range(N)]
check = [[False] * M for _ in range(N)]

res = -10000000
DFS(0, 0, 0, 0)
print(res)