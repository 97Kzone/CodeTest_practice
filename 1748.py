N = int(input())
L = len(str(N))

res, std = 0, 9
for i in range(1, L):
    res += i*std
    std *= 10

temp = N - (10**(L-1)) + 1
res += temp*L
print(res)

# 쉬운 문제, 근데 어렵게 푼 느낌
# 실버 3 정답률 49프로, solved 22-02-06