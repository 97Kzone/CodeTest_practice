from collections import Counter as C
def solution(n, results):
    answer = 0
    #이기면 1점, 지면 -1점
    check = [[0] * (n+1) for _ in range(n+1)]

    for w, l in results:
        check[w][l] = 1
        check[l][w] = -1

    for i in range(1, n+1):
        for j in range(1, n+1):
            for k in range(1, n+1):
                if check[i][k] == 1 and check[k][j] == 1:
                    check[i][j] = 1
                    check[j][i] = -1

                if check[i][k] == -1 and check[k][j] == -1:
                    check[i][j] = -1
                    check[j][i] = 1

    for r in check:
        if len(r) - C(r)[0] == n-1:
            answer += 1

    return answer