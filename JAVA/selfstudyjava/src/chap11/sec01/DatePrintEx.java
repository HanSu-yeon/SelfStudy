package chap11.sec01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 확인문제 Date와 SimpleDateFormat클래스를 이용해서
 * 2024년 05월 08일 화요일 10시 30분을 출력해라
 */
public class DatePrintEx {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
        System.out.println(sdf.format(now));


        Calendar now2 = Calendar.getInstance();

        int year = now2.get(Calendar.YEAR);

        int month = now2.get(Calendar.MONTH) + 1;
        String strMonth = (month < 10) ? ("0" + month) : ("" + month);

        int dayOfMonth = now2.get(Calendar.DAY_OF_MONTH);
        String strDayOfMonth = (dayOfMonth < 10) ? ("0" + dayOfMonth) : ("" + dayOfMonth);

        String[] dayArray = {"일", "월", "화", "수", "목", "금", "토"};
        int dayOfWeek = now2.get(Calendar.DAY_OF_WEEK);
        String strDayOfWeek = dayArray[dayOfWeek - 1] + "요일";

        int hour = now2.get(Calendar.HOUR);
        String strHour = (hour < 10) ? ("0" + hour) : ("" + hour);
        int minutes = now2.get(Calendar.MINUTE);
        String strMinutes = (minutes < 10) ? ("0" + minutes) : ("" + minutes);

        System.out.print(year + "년 ");
        System.out.print(strMonth + "월 ");
        System.out.print(strDayOfMonth + "일 ");
        System.out.print(strDayOfWeek + " ");
        System.out.print(strHour + "시 ");
        System.out.print(strMinutes + "분");

    }

}
