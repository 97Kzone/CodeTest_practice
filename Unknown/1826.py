import sys, heapq as hq

N = int(input())
gas = []
for _ in range(N):
    hq.heappush(gas, list(map(int, sys.stdin.readline().split())))
L, P = map(int, input().split())

flag, cnt = [], 0
while P < L:
    while gas and gas[0][0] <= P:
        dis, fuel = hq.heappop(gas)
        hq.heappush(flag, [-1*fuel, dis])

    if not flag:
        cnt = -1
        break

    fuel, dis = hq.heappop(flag)
    P += -1 * fuel
    cnt += 1

print(cnt)

# 아이디어 접근이 쉽지 않았던 문제, 문제를 조금 더 다양한 관점으로 보는 연습이 필요하다.
# 정답률 28프로, solved 2022-01-10

