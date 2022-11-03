from collections import defaultdict

for t in range(1, int(input())+1):
    N, M = map(int, input().split())
    dic = defaultdict(list)

    for _ in range(M):
        s, e = map(int, input().split())
        dic[s].append(e)
        dic[e].append(s)

    res = 0
    for i in range(N+1):
        for j in range(i+1, N+1):
            for k in range(j+1, N+1):
                if i in dic[j] and j in dic[k] and k in dic[i]:
                    res += 1

    print("#{} {}".format(t, res))
