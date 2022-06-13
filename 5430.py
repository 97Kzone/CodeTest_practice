import sys

def AC(rules, N, nums):
    rules.replace("RR", "")
    left, right, flag = 0, 0, True

    for rule in rules:
        if rule == "R":
            flag = not flag
        elif rule == "D":
            if flag:
                left += 1
            else:
                right += 1
    
    if left + right <= N:
        res = nums[left:N-right]
        if flag:
            return '[' + ','.join(res) + ']\n'
        else:
            return '[' + ','.join(res[::-1]) + ']\n'
    else:
        return "error\n"

T = int(input())
for _ in range(T):
    rules = sys.stdin.readline().rstrip("\n")
    N = int(input())
    nums = sys.stdin.readline().strip()[1:-1].split(",")

    if N == 0: nums = []
    sys.stdout.write(AC(rules, N, nums))


# 입력과 출력 조건이 너무 까다로웠던 문제, 공백과 줄 바꿈이 틀리면 틀린다...
# 골드 5, 정답률 20프로, solved 2022-01-22