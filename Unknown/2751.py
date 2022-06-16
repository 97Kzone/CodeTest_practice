import sys
N = int(input())
nums = [int(sys.stdin.readline()) for _ in range(N)]

nums.sort()

for num in nums:
    print(num)

# 점수 얻으려고 푼 문제
# 실버 5, 정답률 30프로, solved 2022-01-21