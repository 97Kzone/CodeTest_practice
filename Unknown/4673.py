nums = [i for i in range(1, 10001)]

def dn(n):
    N = [int(i) for i in str(n)]
    return n + sum(N)

for i in range(1, 10001):
    temp = dn(i)
    if temp in nums:
        nums.remove(temp)

for num in nums:
    print(num)

# 그냥 푸는 문제
# 실버 5, 정답률 49프로, solved 2022-01-21 