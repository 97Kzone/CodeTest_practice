import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

res, i, j = 0, 0, 0
check = [0] * 100001

while j < N and i <= j:
    if not check[nums[j]]:
        check[nums[j]] = 1
        j += 1
        res += j - i
    else:
        while check[nums[j]]:
            check[nums[i]] = 0
            i += 1

print(res)