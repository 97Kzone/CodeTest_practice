from collections import defaultdict
import sys
input = sys.stdin.readline

def check(i, cnt):
    visit[i] = 1

    for nx in dic[i]:
        if not visit[nx]:
            cnt = check(nx, cnt+1)   

    return cnt 
            
for _ in range(int(input())):
                
    N, M = map(int, input().split())
    dic = defaultdict(list)

    for _ in range(M):
        a, b = map(int, input().split())
        dic[a].append(b)
        dic[b].append(a)
    
    
    visit = [0] * (N+1)

    res = check(1, 0)
    print(res)
