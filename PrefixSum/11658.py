import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [[0] + list(map(int, input().split())) for _ in range(N)]
nums.insert(0, [0] * (N+1))
bit = [[0] * (N+1) for _ in range(N+1)]

def update(x, y, v):
    while x <= N:
        ty = y
        while ty <= N:
            bit[x][ty] += v
            ty += (ty & -ty)
        x += (x & -x)

def q(x, y):
    res = 0
    while x > 0:
        ty = y
        while ty > 0:
            res += bit[x][ty]
            ty -= (ty & -ty)
        x -= (x & -x)

    return res

for i in range(1, N+1):
    for j in range(1, N+1):
        update(i, j, nums[i][j])

for _ in range(M):
    temp = list(map(int, input().split()))
    if temp[0] == 1:
        x1, y1, x2, y2 = temp[1], temp[2], temp[3], temp[4]
        res = q(x2, y2) - q(x2, y1-1) - q(x1-1, y2) + q(x1-1, y1-1)
        print(res)
    else:
        x, y, v = temp[1], temp[2], temp[3]
        diff = v - nums[x][y]
        nums[x][y] = v
        update(x, y, diff)

