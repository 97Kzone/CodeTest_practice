N = int(input())
nums = list(map(int, input().split()))

res = 0
def check(std, val):
    global res
    res = max(res, val)

    if len(std) == 2:
        return
    
    for i in range(1, len(std)-1):
        temp = std[:]
        v = temp[i-1] * temp[i+1]
        del temp[i]
        
        check(temp, val + v)

check(nums, 0)
print(res)