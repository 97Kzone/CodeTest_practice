import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
dist = [10e9] * (N+1)

for _ in range(M):
    board.append(list(map(int, input().split())))

def bf(start):
    dist[start] = 0

    for i in range(N):
        for now, nxt, c in board:            
            if dist[now] != 10e9 and dist[nxt] > dist[now]+ c:
                dist[nxt] = dist[now] + c
                if i == N-1:
                    return False

    return True

flag = bf(1)

if not flag:
    print(-1)
else:
    for i in range(2, N+1):
        if dist[i] == 10e9:
            print(-1)
        else:
            print(dist[i])