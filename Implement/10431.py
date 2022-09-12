import sys
input = sys.stdin.readline

idx = 1
for _ in range(int(input())):
    nums = list(map(int, input().split()))[1:]
    res = 0

    for i in range(1, 20):
        M, x = max(nums)+1, i

        for j in range(i):
            if nums[j] > nums[i] and nums[j] < M:
                M = nums[j]
                x = j
        
        if x != i:
            nums = nums[:x] + [nums[i]] + nums[x:i] + nums[i+1:]
            res += i-x

    print(idx, res)
    idx += 1
