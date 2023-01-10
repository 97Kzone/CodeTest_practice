import sys
input = sys.stdin.readline

def check(arr1, arr2):
    global res
    la, lb = len(arr1), len(arr2)
    
    for i in range(lb-la+1):
        v = 0
        tmp = arr2[i:i+lb]
        for a, b in zip(arr1, tmp):
            v += a*b
        res = max(res, v)
    

for t in range(1, int(input())+1):
    N, M = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    res = 0
    if N < M:
        check(a, b)
    else:
        check(b, a)

    print("#{} {}".format(t, res))
