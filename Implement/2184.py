nums = [0, 1, 2]

N = int(input())
n = 1
for i in range(3, N+1):
    if i == (2*n):
        nums.append(2*n)
        n = 1
        continue
    else:
        nums.append(2*n)
    n += 1

print(nums[N])
