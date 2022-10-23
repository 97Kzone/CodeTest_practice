for t in range(1, int(input())+1):
    n = int(input())
    nums = [n*k for k in range(2, 10)]
    
    cnt = [0] * 10
    for i in str(n):
        cnt[int(i)] += 1
	
    for num in nums:
        tmp = [0] * 10
        for v in str(num):
            tmp[int(v)] += 1
		
        for v1, v2 in zip(cnt, tmp):
            if v1 != v2:
                break
        else:
            print("#{} possible".format(t))
            break
    else:
        print("#{} impossible".format(t))
