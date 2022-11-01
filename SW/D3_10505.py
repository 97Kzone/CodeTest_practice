for t in range(1, int(input())+1):
    N = int(input())

    nums = list(map(int, input().split()))
    avg = sum(nums) / N

    res = 0
    for num in nums:
        if num <= avg:
            res += 1
    
    print("#{} {}".format(t, res))