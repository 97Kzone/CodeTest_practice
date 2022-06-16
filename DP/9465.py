import sys
input = sys.stdin.readline

for _ in range(int(input())):
    N = int(input())

    s1 = list(map(int, input().split()))
    s2 = list(map(int, input().split()))

    if N == 1:
        print(max(s1[-1], s2[-1]))
        continue

    s1[1] += s2[0]
    s2[1] += s1[0]

    for i in range(2, N):
        for j in range(2):
            if j == 0:
                s1[i] += max(s2[i-1], s2[i-2])
            else:
                s2[i] += max(s1[i-1], s1[i-2])

    print(max(s1[-1], s2[-1]))                    
        
    