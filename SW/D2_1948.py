std = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for t in range(1, int(input())+1):
    m1, d1, m2, d2 = map(int, input().split())

    res = 0
    while True:
        if m1 < m2:
            res += std[m1]
            m1 += 1
            continue

        if m1 == m2:
            res += d2
            break
    
    print("#{} {}".format(t, res-d1+1))

