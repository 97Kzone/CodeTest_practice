from cmath import inf

N = int(input())
nums = list(map(int, input().split()))
plus, minus, mul, div = map(int, input().split())

M, m = -inf, inf

def cal(idx, res, plus, minus, mul, div):
    global M, m
    if idx == N:
        M = max(M, res)
        m = min(m, res)
        return
    
    if plus > 0 :
        cal(idx+1, res + nums[idx], plus-1, minus, mul, div)
    if minus > 0:
        cal(idx+1, res - nums[idx], plus, minus-1, mul, div)
    if mul > 0:
        cal(idx+1, res * nums[idx], plus, minus, mul-1, div)
    if div > 0:
        cal(idx+1, int(res / nums[idx]), plus, minus, mul, div-1)

cal(1, nums[0], plus, minus, mul, div)
print(M)
print(m)


