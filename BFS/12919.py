import sys
from collections import deque
input = sys.stdin.readline

s1 = input().rstrip()
s2 = input().rstrip()

def check():
    q = deque()
    q.append(s2)

    while q:
        s = q.popleft()
        
        if s == s1:
            return 1
        
        if len(s) == 1:
            continue
         
        if s[-1] == "A" and s[:-1] not in q:
            q.append(s[:-1])
        
        if s[0] == "B" and s[:0:-1] not in q:
            q.append(s[:0:-1])
    
    return 0

res = check()
print(res)



