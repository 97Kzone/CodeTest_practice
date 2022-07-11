import sys
from collections import deque
input = sys.stdin.readline

def cal(i, num):
    if i == 0:
        return (num * 2)%10000
    elif i == 1:
        return num-1 if num != 0 else 9999
    elif i == 2:
        return 10*(num%1000) + num//1000
    elif i == 3:
        return 1000*(num%10) + num//10        

def check(a, b):
    q = deque()
    q.append([a, ""])
    board[a] = 1

    while q:
        num, res = q.popleft()

        if num == b:
            print(res)
            break
        
        for i in range(4):
            temp = cal(i, num)

            if board[temp] == 0:
                q.append([temp, res + move[i]])
                board[temp] = 1

for _ in range(int(input())):
    A, B = map(int, input().split())
    board = [0] * 10000
    move = ["D", "S", "L", "R"]

    check(A, B)
