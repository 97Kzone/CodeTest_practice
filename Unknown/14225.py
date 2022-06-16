from itertools import combinations as cb

N = int(input())
nums = list(map(int, input().split()))
check = [0] * 2000001
check[0] = -1

for i in range(1, N+1):
    temp = list(cb(nums, i))

    for val in temp:
        check[sum(val)] = 1

print(check.index(0))

