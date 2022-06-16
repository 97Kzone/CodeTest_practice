T = int(input())

nums = [0, 0, 1, 7, 4, 2, 6, 8, 10, 18, 22, 20]
case = [int(input()) for _ in range(T)]

def getmax(num):
    res = [1 for i in range(num//2)]
    if num%2 == 1:
        res[0] = 7
    return res

def getmin(num):
    res = [8 for i in range((num+6)//7)]
    if num%7 == 1:
        res[0], res[1] = 1, 0
    if num%7 == 2:
        res[0] = 1
    if num%7 == 3:
        res[0], res[1], res[2] = 2, 0, 0
    if num%7 == 4:
        res[0], res[1] = 2, 0
    if num%7 == 5:
        res[0] = 2
    if num%7 == 6:
        res[0] = 6
    return res

for num in case:
    if num < 11:
        print(nums[num], end = " ")
    else:
        print(*getmin(num), sep="", end=" ")    
    print(*getmax(num), sep="")

# 굉장히 까다로웠던 문제, 케이스를 하나하나 적어보며 귀납적으로 접근해야 했다.
# 정답률 38프로, solved 2022-01-15