for t in range(1, int(input())+1):
    s1 = input().rstrip()
    s2 = input().rstrip()

    if s1 + 'a' == s2:
        res = "N"
    else:
        res = "Y"
    
    print("#{} {}".format(t, res))