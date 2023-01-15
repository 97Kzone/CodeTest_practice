nums = [2, 3, 5, 7, 11]

def check(n):
    idx = 0
    d = nums[idx]
    
    while d <= n:
        if n % d == 0:
            res[idx] += 1
            n //= d
        else:
            idx += 1
            d = nums[idx]
    
for t in range(1, int(input())+1):
    N = int(input())
    res = [0, 0, 0, 0, 0]

    check(N)    
    print("#{} {} {} {} {} {}".format(t, *res))