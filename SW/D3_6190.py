def check(v):
    std = []
    while v > 0:
        d, m = divmod(v, 10)
        std.append(m)
        v = d
    
    for i in range(1, len(std)):
        if std[i] > std[i-1]:
            return False

    return True

for t in range(1, int(input())+1):
    N = int(input())
    nums = list(map(int, input().split()))
    res = -1
    for i in range(N):
        for j in range(i+1, N):
            tmp = nums[i] * nums[j]
            if check(tmp):
                res = max(res, tmp)
    
    print("{} {}".format(t, res))