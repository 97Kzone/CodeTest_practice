for t in range(1, 11):
    N = int(input())
    nums = list(map(int, input().split()))

    while N > 0:
        if max(nums) - min(nums) == 0:
            break

        i1 = nums.index(max(nums))
        i2 = nums.index(min(nums))

        nums[i1] -= 1
        nums[i2] += 1
        N -= 1
    res = max(nums) - min(nums)
    print("#{} {}".format(t, res))
    