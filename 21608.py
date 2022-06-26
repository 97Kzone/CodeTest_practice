N = int(input())
board = [[0] * N for _ in range(N)]
students = [list(map(int, input().split())) for _ in range(N ** 2)]

move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

for student in students:
    temp = []

    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                f1, f2 = 0, 0
                for dx, dy in move:
                    nx = i + dx
                    ny = j + dy

                    if 0 <= nx < N and 0 <= ny < N:
                        if board[nx][ny] in student[1:]:
                            f1 += 1
                        if board[nx][ny] == 0:
                            f2 += 1
                    temp.append([f1, f2, i, j])

    temp.sort(key = lambda x : (-x[0], -x[1], x[2], x[3]))
    board[temp[0][2]][temp[0][3]] = student[0]

res = 0
students.sort()
for i in range(N):
    for j in range(N):
        val = 0
        for dx, dy in move:
            nx = i + dx
            ny = j + dy
            if 0 <= nx < N and 0 <= ny < N:
                if board[nx][ny] in students[board[i][j]-1]:
                    val += 1
        if val != 0:
            res += 10 ** (val - 1)
print(res)