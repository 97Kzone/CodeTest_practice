N = int(input())

board = [0] * N
res = 0

def check(cnt):
    global res

    if cnt == N:
        res += 1
        return

    for i in range(N):
        flag = 1
        for j in range(cnt):
            if board[j] == i or abs(cnt-j) == abs(i-board[j]):
                flag = 0
                break
        
        if flag:
            board[cnt] = i
            check(cnt+1)

check(0)
print(res)