import sys
input = sys.stdin.readline

def check():
    return
for _ in range(int(input())):
    board = []
    for _ in range(3):
        r = list(input().split())
        tmp = []
        for v in r:
            if v == "H":
                tmp.append(1)
            else:
                tmp.append(0)
        board.append(tmp)
    print(board)