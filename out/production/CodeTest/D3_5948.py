from itertools import combinations as cb

for t in range(1, int(input())+1):
    nums = list(map(int, input().split()))

    res = set()
    for v in cb(nums, 3):
        res.add(sum(v))
    
    res = sorted(res)

    print("#{} {}".format(t, res[-5]))