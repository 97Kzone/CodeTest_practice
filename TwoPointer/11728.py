import sys
input = sys.stdin.readline

#sol 1 투포인터
N, M = map(int, input().split())
num1 = list(map(int, input().split()))
num2 = list(map(int, input().split()))

i, j = 0, 0
res = []
while True:
    if num1[i] > num2[j]:
        res.append(num2[j])
        j += 1
    else:
        res.append(num1[i])
        i += 1

    if i == N:
        for num in num2[j:]:
            res.append(num)
        break
    elif j == M:
        for num in num1[i:]:
            res.append(num)
        break

print(" ".join(str(num) for num in res))