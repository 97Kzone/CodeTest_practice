import sys
from collections import deque
input = sys.stdin.readline

def check():
    q = deque()
    q.append(start)

    while q:
        x, y = q.popleft()

        if abs(board[-1][0] - x) + abs(board[-1][1] - y) <= 1000:
            print("happy")
            return
        
        for i in range(N):
            if not visit[i]:
                nx, ny = board[i]
                if abs(nx - x) + abs(ny - y) <= 1000:
                    q.append([nx, ny])
                    visit[i] = 1
    
    print("sad")
    return


for _ in range(int(input())):
    
    N = int(input())
    start = list(map(int, input().split()))
    board = [list(map(int, input().split())) for _ in range(N+1)]

    visit = [0] * (N+1)
    
    check()
    