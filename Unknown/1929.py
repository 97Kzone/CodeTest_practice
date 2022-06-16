M, N = map(int, input().split())

def check(n):
    flag = [True] * (n+1)
    m = int(n ** 0.5)
    for i in range(2, m+1):
        if flag[i] == True:
            for j in range(i+i, (n+1) , i):
                flag[j] = False
    
    return [i for i in range(2, (n+1)) if flag[i] == True]

res = check(N)

for val in res:
    if val >= M:
        print(val)

# 그냥 소수 구하는 문제
# 실버 3? 정답률 3X프로, solved 2022-01-21