from collections import deque


def prime_set():
    check = [1] * 10000

    num = int(10000 ** 0.5)
    for i in range(2, num+1):
        if check[i]:
            for j in range(i+i, 10000, i):
                check[j] = 0
    
    return [i for i in range(1000, 10000) if check[i]]

prime = prime_set()

def dfs(start, target):
    q = deque()
    q.append([start, 0])
    check = [0] * 10000
    check[start] = 1

    while q:
        num, cnt = q.popleft()

        if num == target:
            return cnt
        
        num = str(num)

        for i in range(4):
            for j in range(10):
                temp = int(num[:i] + str(j) + num[i+1:])

                if not check[temp] and (temp in prime) and temp >= 1000:
                    check[temp] = 1
                    q.append([temp, cnt+1])

    return -1

N = int(input())
res = []
for _ in range(N):
    num1, num2 = map(int, input().split())

    res.append(dfs(num1, num2))
    
for val in res:
    if val == -1:
        print("Impossible")
    else:
        print(val)