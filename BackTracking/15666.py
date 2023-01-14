def check(v):
    if v == M:
        print(" ".join(str(s) for s in res))
        return
    
    for i in range(len(nums)):
        if v == 0 or res[-1] <= nums[i]:
            res.append(nums[i])
            check(v+1)
            res.pop()    

N, M = map(int, input().split())
nums = list(set(map(int, input().split())))
nums.sort()

res = []
check(0)