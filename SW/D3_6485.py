from itertools import accumulate

for t in range(1, int(input())+1):
    N = int(input())
    nums = [0] * 5002
    res = []
    for _ in range(N):
        a, b = map(int, input().split())
        nums[a] += 1
        nums[b+1] -= 1

    nums = list(accumulate(nums))

    for _ in range(int(input())):
        res.append(nums[int(input())])
    
    print("#{} {}".format(t, " ".join(str(v) for v in res)))
