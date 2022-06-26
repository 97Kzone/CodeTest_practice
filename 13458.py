import sys, math
input = sys.stdin.readline

N = int(input())
men = list(map(int, input().split()))
B, C = map(int, input().split())

res = 0
for man in men:
    if man > B:
        res += math.ceil((man - B) / C)

print(res + N)