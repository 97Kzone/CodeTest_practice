N = list(input())

if N.count('0') == 0:
    print(-1)
else:
    N.sort(reverse=True)
    res = int(''.join(N))
    if res % 30 == 0:
        print(res)
    else:
        print(-1)

# 조건을 잘 확인 했다면 시간을 아낄 수 있던 문제
# 정답률 38%
# solved 2022-01-03


