import sys
N = int(input())
ranks = [int(sys.stdin.readline()) for _ in range(N)]

res = 0
ranks.sort(reverse=True)
for i in range(1, N+1):
    res += abs(i - ranks.pop())

print(res)

# input 값이 클 경우 : input() 으로 입력 받을 시 시간초과가 발생한다.
# 다른 문제를 풀 때 입력값의 크기를 먼저 확인하고 어떻게 입력값을 받을지 처리해야겠다...
# 정답률 37%, solved 2022-01-10