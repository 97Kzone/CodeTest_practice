import sys
input = sys.stdin.readline

N = int(input())

for _ in range(N):
    x, y = map(int, input().split())
    moves = list(map(int, input().split()))
    k, moves = moves[0], moves[1:]

    print(moves)