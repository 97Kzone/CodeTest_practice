import sys
input = sys.stdin.readline

while True:
    N, M = map(int, input().split())
    res = 0
    if not N and not M:
        break

    dic = dict()
    for _ in range(N):
        dic[int(input())] = 1

    for _ in range(M):
        tmp = int(input())
        if tmp in dic:
            res += 1
    print(res)