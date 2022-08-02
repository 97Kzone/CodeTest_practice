def solution(beginning, target):
    def change_r(idx):
        for i in range(c):
            beginning[i][idx] = abs(beginning[i][idx]-1) 

    def change_c(idx):
        for i in range(r):
            beginning[idx][i] = abs(beginning[idx][i]-1) 

    answer = 0
    c, r = len(beginning), len(beginning[0])

    # 첫 행을 먼저 맞춰보자
    for i in range(r):
        if beginning[0][i] != target[0][i]:
            change_r(i)
            answer += 1

    # 2번째부터 마지막 행까지 점검
    for i in range(1, c):
        for j in range(r):
            if beginning[i][j] != target[i][j]:
                change_c(i)
                answer += 1
                
    for i in range(c):
        for j in range(r):
            if beginning[i][j] != target[i][j]:
                return -1
    
    return answer