from collections import Counter as C

def solution(a):
    answer = -1
    board = C(a)

    for k in board.keys():
        if board[k] <= answer:
            continue

        cnt = 0
        i = 0
        while i < len(a)-1:
            if a[i] == a[i+1]: #연속된 원소가 같으면 조건 위배
                i += 1
                continue

            if a[i] != k and a[i+1] != k: #둘 다 k값이 없으면 조건 위배
                i += 1
                continue

            cnt += 1
            i += 2

        answer = max(answer, cnt)

    return answer * 2 if answer != -1 else 0