from collections import deque

F, S, G, U, D = map(int, input().split())
move = [U, -D]
check = set()
check.add(S)

def bfs():
    global res
    q = deque()
    q.append([S, 0])

    while q:
        floor, cnt = q.popleft()

        if floor == G:
            print(cnt)
            return
        
        for i in range(2):
            next = floor + move[i]

            if 0 < next <= F and not next in check:
                check.add(next)
                q.append([next, cnt+1])
    else:
        print("use the stairs")

bfs()
