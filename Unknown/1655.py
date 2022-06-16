import heapq as hq
import sys
input = sys.stdin.readline

N = int(input())
Mq, mq = [], []

for i in range(N):
    num = int(input())

    if len(Mq) == len(mq):
        hq.heappush(Mq, -num)
    else:
        hq.heappush(mq, num)

    if len(Mq) >= 1 and len(mq) >= 1 and Mq[0] * -1 > mq[0]:
        tmp1 = hq.heappop(Mq) * -1
        tmp2 = hq.heappop(mq)

        hq.heappush(Mq, tmp2 * -1)
        hq.heappush(mq, tmp1)

    print(Mq[0] * -1)