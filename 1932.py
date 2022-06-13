import sys

N = int(input())
nums = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

for i in range(1, N):
    for j in range(len(nums[i])):
        if j == 0:
            nums[i][0] += nums[i-1][0]
        elif j < len(nums[i])-1:
            nums[i][j] += max(nums[i-1][j], nums[i-1][j-1])
        else:
            nums[i][j] += nums[i-1][-1]

print(max(nums[-1]))

# 동적할당 연습, 경계값 쓸 일을 없애거나 잘 생각하자
# 실버 1, 정답률 58프로, solved 22-02-04
