# 다른사람 풀이를 참고
def solution(alp, cop, problems):
    ma, mc = 0, 0

    for p in problems:
        ma = max(ma, p[0])
        mc = max(mc, p[1])

    a, c = min(alp, ma), min(cop, mc)
    dp = [[10**9] * (mc+1) for _ in range(ma+1)]
    dp[a][c] = 0

    #이미 모든 문제를 풀 수 있다면 for문은 돌지 않는다
    for i in range(a, ma+1):
        for j in range(c, mc+1):
            #알고력, 코딩력이 1 모자라면?
            if i+1 <= ma:
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+1)

            if j+1 <= mc:
                dp[i][j+1] = min(dp[i][j+1], dp[i][j]+1)

            #주어진 문제에 대해서
            for aq, rq, ar, cr, cs in problems:
                #자격을 만족하면 최소값 비교
                if i >= aq and j >= rq:
                    na = min(ma, i + ar)
                    nc = min(mc, j + cr)
                    dp[na][nc] = min(dp[na][nc], dp[i][j] + cs)

    return dp[-1][-1]