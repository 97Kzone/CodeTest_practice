v = [1, 1]

for i in range(1, int(input())):
    v.append(v[-1]*2)
    if i-2 >= 1 and (i-2)%2 == 1: v[i+1] -= v[i-3]
    if i-3 >= 1 and (i-3)%2 == 0: v[i+1] -= v[i-4]

print(v[-1])