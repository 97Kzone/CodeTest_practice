import sys
input = sys.stdin.readline

N = int(input())
nums = [list(map(int, input().split())) for _ in range(N)]

res = 0
def check(d):
    global res

    if d == N:
        cnt = 0
        for num in nums:
            if num[0] <= 0:
                cnt += 1
        res = max(res, cnt)
        return
    
    if nums[d][0] <= 0:
        check(d+1)
    else:
        flag = False
        for i in range(N):
            if i != d and nums[i][0] >= 0:
                nums[i][0] -= nums[d][1]
                nums[d][0] -= nums[i][1]
                check(d+1)
                nums[i][0] += nums[d][1]
                nums[d][0] += nums[i][1]
        
        if not flag:
            check(N)

check(0)
print(res)