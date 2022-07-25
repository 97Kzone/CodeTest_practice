import sys
input = sys.stdin.readline

N = int(input())
nums = [[0] + list(map(int, input().split())) for _ in range(N)]
nums.insert(0, [0] * (N+1))
check = [[[0] * 11 for _ in range(N+1)] for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, N+1): 
        if not check[i][j][nums[i][j]]:
            check[i][j][nums[i][j]] = 1

for i in range(1, N+1):
    for j in range(N+1):
        for k in range(11):
            check[i][j][k] += check[i-1][j][k]
        
for i in range(N+1):
    for j in range(1, N+1):
        for k in range(11):
            check[i][j][k] += check[i][j-1][k]

for _ in range(int(input())):
    x1, y1, x2, y2 = map(int, input().split())
    res = 0
    for k in range(1, 11):
        if check[x2][y2][k] - check[x2][y1-1][k] - check[x1-1][y2][k] + check[x1-1][y1-1][k]:
            res += 1
    
    print(res)