for t in range(1, int(input())+1):
    N, Q = map(int, input().split())
    nums = [0] * (N+1)
    for i in range(1, Q+1):
        l, r = map(int, input().split())

        std = [i] * (r-l+1)
        nums[l:r+1] = std
    
    res = " ".join(str(v) for v in nums[1:])
    print("#{} {}".format(t, res))