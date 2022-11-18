def DFS(i, s, c):
    global res 
    if c > L:
        return

    res = max(res, s)

    if i == N:
        return

    DFS(i+1, s, c)
    DFS(i+1, s + score[i][0], c + score[i][1])
    
for t in range(1, int(input())+1):
    N, L = map(int, input().split())
    score = [list(map(int, input().split())) for _ in range(N)]
    visit = [0] * N
    res = 0

    DFS(0, 0, 0)    
    print("#{} {}".format(t, res))