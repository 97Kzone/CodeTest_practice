for t in range(1, int(input())+1):
    nums = list(map(int, list(input().rstrip())))
    n = len(nums)
    while 1 in nums:
        for i in range(n):

            if nums[i] == 1:
                nums[i] = -1

                if i == 0:
                    nums[i+1] ^= 1
                elif i == n-1:
                    nums[i-1] ^= 1
                else:
                    nums[i+1] ^= 1
                    nums[i-1] ^= 1

    res = "no" if 0 in nums else "yes"
    print("#{} {}".format(t, res))
                    
    
