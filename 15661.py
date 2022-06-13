import sys

N = int(input())
matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

flag = [False] * N

def make_set(val):
    if val == N:
        check()
        return

    flag[val] = True
    make_set(val+1)
    flag[val] = False
    make_set(val+1)

res = 10000000

def check():
    global res
    start, link = 0, 0

    for i in range(N-1):
        for j in range(i+1, N):
            if flag[i] and flag[j]:
                start += matrix[i][j] + matrix[j][i]
            elif not flag[i] and not flag[j]:
                link += matrix[i][j] + matrix[j][i]
    
    temp = abs(start-link)

    res = min(res, temp)

make_set(0)
print(res)    
