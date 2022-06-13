E, S, M = map(int, input().split())

res, e, s, m = 1, 1, 1, 1
while True:
    if e % 16 == 0 : e = 1
    if s % 29 == 0 : s = 1
    if m % 20 == 0 : m = 1
    
    if e == E and s == S and m == M:
        break

    e += 1
    s += 1
    m += 1

    res += 1

print(res)

#진짜 바보처럼 푼 문제, 앞으로는 변수의 순서를 잘 확인하자...
#실버 5, 정답률 66프로, solved 22-02-06