from collections import deque

def solution(rc, operations):
    answer = []

    #Rotate
    def R(s1, s2, s3):
        s2[0].appendleft(s1.popleft())
        s3.appendleft(s2[0].pop())
        s2[-1].append(s3.pop())
        s1.append(s2[-1].popleft())

    #ShiftRow
    def S(s1, s2, s3):
        s1.appendleft(s1.pop())
        s2.appendleft(s2.pop())
        s3.appendleft(s3.pop())


    #행렬 rc 를 세 덩어리로 나눠준다
    s1, s2, s3 = deque(), deque(), deque()

    for r in rc:
        s1.append(r[0])
        s2.append(deque(r[1:-1]))
        s3.append(r[-1])

    for t in operations:
        if t == "Rotate":
            R(s1, s2, s3)
        else:
            S(s1, s2, s3)

    for v in zip(s1, s2, s3):
        tmp = [v[0]]
        for n in v[1]:
            tmp.append(n)
        tmp.append(v[2])
        answer.append(tmp)

    return answer