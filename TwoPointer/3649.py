import sys
input = sys.stdin.readline

while True:
    try:
        target = int(input()) * (10 ** 7)
        N = int(input())
        b = [int(input()) for _ in range(N)]
        b.sort()

        i, j = 0, N-1
        while j < N and i < j:
            if b[i] + b[j] == target:
                print("yes " + str(b[i]) + " " + str(b[j]))
                break

            elif b[i] + b[j] < target:
                i += 1
            else:
                j -= 1

        else:
            print("danger")
            
    except:
        exit()