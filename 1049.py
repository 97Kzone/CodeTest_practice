N, M = map(int, input().split())
prices = [list(map(int, input().split())) for _ in range(M)]

s6, s1 = 1001, 1001

for price in prices:
    if price[0] < s6:
        s6 = price[0]
    
    if price[1] < s1:
        s1 = price[1]

res = 0
while N > 0:
    if s6 > s1*6:
        res = s1*N
        break

    if s6 < s1*N:
        res += s6
    else:
        res += s1*N
        break
    N -= 6

print(res)

# 생각보다 애먹은 문제, 간단한 조건과 출력이지만 케이스 구분을 확실히 짓지 못한게 실수
# 정답률 33프로, solved 2022-01-09