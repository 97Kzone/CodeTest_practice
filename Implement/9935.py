import sys
input = sys.stdin.readline

S = input().rstrip()
T = input().rstrip()

l = len(T)
stack = []

for s in S:
    stack.append(s)
    if s == T[-1] and "".join(stack[-l:]) == T:
        del stack[-l:]

print("".join(stack) if stack else "FRULA")
