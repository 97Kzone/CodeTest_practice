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

Q = int(input())
board = defaultdict(list)

for _ in range(Q):
    nums = list(map(int, input().split()))

    # 입력받은 값이 dict 에 없다면 추가
    if nums[1] not in board:
        board[nums[1]] = q1(nums[1])

    res = board[nums[1]]

    # 쿼리 종류에 따라 구분
    if nums[0] == 1:
        print(res[nums[2]-1][nums[3]-1])
    else:
        for i in range(len(res)):
            for j in range(len(res)):
                if res[i][j] == nums[2]:
                    print(str(i+1) + " " + str(j+1))
                    break