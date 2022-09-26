import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

for i in range(N-1, 0, -1):
    if nums[i] < nums[i-1]:
        a, b = i-1, i

        for j in range(N-1, 0, -1):
            if nums[j] < nums[a]:
                nums[j], nums[a] = nums[a], nums[j]
                nums = nums[:i] + sorted(nums[i:], reverse=True)
                print(*nums)
                exit()

print(-1)