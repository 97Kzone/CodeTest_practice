import math

for t in range(1, int(input()) + 1):
    n = int(input())
    nums = list(map(int, input().split()))
    pr = [0] * (n+1)
    su = [0] * (n+1)

    pr[0] = nums[0]
    for i in range(1, n):
        pr[i] = math.gcd(pr[i-1], nums[i])
    
    su[n-1] = nums[n-1]
    for i in range(n-2, -1, -1):
        su[i]= math.gcd(su[i+1], nums[i])
    
    
    res = 0
    for i in range(n):
        l = pr[i-1]
        r = su[i+1]
        res = max(res, math.gcd(l, r))

    print("#{} {}".format(t, res))
    
