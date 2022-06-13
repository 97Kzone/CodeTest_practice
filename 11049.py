import sys
input = sys.stdin.readline

N = int(input())
mat = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * N for _ in range(N)]

