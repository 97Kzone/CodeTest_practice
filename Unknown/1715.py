import heapq as hq

N = int(input())
cards = []
for _ in range(N):
    hq.heappush(cards, int(input()))

res = 0
while len(cards) > 1:
    a, b = hq.heappop(cards), hq.heappop(cards)
    res += a+b
    hq.heappush(cards, a+b)

print(res)

