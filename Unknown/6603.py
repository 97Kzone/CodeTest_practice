from itertools import combinations as cb

nums = []
while True:
    num = list(map(int, input().split()))
    
    if num[0] == 0:
        break

    nums.append(num)

for num in nums:
    num = num[1:]
    num.sort()

    res = list(cb(num, 6))
    
    for val in res:
        for c in val:
            print(c, end = " ")
        print()

    print()
    