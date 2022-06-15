import sys
from collections import defaultdict

input = sys.stdin.readline

def q1(N):
    arr = [[0 for _ in range(N)] for _ in range(N)]
    x, y, s, sw = -1, 0, 0, 1

    while N > 0:
        for _ in range(N):
            x += sw
            s += 1
            arr[y][x] = s
        N -= 1
        for _ in range(N):
            y += sw
            s += 1
            arr[y][x] = s
        sw *= -1

    return arr

def q2(N, k):
    for i in range(len(N)):
        for j in range(len(N)):
            if N[i][j] == k:
                return [i, j]

Q = int(input())
for _ in range(Q):
    nums = list(map(int, input().split()))
    board = defaultdict(list)

    if nums[1] not in board:
        board[nums[1]] = q1(nums[1])

    if len(nums) == 3:
        res = q2(board[nums[1]], nums[2])
        print(" ".join(str(i) for i in res))
    else:
        res = board[nums[1]]
        print(res[nums[2]-1][nums[3]-1])
    


