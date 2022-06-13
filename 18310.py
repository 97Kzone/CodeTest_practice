import sys

N = int(input())
homes = list(map(int, sys.stdin.readline().split()))

homes.sort()
if N % 2 == 0:
    print(homes[(N//2) -1])
else:
    print(homes[N//2])

# 백준 실버 3 레벨, 극단적 예시를 통한 수학적 접근이 빠른 풀이로 이어진다.
# 정답률 35프로, solved 2022-01-11