package per.kayu.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateTest {

    public static void main(String args[]) throws ParseException{
//        String str = "2014-07-25 20:32:35";
//        String str2 = "2014-07-25 20:24:57";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = sdf.parse(str);
//        Date date2 = sdf.parse(str2);
//        if(date.after(date2)){
//            String formatString = sdf2.format(date);
//            System.out.println(formatString);
//        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdfHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy/MM/dd");
        List<Date> list = new ArrayList<Date>();
        Date kadoubiDate = sdf.parse("20140625");
        Date kadoubiDate2 = sdf.parse("20140626");
        Date kadoubiDate3 = sdf.parse("20140627");
        Date kadoubiDate4 = sdf.parse("20140630");
        Date kadoubiDate5 = sdf.parse("20140701");
        list.add(kadoubiDate);
        list.add(kadoubiDate2);
        list.add(kadoubiDate3);
        list.add(kadoubiDate4);
        list.add(kadoubiDate5);
        Date startDateDate = sdfHHmmss.parse("2014-06-30 17:22:21");
        String startDay = sdf.format(startDateDate);
        Date endDateDate = sdfHHmmss.parse("2014-06-30 17:22:22");
        String endDay = sdf.format(endDateDate);
        for(Date date:list){
            if(startDay.compareTo(sdf.format(date))<=0&&endDay.compareTo(sdf.format(date))>=0){
                System.out.println(sdfOut.format(date));
            }
        }
        
        long endTime = endDateDate.getTime();
        long startTime = startDateDate.getTime();
        BigDecimal b1 = new BigDecimal(String.valueOf(endTime));
        BigDecimal b2 = new BigDecimal(String.valueOf(startTime));
        System.out.println(endTime);
        System.out.println(startTime);
        double b3 = b1.subtract(b2).divide(new BigDecimal("1000")).divide(new BigDecimal("60"),3,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        double b4 = b3 - 1;
        System.out.println(b3);
        System.out.println(b4);
        float calucate = (endTime-startTime)/1000/60;
        System.out.println(calucate);
    }
}
