N = int(input())

res = 1

def check(num):
    temp = [int(i) for i in str(num)]
    return sum(temp)

while res < 1000001:
    val = res + check(res)
    if val == N:
        break
    res += 1
else:
    res = 0

print(res)

# 브루트 포스 연습, 시간초과 아슬