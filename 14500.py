import sys 
input = sys.stdin.readline

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

#2X3 크기로 탐색
def width(i, j):
    temp = board[i][j:j+3] + board[i+1][j:j+3]
    val = max(temp[1], temp[4])
    temp.remove(val)
    temp.sort()
    return (val + sum(temp[-3:]))

#3X2 크기로 탐색    
def length(i, j):
    temp = board[i][j:j+2] + board[i+1][j:j+2] + board[i+2][j:j+2]
    val = max(temp[2], temp[3])
    temp.remove(val)
    temp.sort()
    return (val + sum(temp[-3:]))

#1X4 크기로 탐색
def check_col(i, j):
    col = board[i][j:j+4]
    return sum(col)

#4X1 크기로 탐색
def check_row(i, j):
    row = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]
    return row

res = 0
#2X3 탐색
for i in range(N-1):
    for j in range(M-2):
        val = width(i, j)
        res = max(res, val) 

#3X2 탐색
for i in range(N-2):
    for j in range(M-1):
        val = length(i, j)
        res = max(res, val)

#행 탐색
for i in range(N):
    for j in range(M-3):
        val = check_col(i, j)
        res = max(res, val)

#열 탐색
for i in range(N-3):
    for j in range(M):
        val = check_row(i, j)
        res = max(res, val)

print(res)