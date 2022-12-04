import sys
input = sys.stdin.readline
dic = {"063":"0", "010":"1", "093":"2", "079":"3", "106":"4",
     "103":"5", "119":"6", "011":"7", "127":"8", "107":"9"}

while True:
    s = input().rstrip()
    if s == "BYE":
        break
    
    a, b = s.split("+")
    anum, bnum = [], []

    for i in range(0, len(a)-2, 3):
        anum.append(a[i:i+3])
    
    for i in range(0, len(b)-2, 3):
        bnum.append(b[i:i+3])
    
    a, b = "", ""
    for v in anum:
        a += dic[v]
    
    for v in bnum:
        b += dic[v]
    tmp = eval(a+"+"+b)

    for t in str(tmp):
        for k, v in dic.items():
            if v == t:
                s += k
                break    
    print(s)