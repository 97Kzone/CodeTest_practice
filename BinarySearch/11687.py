M = int(input())

l, r = 1, 500000000
flag = True
while l <= r:
    m = (l + r) // 2
    cnt = 0

    i = 5
    while i <= m:
        cnt += m // i
        i *= 5

    if M <= cnt:
        if M == cnt:
            flag = False
        r = m - 1
    else:
        l = m + 1

if flag:
    print(-1)
else:
    print(l)
