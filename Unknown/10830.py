N, B = map(int, input().split())

def mult(A, B):
    temp = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            for k in range(N):
                temp[i][k] += A[i][j] * B[j][k]
                temp[i][k] %= 1000
    
    return temp

def pow(mat, n):
    if n == 1:
        return mod(mat)
    elif n % 2 == 0:
        temp = pow(mat, n//2)
        return mult(temp, temp)
    else:
        temp = pow(mat, n-1)
        return mult(temp, mat)

def mod(mat):
    for i in range(N):
        for j in range(N):
            mat[i][j] %= 1000
    
    return mat
    
mat = [list(map(int, input().split())) for _ in range(N)]
res = pow(mat, B)

for i in range(N):
    print(" ".join(str(n) for n in res[i]))
