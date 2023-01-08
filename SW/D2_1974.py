def check(arr):
    for r in arr:
        if sum(r) != 45:
            return False
        
    return True

def check2(arr):
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            tmp = sum(arr[i][j:j+3]) + sum(arr[i+1][j:j+3]) + sum(arr[i+2][j:j+3])

            if tmp != 45:
                return False
    return True
for t in range(1, int(input())+1):
    board = [list(map(int, input().split())) for _ in range(9)]

    f1 = check(board) #가로검사
    f2 = check(list(zip(*board))) #세로검사
    f3 = check2(board) #구간검사
    
    if f1 and f2 and f3:
        res = 1
    else:
        res = 0
    
    print("#{} {}".format(t, res))
