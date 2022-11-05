from collections import defaultdict

for T in range(1, int(input())+1):
    N, K = map(int, input().split())
    dic = defaultdict(list)

    pick = list(map(int, input().split()))
    time = list(map(int, input().split()))

    i = 0
    for p, t in zip(pick, time):
        dic[p].append((i, t))
        i += 1
    
    res= []
    for i in range(K):
        if dic[i]:
            l = len(dic[i])
            if l > 1:
                tmp = sorted(dic[i], key=lambda x : x[1])
                for j in range(l-1):
                    res.append(tmp[j][1])
    
    res.sort()

    print("#{} {}".format(T, sum(res[:len(res)-N+K])))
            
            
