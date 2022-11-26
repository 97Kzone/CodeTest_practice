N = input().rstrip()

i = 0
m, M = "", ""

for c in N:
    if c == "M":
        i += 1
    else:
        M += str((10**i)*5) if i else "5"
        m += str((10**i)+5) if i else "5"
    
        i = 0

if i:
    M += '1' * i
    m += str(10**(i-1))

print(M)
print(m)