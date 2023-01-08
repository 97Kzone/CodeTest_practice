def rotate(arr):
    tmp = []
    for r in zip(*arr):
        tmp.append(list(reversed(r)))

    return tmp

for t in range(1, int(input())+1):
    N = int(input())
    board = list(map(int, input().split()) for _ in range(N))
    board2 = rotate(board)
    board3 = rotate(board2)
    board4 = rotate(board3)

    print("#{}".format(t))
    
    for a, b, c in zip(board2, board3, board4):
        v1 = "".join(str(v) for v in a)
        v2 = "".join(str(v) for v in b)
        v3 = "".join(str(v) for v in c)

        print(v1, v2, v3)