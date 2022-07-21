N, K = map(int, input().split())
bulb = [0] + list(map(int, input().split()))
xbulb = [0] * (N+K)

for i in range(1, N+1):
    xbulb[i] = bulb[i] ^ bulb[i-1]

res = 0
for i in range(1, N-K+3):
    if xbulb[i]:
        xbulb[i] ^= 1
        xbulb[i+K] ^= 1
        res += 1

for i in range(N-K+2, N+1):
    if xbulb[i]:
        print("Insomnia")
        exit()

print(res)