import sys
input = sys.stdin.readline

for _ in range(int(input())):
    N, M, K = map(int, input().split())
    homes = list(map(int, input().split()))
    homes += homes[:M]
    
    s = sum(homes[:M])
    res = 1 if s < K else 0

    if N == M:
        print(res)
        continue

    i, j = 1, M
    while i < N:
        s -= homes[i-1]
        s += homes[j]

        if s < K:
            res += 1
        
        i += 1
        j += 1
    
    print(res)
