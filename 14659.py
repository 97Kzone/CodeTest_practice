N = int(input())
temp = list(map(int, input().split()))

std, res, cnt = temp[0], 0, 0
for i in range(1, N):
    if std > temp[i]:
        cnt += 1
    else:
        std, cnt = temp[i], 0

    res = max(res, cnt)

print(res)

# 접근과 아이디어는 정확했지만 배열 마지막 부분의 상황 고려하지 않아 헤맨 문제
# res 를 if 문 밖으로 빼내기 까지 시간을 낭비했다.
# 정답률 42%, solved 2022-01-06