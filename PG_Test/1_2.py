from collections import Counter as C

def solution(want, number, discount):
    answer = 0
    
    for i in range(10, len(discount)+1):
        tmp = C(discount[i-10:i])
        for i in range(len(want)):
            if want[i] not in tmp:
                break
            
            if number[i] > tmp[want[i]]:
                break
        else:
            answer += 1

    return answer