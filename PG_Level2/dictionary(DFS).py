def solution(word):
    items = ["A", "E", "I", "O", "U"]
    global cnt
    res, cnt = [], 0
    
    def check(s):
        global cnt 
        
        if len(s) == 5:
            return
        
        for c in items:
            cnt += 1
            t = s + c
            
            if t == word:
                res.append(cnt)
                break
            
            check(t)
                
    
    check("")
    return res[0]
    