# 라이브러리 쓰기
# from itertools import combinations as cb

# for t in range(1, int(input())+1):
#     N, K = map(int, input().split())
#     nums = list(map(int, input().split()))

#     res = 0
#     for i in range(1, N+1):
#         for case in cb(nums, i):
#             if sum(case) == K:
#                 res += 1
    
#     print("#{} {}".format(t, res))

# DFS로 풀기
def DFS(idx, val):
    global res
    if idx == N:
        return

    tmp = val + nums[idx]
    if tmp == K:
        res += 1

    DFS(idx+1, val)
    DFS(idx+1, tmp)
    
for t in range(1, int(input())+1):
    N, K = map(int, input().split())
    nums = list(map(int, input().split()))
    res = 0
    DFS(0, 0)

    print("#{} {}".format(t, res))