from itertools import combinations as cb

N, M = map(int, input().split())

nums = [str(i) for i in range(1, N+1)]

datas = list(cb(nums, M))

for data in datas:
    print(" ".join(data))

# 브루트포스 연습
# 실버 3, solved 22-02-07