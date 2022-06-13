import sys

S = sys.stdin.readline()

cnt = S.count('01') + S.count('10')
print(sum(divmod(cnt, 2)))

#간단한 발상이 빠른해결로
#solved 2021-12-28