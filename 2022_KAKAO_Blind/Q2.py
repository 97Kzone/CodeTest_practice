from collections import deque

def solution(queue1, queue2):
    res = 0
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    s1, s2 = sum(q1), sum(q2)
    s = (s1 + s2) // 2
    
    #하나의 큐가 s값을 만들수 있다면 다른 큐도 자동으로 가능
    while q1 and q2:
        if s1 == s:
            return res
        elif s1 > s:
            s1 -= q1.popleft()
        else:
            q1.append(q2.popleft())
            s1 += q1[-1]
        
        res += 1
            
    return -1