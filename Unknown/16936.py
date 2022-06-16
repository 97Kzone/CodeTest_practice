N = int(input())
nums = list(map(int, input().split()))

def check(num, cand):
    if num not in nums:
        return

    cand.append(num)

    if len(cand) == N:
        return

    check(cal1(num), cand)
    check(cal2(num), cand)

def cal1(num):
    if num % 3 == 0:
        num //= 3
        return num

def cal2(num):
    num *= 2
    return num

for num in nums:
    cand = []
    check(num, cand)
    
    if len(cand) == N:
        ans = cand

print(' '.join(str(n) for n in ans))