import sys
input = sys.stdin.readline

N = int(input())
comm = list(input().rstrip())
s = [] # 연계 체크

res = 0
for c in comm: 
    if c == "L":
        s.append("L")
    elif c == "S":
        s.append("S")
    elif c == "R":
        if s[-1] == "L":
            res += 1
            s.pop()
        else:
            break

    elif c == "K":
        if s[-1] == "S":
            res += 1
            s.pop()
        else:
            break
    else:
        res += 1

print(res)

# 실패
