import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()

#2개 이하면 답은 0
if N <= 2:
    print(0)
    exit()

res = 0
for idx in range(N):
    i, j = 0, N-2
    t = nums[:idx] + nums[idx+1:]
    while i < j:
        s = t[i] + t[j]
        if s == nums[idx]:
            res += 1
            break

        if s < nums[idx]:
            i += 1
        elif s > nums[idx]:
            j -= 1

print(res)