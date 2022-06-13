K = int(input())

arr = input().split()

def BFS(arr, idx, check, temp, res):
    if len(arr) == idx:
        res.append(temp)
        return
    for i in range(10):
        if check[i] == False:
            if len(temp) == 0:
                check[i] = True
                BFS(arr, idx+1, check, temp+str(i), res)
                check[i] = False
            elif arr[idx] == ">" and int(temp[-1]) > i:
                check[i] = True
                BFS(arr, idx+1, check, temp+str(i), res)
                check[i] = False
            elif arr[idx] == "<" and int(temp[-1]) < i:
                check[i] = True
                BFS(arr, idx+1, check, temp+str(i), res)
                check[i] = False

res = []
check = [False for _ in range(10)]
answer = BFS(arr, -1, check, "", res)
res.sort()
print(res[-1])
print(res[0])