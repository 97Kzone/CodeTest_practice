N, K = map(int, input().split())


def makeAB(A, B):
    res = list("A"*(A-1) + "B"*B)
    idx = (N-1) - (K-((A-1)*B))
    res.insert(idx, "A")
    return "".join(res)

if K == 0:
    print("A"*N)
else:
    for i in range(1, N):
        A, B = i, N-i

        if A * B >= K:
            print(makeAB(A, B))
            break
            
    else:
        print(-1)

# 굉장히 짧지만 시간을 많이 쓴 문제, 문자열을 만드는 방법을 생각하는 것이 가장 오래 걸렸다.
# 파이썬의 유연함이 아니라면 코드가 훨씬 길어졌을 것 같다.
# 골드4, 정답률 43프로, solved 2022-01-17
