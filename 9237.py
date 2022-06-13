N = int(input())
trees = list(map(int, input().split()))

trees.sort(reverse=True)

for i in range(N):
    trees[i] = trees[i] + (i+1)

print(max(trees)+1)
# 몸풀기 문제
# solved 2022-01-03