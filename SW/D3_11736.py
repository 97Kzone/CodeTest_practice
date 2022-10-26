for t in range(1, int(input())+1):
    N = int(input())
    nums = list(map(int, input().split()))
    
    res = 0
    for i in range(1, N-1):
        n = min(nums[i-1:i+2])
        m = max(nums[i-1:i+2])
        if nums[i] != n and nums[i] != m:
            res += 1

    print("#{} {}".format(t, res))