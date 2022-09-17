from collections import Counter as C

def solution(numbers):
    answer = []
    for num in numbers:
        if num <= 1:
            answer.append(num+1)
            continue
        
        s = format(num, 'b')
        c = C(s)
        #1.첫 비트 제외 나머지 0이라면?
        if c['0'] == len(s) - 1:
            s = s[:-1] + '1'
        #2.첫 비트 포함 나머지 1이라면?
        elif c['1'] == len(s):
            s = '10' + s[1:]
        #3.첫 비트 제외 나머지 1, 0 섞였다면?
        else:
            #그 중 마지막 비트가 0이라면?
            if s[-1] == "0":
                s = s[:-1] + "1"
            else:
                s = s[::-1].replace("10", "01", 1)
                s = s[::-1]
        
        answer.append(int(s, 2))
        
    return answer