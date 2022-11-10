from collections import defaultdict

def DFS(num, cnt):
    std = "".join(num)

    if std in check[cnt]:
        return
    else:
        check[cnt].append(std)

    if cnt == 0:
        return 

    for i in range(len(num)):
        for j in range(i+1, len(num)):
            num[i], num[j] = num[j], num[i]
            DFS(num, cnt-1)
            num[i], num[j] = num[j], num[i]
    
for t in range(1, int(input())+1):
    num, cnt = map(int, input().split())
    num = list(str(num))
    
    if len(num) == 1:
        print("#{} {}".format(t, "".join(num)))
    else:
        check = defaultdict(list)
        DFS(num, cnt)

        print("#{} {}".format(t, max(check[0])))