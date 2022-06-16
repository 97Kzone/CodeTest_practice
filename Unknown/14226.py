from collections import deque

N = int(input())
q = deque()
std = [[-1] * (N+1) for _ in range(N+1)]
std[1][0] = 0

def bfs():
    while q:
        val, cnt = q.popleft()
        if val == N:
            print(std[val][cnt])
            break

        temp = [cnt, 0, -1]
        
        for i in range(3):
            v = val + temp[i]
            if v < 0 or v > N:
                continue

            if std[v][val] == -1 and i == 1:
                std[v][val] = std[val][cnt] + 1
                q.append([v, val])
            
            if std[v][cnt] == -1 and i != 1:
                std[v][cnt] = std[val][cnt] + 1
                q.append([v, cnt])

q.append([1, 0])
bfs()

