import sys
input = sys.stdin.readline

S, E, Q = input().split()

S = int(S[:2] + S[3:])
E = int(E[:2] + E[3:])
Q = int(Q[:2] + Q[3:])

check = set()
res = 0
while True:
    try:
        t, name = input().split()
        t = int(t[:2] + t[3:])
        if t <= S:
            check.add(name)
        elif name in check and E <= t <= Q:
            check.remove(name)
            res += 1
    except:
        break

print(res)