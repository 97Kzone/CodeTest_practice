import sys
input = sys.stdin.readline

N = int(input())
snows = list(map(int, input().split()))
snows.sort()

res = 10**10
for i in range(N):
    for j in range(i+3, N):
        l, r = i+1, j-1
        while l < r:
            v = (snows[i]+snows[j]) - (snows[l]+snows[r])
            res = min(res, abs(v))

            if v < 0:
                r -= 1
            else:
                l += 1

print(res)