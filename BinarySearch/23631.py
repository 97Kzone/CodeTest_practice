#다른분의 풀이를 참조하여 작성한 코드
import sys
input = sys.stdin.readline

def check():
    l, r = 0, 10**6
    while l < r:
        m = (l+r)//2

        if m*(m+1)*K >= 2*N:
            r = m
        else:
            l = m+1
        
    return l

for _ in range(int(input())):
    N, K = map(int, input().split())

    v = check()
    std = v*(v+1)//2

    if v%2 != 0:
        res = K*((v//2)+1)
        res += (N-1)-std*K
        print(str(res) + " R")
    else:
        res = -K*(v//2)
        res-=(N-1)-std*K
        print(str(res) + " L")