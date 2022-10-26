from collections import Counter 

for t in range(1, int(input())+1):
    s = list(input().rstrip())
    cnt = Counter(s)
    
    res = "Yes" if len(cnt) == 2 else "No"
    
    print("#{} {}".format(t, res))   