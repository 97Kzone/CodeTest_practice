import sys

N = int(input())

colors = list(sys.stdin.readline().rstrip('\n'))
cnt, std = 0, colors[0]

for i in range(1, N):
    if std != colors[i]:
        cnt += 1
        std = colors[i]

if N == 1:
    print(1)
else:
    div, mod = divmod(cnt, 2)
    print(div+mod+1)

# 쉬운 문제를 굉장히 돌고 돌아서 푼 문제, 간단한 원리를 눈치채기까지 너무 오랜 시간이 걸렸다
# 실버 4, 정답률 4X프로, solved 2022-01-18