for t in range(1, int(input()) + 1):
    N = int(input())
    print("#{} {}".format(t, "Alice")) if (N-1) % 2 == 1 else print("#{} {}".format(t, "Bob"))
    