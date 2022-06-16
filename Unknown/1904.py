N = int(input())

nums = [0 for _ in range(1000001)]
nums[0], nums[1] = 1, 2

for i in range(2, 1000001):
    val = nums[i-2] + nums[i-1]
    if val >= 15746:
        nums[i] = val%15746
    else:
        nums[i] = val

print(nums[N-1])

# 제한시간이 굉장히 타이트한 문제
# 실버 2? 정답률 3X프로, solved 2022-02-04