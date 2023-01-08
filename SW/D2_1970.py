nums = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

for t in range(1, int(input())+1):
    N = int(input())
    
    res = []
    for num in nums:
        v, N = divmod(N, num)
        res.append(v)
    
    print("#{}".format(t))
    print(" ".join(str(n) for n in res))

