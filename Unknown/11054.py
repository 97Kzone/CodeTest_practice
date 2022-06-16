N = int(input())
nums = list(map(int, input().split()))

up = [1] * N
dw = [1] * N

for i in range(1, N):
    for j in range(i):
        if nums[i] > nums[j]:
            up[i] = max(up[i], up[j]+1)

for i in range(N-2, -1, -1):
    for j in range(N-1, i, -1):
        if nums[i] > nums[j]:
            dw[i] = max(dw[i], dw[j]+1)

res = 0
for i in range(N):
    res = max(res, up[i]+dw[i]-1)
print(res)