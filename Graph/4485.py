import sys, heapq as hq
input = sys.stdin.readline

moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def check(g, v):
    q = []
    hq.heappush(q, (0, 0, g[0][0]))

    while q:
        x, y, d = hq.heappop(q)
        if v[x][y] < d:
            continue
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy
            
            if 0 <= nx < N and 0 <= ny < N:
                if d + g[nx][ny] < v[nx][ny]:
                    v[nx][ny] = d + g[nx][ny]
                    hq.heappush(q, (nx, ny, d+graph[nx][ny]))

idx = 1
while True:
    N = int(input())

    if N == 0:
        exit()

    graph = [list(map(int, input().split())) for _ in range(N)]
    visit = [[10e9] * N for _ in range(N)]
    visit[0][0] = graph[0][0]

    check(graph, visit)
    print("Problem " + str(idx) + ": " + str(visit[-1][-1]))
    idx += 1
