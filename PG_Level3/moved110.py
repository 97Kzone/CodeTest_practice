#sol. 0을 최대한 앞으로 당겨오자
def solution(s):
    answer = []
    
    #모든 케이스에 대해서
    for t in s:
        std, cnt = [], 0
        for c in t:
            if c == "1":
                std.append(c)
            else:
                if std[-2:] == ["1", "1"]:
                    std.pop()
                    std.pop()
                    cnt += 1
                else:
                    std.append(c)
        
        v = "110" * cnt
        std = "".join(std)
        if "0" in std:
            idx = std.rfind("0")          
            answer.append(std[:idx+1] + v + std[idx+1:])
        else:
            answer.append(v + std)


            
            
    return answer