from collections import defaultdict

def check(n):
    std = []
    for i in range(1, int(n ** 0.5)+1):
        if n % i == 0:
            std.append(i)
            if (i ** 2) != n:
                std.append(n//i)
    
    cnt[n] = std

S, T = map(int, input().split())
cnt = defaultdict(list)

for i in range(S, T+1):
    check(i)

res = 0
print(cnt)
