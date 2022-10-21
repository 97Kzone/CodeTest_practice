import math 

def solution(begin, end):
    answer = []
    
    for i in range(begin, end+1):
        if i == 1:
            answer.append(0)
        else:
            tmp = int(math.sqrt(i))
            
            for j in range(2, tmp+1):
                d, m = divmod(i, j)
                
                if d > 10 ** 7:
                    continue
                
                if m == 0:
                    answer.append(d)
                    break
            else:
                answer.append(1)
                
    return answer