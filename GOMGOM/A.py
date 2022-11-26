N = int(input())

res = 0
for _ in range(N):
    s = input().rstrip()
    if int(s[2:]) <= 90:
        res += 1
print(res)