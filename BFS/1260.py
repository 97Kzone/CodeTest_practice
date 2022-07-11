import sys
from collections import deque, defaultdict
input = sys.stdin.readline

def DFS(v, check, res1):
    check[v] = 1
    res1.append(v)
    for i in range(1, N+1):
        if check[i] == 0 and i in dic[v]:
            DFS(i, check, res1)
            
    return res1

def BFS(v, check):
    q = deque()
    q.append(sorted(dic[v]))
    check[v] = 1

    res2 = [v]
    while q:
        nums = q.popleft()

        for num in nums:
            if check[num] == 0:
                check[num] = 1
                
                q.append(sorted(dic[num]))
                res2.append(num)

    return res2

N, M, V = map(int, input().split())
dic = defaultdict(list)
check1 = [0] * (N+1)
check2 = [0] * (N+1)
for _ in range(M):
    a, b = map(int, input().split())
    dic[a].append(b)
    dic[b].append(a)

print(" ".join(str(val) for val in DFS(V, check1, [])))
print(" ".join(str(val) for val in BFS(V, check2)))