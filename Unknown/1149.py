import sys

T = int(input())
RGB = [list(map(int, sys.stdin.readline().split())) for _ in range(T)]

for i in range(1, T):
    RGB[i][0] += min(RGB[i-1][1], RGB[i-1][2])
    RGB[i][1] += min(RGB[i-1][0], RGB[i-1][2])
    RGB[i][2] += min(RGB[i-1][0], RGB[i-1][1])

print(min(RGB[-1]))

# 동적 계획법 연습
# 실버1, 정답률 49프로, solved 22-02-04