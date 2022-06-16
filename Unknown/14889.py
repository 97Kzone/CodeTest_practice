import sys

#입력 Data
N = int(input())
matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

#결과값을 위한 Data
flag = [False] * N
cnt, res = 0, 10000000

#가능한 집합을 Make
def make_set(val, cnt):
    if cnt == N//2:
        check()
        return

    if val == N:
        return

    flag[val] = True
    make_set(val+1, cnt+1)
    flag[val] = False
    make_set(val+1, cnt)


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
    return

make_set(0, cnt)
print(res)