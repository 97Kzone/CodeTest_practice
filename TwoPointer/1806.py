N, M = map(int, input().split())
nums = list(map(int, input().split()))
l, r, tmp = 0, 0, nums[0]

res = 10e9
while True:
    if tmp >= M:
        tmp -= nums[l]
        res = min(res, r - l + 1)
        l += 1
    else:
        r += 1
        if r == N:
            break
        tmp += nums[r]

print(res if res != 10e9 else 0) 

