from collections import deque

q = deque()
disks = []
for _ in range(3):
    val = input().split()
    disk = val[-1] if len(val) > 1 else ''
    disks.append(disk)

q.append([disks[0], disks[1], disks[2], 0])
check = set()

while q:
    a, b, c, cnt = q.popleft()
    temp = a + "," + b + "," + c

    if a == 'A'*len(a) and b == 'B' * len(b) and c == 'C'*len(c):
        print(cnt)
        break

    if temp not in check:
        check.add(temp)

        if len(a) > 0:
            q.append([a[:-1], b+a[-1], c, cnt+1])
            q.append([a[:-1], b, c+a[-1], cnt+1])
        if len(b) > 0:
            q.append([a+b[-1], b[:-1], c, cnt+1])
            q.append([a, b[:-1], c+b[-1], cnt+1])
        if len(c) > 0:
            q.append([a+c[-1], b, c[:-1], cnt+1])
            q.append([a, b+c[-1], c[:-1], cnt+1])
