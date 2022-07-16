import sys
input = sys.stdin.readline
print = sys.stdout.write

S = input().strip()
pre = [[0] * 26 for _ in range(len(S))]
pre[0][ord(S[0])-97] = 1

for i in range(1, len(S)):
    pre[i][ord(S[i]) - 97] = 1
    for j in range(26):
        pre[i][j] += pre[i-1][j]

for _ in range(int(input())):
    k, s, e = input().split()
    s, e = int(s), int(e)

    v1 = pre[s-1][ord(k)-97] if s > 0 else 0
    v2 = pre[e][ord(k)-97]

    print(f'{v2-v1}\n')
