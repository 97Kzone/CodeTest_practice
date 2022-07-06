import sys
input = sys.stdin.readline

def check(l, r, t):
    while l < r:
        m = (l + r) // 2
        if lis[m] < t:
            l = m + 1
        else:
            r = m
    return r

N = int(input())
nums = list(map(int, input().split()))

lis = [0] * N
lis[0] = nums[0]

i, j  = 1, 0
while i < N:
    if lis[j] < nums[i]:
        lis[j+1] = nums[i]
        j += 1
    else:
        lis[check(0, j, nums[i])] = nums[i]

    i += 1

print(j+1)


