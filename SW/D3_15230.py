for t in range(1, int(input()) + 1):
    s = input().rstrip()
    res = 0
    if s[0] != "a":
        print("#{} {}".format(t, res))
        continue    
    
    for i in range(1, len(s)):
        if ord(s[i]) - ord(s[i-1]) == 1:
            res += 1
        else:
            break
   	
    print("#{} {}".format(t, res+1))