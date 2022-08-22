import sys
input = sys.stdin.readline

N = int(input())
ps = list(map(int, input().split()))

now, res = [2], 2
for i in range(1, N):
    if ps[i] != ps[i-1]:
        if res + 2 < 100:
            res += 2
            now.append(2)
        else:
            res = 0
            now.append(0)
    else:
        if now[-1] == 0:
            res = 2
            now.append(2)
            continue
            
        if res + (now[-1] * 2) < 100:
            res += now[-1] * 2
            now.append(now[-1]*2)
        else:
            res = 0
            now.append(0)

print(res)

# 통과