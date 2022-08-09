N, K = map(int, input().split())
board = list(map(int, input().split()))

i, j = 0, 0
cnt = 1 if board[0] == 1 else 0
res = 10e9

while j < N and i <= j:
    if cnt < K:
        j += 1
        if j < N and board[j] == 1:
            cnt += 1
    else:
        if cnt == K:
            res = min(res, j-i+1)
        
        if i < N and board[i] == 1:
            cnt -= 1
        i +=1 

print(res if res != 10e9 else -1)