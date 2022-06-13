T = int(input())

nums = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9]

#nums 배열 완성
for i in range(10, 101):
    nums.append(nums[i-3] + nums[i-2])

for _ in range(T):
    print(nums[int(input())-1])


# 동적 계획법 연습
# 실버3, 정답률 41프로, solved 22-02-04

    
