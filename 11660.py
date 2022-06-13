import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [[0] * (N+1)]

for _ in range(N):
    nums.append([0] + list(map(int, input().split())))

for i in range(1, N+1):
    for j in range(1, N):
        nums[i][j+1] += nums[i][j]

for i in range(1, N+1):
    for j in range(1, N):
        nums[j+1][i] += nums[j][i]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())

    res = (nums[x2][y2] - nums[x1-1][y2] - nums[x2][y1-1] + nums[x1-1][y1-1])
    print(res) 