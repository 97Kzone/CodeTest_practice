from collections import deque

def solution(order):
    answer = 0
    
    order = deque(order)
    sub = []
    idx = 1

    for now in order:
        while idx <= now:
            sub.append(idx)
            idx += 1

        if sub[-1] == now:
            sub.pop()
            answer += 1
        else:
            break

    return answer

        
