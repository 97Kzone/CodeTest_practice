for t in range(1, int(input()) + 1):
    s = ["."] + list(input().rstrip()) + ["."]
    res = 0
    
    for i in range(1, len(s)-1):
        if s[i] == ")":
            if s[i-1] == "(" or s[i-1] == "|":
                res += 1
        elif s[i] == "|":
            if s[i-1] == "(":
                res += 1
                
    print("#{} {}".format(t, res))