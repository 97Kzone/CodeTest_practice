import sys
input = sys.stdin.readline

for t in range(1, 11):
    N = int(input())
    nums = list(map(int, input().split()))

    res = 0
    for i in range(2, N-2):
        std = max(nums[i-2:i]+nums[i+1:i+3])
        
        if std > nums[i]:
            continue

        res += nums[i] - std
    
    print("#{} {}".format(t, res))