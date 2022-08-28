import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
stack = [(1, nums[0])]

res = [0]
for i in range(1, N):
    while stack:
        if stack[-1][1] > nums[i]:
            res.append(stack[-1][0])
            break
        else:
            stack.pop()
    
    if not stack:
        res.append(0)
    stack.append((i+1, nums[i]))

print(*res)