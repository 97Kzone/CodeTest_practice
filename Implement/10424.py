import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

res = [0] * N
for i, num in enumerate(nums):
    res[num-1] = num-i-1

print(*res)