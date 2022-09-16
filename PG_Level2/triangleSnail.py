#다른 사람의 풀이를 참조
def solution(n):
    nums = [[0]*i for i in range(1, n+1)]

    v, x, y = 1, -1, 0
    for i in range(n):
        for j in range(i, n):
            if i % 3 == 0:
                x += 1
            elif i % 3 == 1:
                y += 1
            else:
                x -= 1
                y -= 1

            nums[x][y] = v
            v += 1

    return sum(nums, [])