import sys
input = sys.stdin.readline

def check(n):
    l, r = 0, N-1
    while l < r:
        m = (l+r)//2

        if std[m] < n:
            l = m+1
        else:
            r = m

    return l

N = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
std = [i-j for i, j in zip(a, b)]

Q = int(input())
nums = list(map(int, input().split()))

print(std)
for num in nums:
    res = check(num)
    print(res)
