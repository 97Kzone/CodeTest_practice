import sys
input = sys.stdin.readline

N = int(input())
words = list(input().rstrip("\n") for _ in range(N))

res = ""
l, r = 0, N-1
while l <= r:
    if words[l] > words[r]:
        res += words[r]
        r -= 1
    elif words[l] < words[r]:
        res += words[l]
        l += 1
    else:
        tl, tr = l+1, r-1
        while tl <= tr:
            if words[tl] < words[tr]:
                res += words[l]
                l += 1
                break
            elif words[tl] > words[tr]:
                res += words[r]
                r -= 1
                break
            else:
                tl += 1
                tr -= 1
        else:
            res += words[l]
            l += 1            

idx = 0
for s in res:
    print(s, end="")
    idx += 1
    if idx % 80 == 0:
        print()
