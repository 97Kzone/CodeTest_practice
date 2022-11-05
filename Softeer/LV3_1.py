N, B = map(int, input().split())
nums = list(map(int, input().split()))

i = min(nums)
j = i + B

res = 0
while i <= j:
    m = (i+j) // 2

    tmp = 0
    for num in nums:
        if m > num:
            tmp += (m-num) ** 2
    
    if tmp <= B:
        i = m+1
        res = max(m, res)
    else:
        j = m-1

print(res)
        