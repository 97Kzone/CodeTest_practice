from queue import PriorityQueue as pq

for t in range(1, int(input())+1):
    N, K = map(int, input().split())

    nums = list(map(int, input().split()))
    mq, Mq, aq = pq(), pq(), pq()

    for n in nums:
        if K >= n:
            mq.put((-n, n))
        else:
            Mq.put(n)

    #정복 가능한 행성이 애초에 없으면 -1
    if mq.empty():
        res = -1
    else:
        #초기 예비군 설정
        tmp = mq.get()[1]
        aq.put((-tmp, tmp*2))
        K -= tmp

        #순차적으로 정복 가능성 체크
        while not Mq.empty():
            

