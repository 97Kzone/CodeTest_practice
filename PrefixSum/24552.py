S = list(input())

l, r, s = 0, 0, 0

for i in range(len(S)):
    if S[i] == "(":
        l += 1
        s += 1
    else:
        r += 1
        s -= 1
    
    if s < 0:
        print(r)
        exit()
    elif s == 0:
        l = 0

print(l)