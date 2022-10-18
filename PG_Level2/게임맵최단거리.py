from collections import deque

def DFS(maps, n, m):
    global answer
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    visit = [[0] * m for _ in range(n)]
    visit[0][0] = 1
    
    q = deque([(0, 0, 1)])
    while q:
        x, y, c = q.popleft()
        
        if x == n-1 and y == m-1:
            answer = c
            return 
        
        for dx, dy in moves:
            nx = x + dx
            ny = y + dy
            
            if 0 <= nx < n and 0 <= ny < m:
                if maps[nx][ny] == 1 and visit[nx][ny] == 0:
                    visit[nx][ny] = 1
                    q.append((nx, ny, c+1))

def solution(maps):
    global answer
    answer = 0

    n, m = len(maps), len(maps[0])
    
    DFS(maps, n, m)
    
    return answer if answer != 0 else -1