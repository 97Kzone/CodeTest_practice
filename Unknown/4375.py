while True:
    try:
        N = int(input())
    except:
        break

    std = 1
    while True:
        if std % N == 0:
            break

        std = (std * 10) + 1

    print(len(str(std)))

# 그냥 수학 연습
# 실버 3, 정답률 33프로, solved 22-02-05