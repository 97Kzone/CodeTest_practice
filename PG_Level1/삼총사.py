from itertools import combinations as cb

def solution(number):
    answer = 0

    for nums in cb(number, 3):
        if sum(nums) == 0:
            answer += 1

    return answer