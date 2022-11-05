import math
for t in range(1, int(input())+1):
    n, d = map(int, input().split())

    res = math.ceil(n / ((d*2)+1))
    print("#{} {}".format(t, res))