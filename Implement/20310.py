from collections import Counter as C

S = input()
c = C(S)

S = S.replace("1", "", c["1"]//2)
S = S[::-1].replace("0", "", c["0"]//2)
print(S[::-1])