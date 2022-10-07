import sys, math, heapq as hq
input = sys.stdin.readline

N, H, T = map(int, input().split())
nums = []

for _ in range(N):
    hq.heappush(nums, -int(input()))

cnt = 0
while T > cnt and nums:
    v = -hq.heappop(nums)
    if v < H:
        continue
    
    tmp = 1 if math.floor(v/2) <= 1 else math.floor(v/2) 
        
    if tmp < H:
        cnt += 1
        continue
    else:
        hq.heappush(nums, -tmp)
    
    cnt += 1

if nums:
    print("NO")
    print(-hq.heappop(nums))
else:
    print("YES")
    print(cnt)