N = int(input())

cycle = 15 * (10 ** 5) # 피사노 주기
nums = [0] * (cycle+1)
nums[0], nums[1], nums[2] = 0, 1, 1

for i in range(3, cycle+1):
    nums[i] = (nums[i-1] + nums[i-2]) % 1000000

print(nums[N%cycle])

