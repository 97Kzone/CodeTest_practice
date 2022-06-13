N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

std = [[-1, 0], [1, 0], [0, -1], [0, 1]]
coin = []

for i in range(N):
    for j in range(M):
        if board[i][j] == "o":
            coin.append([i, j])
            
res = -1
def find(cnt, c):
    global res

    cx1, cy1 = c[0][0], c[0][1]
    cx2, cy2 = c[1][0], c[1][1]
 
    # 동전 겹침
    if cx1 == cx2 and cy1 == cy2:
        return
    # 동전 2개다 떨어짐
    if (not (0 <= cx1 < N) or not (0 <= cy1 < M)) and (not (0 <= cx2 < N) or not (0 <= cy2 < M)):
        return

    # 둘 중 하나만 떨어짐
    if (not (0 <= cx1 < N) or not (0 <= cy1 < M)) and ((0 <= cx2 < N) and (0 <= cy2 < M)):    
        res = min(cnt, res) if res != -1 else cnt
        return
    elif ((0 <= cx1 < N) and (0 <= cy1 < M)) and (not (0 <= cx2 < N) or not (0 <= cy2 < M)):
        res = min(res, cnt) if res != -1 else cnt
        return
    
    # 10번을 넘기면?
    if cnt == 10:
        return
    
    for dx, dy in std:
        temp = []
        for i in range(2):
            if 0 <= c[i][0] + dx < N and 0 <= c[i][1] + dy < M and board[c[i][0] + dx][c[i][1] +dy] == "#":
                temp.append(c[i])
            else:
                temp.append([c[i][0] + dx, c[i][1] + dy])

        if temp == c:
            continue

        find(cnt + 1, temp)

find(0, coin)
print(res)