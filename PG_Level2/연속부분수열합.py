def solution(elements):
    answer = set()
    l = len(elements)
    elements += elements[:-1]

    #길이 2부터 전체까지
    for i in range(1, l+1):
        for j in range(l):
            tmp = sum(elements[j:j+i])
            answer.add(tmp)

    return len(answer)