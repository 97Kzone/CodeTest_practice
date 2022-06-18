import sys
input = sys.stdin.readline

N = int(input())

nums = list(map(int, input().split()))
M = nums.copy()
m = nums.copy()

for _ in range(N-1):
    n1, n2, n3 = map(int, input().split())

    M = [n1 + max(M[:2]), n2 + max(M), n3 + max(M[1:])]
    m = [n1 + min(m[:2]), n2 + min(m), n3 + min(m[1:])]

print(max(M), min(m)) 

