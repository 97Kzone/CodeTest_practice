import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

res = [0, 0]
s, i, j = 10e9, 0, N-1
while i < j:
    v = nums[i] + nums[j]

    if abs(v) < s:
        s = abs(v)
        res = [nums[i], nums[j]]
    
    if v < 0:
        i += 1
    else:
        j -= 1

print(*res)

