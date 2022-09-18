N = int(input())

turn, s = 1, 0
res = 0
while True:
    if s + turn > N:
        #내 차례
        if turn % 2 == 1:
            res = s + turn - N
        break

    s += turn
    turn += 1
print(res)