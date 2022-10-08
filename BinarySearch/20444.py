N, K = map(int, input().split())
i, j = 0, N // 2

while i <= j:
    m = (i+j) // 2
    v = (m+1) * (N-m+1)

    if v == K:
        print("YES")
        exit()

    if v > K:
        j = m-1
    elif v < K:
        i = m+1

print("NO")