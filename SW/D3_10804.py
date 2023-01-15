m = {"b":"d", "d":"b", "p":"q", "q":"p"}

for t in range(1, int(input())+1):
    word = input().rstrip()

    res = ""
    for c in word[::-1]:
        res += m[c]
    
    print("#{} {}".format(t, res))