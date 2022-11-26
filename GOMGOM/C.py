#일단, 가진 식권을 다 털고 남은 걸 넘기자
needs = list(map(int, input().split()))
coupon = list(map(int, input().split()))

res = 0

#두 바퀴만 돌려보자
for _ in range(2):
    for i in range(3):
        if needs[i] < coupon[i]:
            res += needs[i]
            coupon[i] -= needs[i]
            needs[i] = 0

            #남은 쿠폰 넘겨버리기
            tmp = coupon[i]//3
            coupon[(i+1)%3] += tmp
            coupon[i] = 0
        else:
            res += coupon[i]
            needs[i] -= coupon[i]
            coupon[i] = 0

print(res)