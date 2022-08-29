N, K, P, X = map(int, input().split())

nums = [[1, 1, 1, 0, 1, 1, 1], [0, 0, 1, 0, 0, 1, 0],
        [1, 0, 1, 1, 1, 0, 1], [1, 0, 1, 1, 0, 1, 1],
        [0, 1, 1, 1, 0, 1, 0], [1, 1, 0, 1, 0, 1 ,1],
        [1, 1, 0, 1, 1, 1, 1], [1, 0, 1, 0, 0, 1, 0],
        [1, 1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 0, 1, 1]]

def check(num):
    cnt = 0
    for i in range(N+1):
        if i == X:
            continue

        if check2(i, num):
            cnt += 1

    return cnt

def check2(i, num):
    t = list(map(int, str(i)))
    t = [0] * (K - len(t)) + t
    c = 0
    for i in range(K):
        for j in range(7):
            if nums[num[i]][j] != nums[t[i]][j]:
                c += 1
                if c > P:
                    return 0
    return 1

now = list(map(int, str(X)))
now = [0] * (K - len(now)) + now # 자리수 맞춰주기
res = check(now)

print(res)

