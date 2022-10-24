for t in range(1, int(input())+1):
    days = {"MON": 6, "TUE": 5, "WED": 4, "THU": 3, "FRI": 2, "SAT": 1, "SUN" : 7}

    print("#{} {}".format(t, days[input()]))