import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class collection {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();

        // 세팅
        init();

        int days;
        // 윤년 체크
        if (month == 2) {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0)
                days = 29;
            else
                days = 28;
        } else {
            days = map.get(month);
        }
        System.out.print(days + " days for " + year + "-" + month);
    }
    
    static void init() {
        map.put(1, 31);
        map.put(3, 31);
        map.put(5, 31);
        map.put(7, 31);
        map.put(8, 31);
        map.put(10, 31);
        map.put(12, 31);

        map.put(4, 30);
        map.put(6, 30);
        map.put(9, 30);
        map.put(11, 30);
    }
}
