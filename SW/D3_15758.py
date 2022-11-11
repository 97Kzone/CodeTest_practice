import math

for t in range(1, int(input())+1):
    a, b = input().split()
    la, lb = len(a), len(b)
    
    v = la * lb // math.gcd(la, lb)
    a = a * (v // la)
    b = b * (v // lb)

    res = "yes" if a == b else "no"
    print("#{} {}".format(t, res))
