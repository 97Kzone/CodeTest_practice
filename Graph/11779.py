import sys, heapq
input = sys.stdin.readline

def ds(start):
    q = [(0, start)]
    
    while q:   
        d, i = heapq.heappop(q)
        
        if dist[i] < d:
            continue

        for nxt, nxtdist in board[i]:
            tmp = d + nxtdist

            if tmp < dist[nxt]:
                dist[nxt], check[nxt] = tmp, i
                heapq.heappush(q, (tmp, nxt))

N = int(input())
M = int(input())
board = [[] for _ in range(N+1)]

for _ in range(M):
    s, e, c = map(int, input().split())
    board[s].append((e, c))

start, end = map(int, input().split())
check = [start] * (N+1)
dist = [10e9] * (N+1)    

ds(start)

res, tmp = [], end
while tmp != start:
    res.append(tmp)
    tmp = check[tmp]

res.append(start)
res.reverse()

print(dist[end])
print(len(res))
print(" ".join(str(v) for v in res))