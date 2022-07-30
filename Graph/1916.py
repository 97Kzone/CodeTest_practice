import heapq
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

check = [10e9]  * (N+1)
board = [[] for _ in range(N+1)]

for _ in range(M):
    s, e, c = map(int, input().split())
    board[s].append((e, c))

def ds(start):
    q = []
    heapq.heappush(q, (0, start))
    check[start] = 0

    while q:
        d, i = heapq.heappop(q)
        if check[i] < d:
            continue

        for val in board[i]:
            tmp = d + val[1]

            if tmp < check[val[0]]:
                check[val[0]] = tmp
                heapq.heappush(q, (tmp, val[0]))

start, end = map(int, input().split())
ds(start)
print(check[end])
