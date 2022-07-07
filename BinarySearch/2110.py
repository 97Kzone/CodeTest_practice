import sys
input = sys.stdin.readline

N, C = map(int, input().split())
homes = [int(input()) for _ in range(N)]
homes.sort()

s, e = 1, homes[-1] - homes[0]
res = []
while s <= e:
    m = (s + e) // 2
    cnt = 1

    idx = homes[0]

    for x in homes:
        if idx + m <= x:
            print(x)
            cnt += 1
            idx = x
            
    if cnt >= C:
        s = m + 1
        res.append(m)
    else:
        e = m - 1

print(max(res))

