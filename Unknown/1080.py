N, M = map(int, input().split())

A = [list(map(int, input())) for _ in range(N)]
B = [list(map(int, input())) for _ in range(N)]

def flip(x, y):
    for i in range(x, x+3):
        for j in range(y, y+3):
            A[i][j] = 1 - A[i][j]

cnt = 0
for i in range(N-2):
    for j in range(M-2):
        if A[i][j] != B[i][j]:
            cnt += 1
            flip(i, j)

flag = False
for i in range(N):
    for j in range(M):
        if A[i][j] != B[i][j]:
            flag = True

if flag:
    print(-1)
else:
    print(cnt)

# 오늘 푼 문제 중 제일 오래 걸린 문제
# 접근 아이디어가 떠오르지 않아 노가다를 해야하나 고민에 빠짐, 최대한 노가다를 더는 방향으로 코딩
# 정답률 39%, solved 2022-01-07