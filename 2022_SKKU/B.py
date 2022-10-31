nums = [float(input()) for _ in range(10)]
nums.sort()

res = 1
for i in range(1, 10):
    v = nums[i] / i
    res *= v

res = round(res * (10**9), 6)
print(int(res) if res % 1 == 0 else res)