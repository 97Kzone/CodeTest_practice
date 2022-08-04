from collections import deque as q
aq, bq = q(), q()
words = list(input())
res = 0

#일단 C를 최대한 지우자
for i, word in enumerate(words):
    if word == "A":
        aq.append(i)
    elif word == "B":
        bq.append(i)
    else:
        if bq:
            bq.popleft()
            res += 1

# B를 최대한 지워보자
while aq and bq:
    if aq[0] < bq[0]:
        aq.popleft()
        bq.popleft()
        res += 1
    else:
        bq.popleft()

print(res)
