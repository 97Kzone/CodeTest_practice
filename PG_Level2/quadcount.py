def check(res, arr, n):
    global answer
    x, y = res
    std = arr[x][y]

    for i in range(n):
        for j in range(n):
            if std != arr[x+i][y+j]:
                check([x, y], arr, n//2)
                check([x, y+n//2], arr, n//2)
                check([x+n//2, y], arr, n//2)
                check([x+n//2, y+n//2], arr, n//2)
                return

    answer[std] += 1

def solution(arr):
    global answer
    answer = [0, 0]

    n = len(arr)
    check(answer, arr, n)

    return answer