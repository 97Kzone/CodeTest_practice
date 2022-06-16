r, c, k = map(int, input().split())
nums = [list(map(int, input().split())) for _ in range(3)]
row, col = 3, 3

def RC(nums):
    global row, col
    std = []
    L = 0
    for r in nums:
        temp = []
        check = [0] * 101
        for val in r:
            if val != 0:
                check[val] += 1
        check = list(enumerate(check))
        check.sort(key = lambda x : x[1])
        
        for val in check:
            if val[1] != 0:
                temp.append(val[0])
                temp.append(val[1])

        L = max(L, len(temp))
        std.append(temp)
    
    if L < 3:
        L = 3
    elif L > 100:
        L = 100
    
    row = len(std)
    col = L

    for i in range(row):
        std[i] += [0] * (col-len(std[i]))

    return std

res = 0
while True:
    if nums[r-1][c-1] == k:
        break

    if row >= col:
        nums = RC(nums)
    else:
        nums = list(zip(*nums))
        nums = RC(nums)
        nums = list(zip(*nums))

    print(nums)
    res += 1

print(res)