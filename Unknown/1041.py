N = int(input())
dice = list(map(int, input().split()))

temp = sorted(dice)
if N == 1:
    print(sum(temp[:5]))
else:
    one = min(dice)*(((N-2)**2)*5 + ((N-2)*4)) # 한 면만 보이는 주사위의 최소값 합

    std = []
    for i in range(6):
        for j in range(i+1, 6):
            if i + j != 5:
                std.append((dice[i] + dice[j]))

    two = min(std) * ((N-2)*8 + 4) # 두 면이 보이는 주사위의 최소값 합

    key = ['a', 'b', 'c', 'd', 'e', 'f'] #세 면이 보이는 주사위 최소값 합
    dict = {k:v for k, v in zip(key, dice)}
    val = min(dict['a'] + dict['b'] + dict['c'],
    dict['a'] + dict['b'] + dict['d'],
    dict['a'] + dict['c'] + dict['e'],
    dict['a'] + dict['d'] + dict['e'],
    dict['b'] + dict['c'] + dict['f'],
    dict['b'] + dict['d'] + dict['f'],
    dict['c'] + dict['e'] + dict['f'],
    dict['d'] + dict['e'] + dict['f'])

    three = val * 4
    print(three + two + one)

# 고전적인 문제, 하지만 까다로운 조건과 난이도
# 수학적인 접근과 조건의 예외들을 모두 고려해야 해서 시간이 많이 걸린 문제
# 정답률 24%, solved 2022-01-07