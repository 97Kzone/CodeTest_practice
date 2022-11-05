for t in range(1, int(input())+1):
    L, R, N = map(int, input().split())
    l, r = str(L), str(R)
    nums = list(map(int, input().split()))
    res = ""
    for num in nums:
        n = str(num)
        
        for i in range(1, len(n)+1):
            if int(l[:i]) <= int(n[:i]) <= int(r[:i]):
                continue
            else:
                res += "X"
                break
        else:
            res += "O"
    
    print("#{} {}".format(t, res))