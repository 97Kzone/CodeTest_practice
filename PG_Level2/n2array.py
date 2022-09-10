def solution(n, left, right):
    answer = []
    
    for i in range(left, right+1):
        j = (i // n) - (i % n)
        j = 0 if j < 0 else j
        
        tmp = i%n+1+j
        answer.append(tmp)
    
    return answer