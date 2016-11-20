package com.zhoutc.springmvc.util;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhoutc on 2015/8/21.me
 */
public class TimeUtil {

    public static String getNowOfDateByFormat(String p_format) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(p_format);
        String dateStr = sdf.format(d);
        return dateStr;
    }
    
    
    public static Timestamp  getTimeStampFromStr(String timeStr){
    	Timestamp ts = Timestamp.valueOf(timeStr);
    	return ts;
    }
    
    

    public static String changeDateByFormat(String old_time, String old_format, String new_format) {
        String new_time = "";
        SimpleDateFormat format_old = new SimpleDateFormat(old_format);
        SimpleDateFormat format_new = new SimpleDateFormat(new_format);
        try {
            Date date = format_old.parse(old_time);
            new_time = format_new.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            new_time = old_time;
        }
        return new_time;
    }

    public static String getTimeStampToStr(Timestamp timeStamp){
    	
    	 
        String tsStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
        try {
            tsStr = sdf.format(timeStamp);    
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        return tsStr;
    }
    
    
    public static String getTimeStampToStr2(Timestamp timeStamp){
    	
   	 
        String tsStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        try {
            tsStr = sdf.format(timeStamp);    
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        return tsStr;
    }
    
    
    
    public static long getUnixTimeStampByFormat(String format, String time) {
        long unixtimestamp = 0l;
        try {
            unixtimestamp = new SimpleDateFormat(format).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixtimestamp;
    }


    public static Date getTomorrowBegin() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getTodayBegin() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        //calendar.add(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getYesterdayBegin() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getTomorrowHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getAfterMonthBegin() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getMonthBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getAfterMonthBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getAfterMonthBegin(Date date,int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getMonthEnd(Date date,int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i+1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }


    public static Date getYearEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        calendar.set(Calendar.MONTH, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getLastYearStart(Date date,int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, i);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastYearEnd(Date date,int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,i);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static int getTomorrowBeginSecond() {
        Date date = getTomorrowBegin();
        long tomottow = date.getTime();
        long now = System.currentTimeMillis();
        long life = (tomottow - now) / 1000;
        return (int) life;
    }


    public static long getTomorrowBeginMillSecond() {
        Date date = getTomorrowBegin();
        long tomottow = date.getTime();
        long now = System.currentTimeMillis();
        long life = (tomottow - now);
        return life;
    }

    public static long getTomorrowHourMillSecond(int hour) {
        Date date = getTomorrowHour(hour);
        long tomottow = date.getTime();
        long now = System.currentTimeMillis();
        long life = (tomottow - now);
        return life;
    }

    public static int getAfterMonthBeginSecond() {
        Date date = getAfterMonthBegin();
        long afterMonth = date.getTime();
        long now = System.currentTimeMillis();
        long life = (afterMonth - now) / 1000;
        return (int) life;
    }

    public static Date getBeforeNowMinuteTime(int minutes) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -minutes);
        return calendar.getTime();

    }

    public static String getTimeByFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static long getDelayMillSecond(String delayTime) {
        try {
            Date delayDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(delayTime);
            Date nowDate = new Date();
            return delayDate.getTime() - nowDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Integer distanceMonths(Date a,Date b){

        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(a);
            int aMonth = calendar.get(Calendar.MONTH);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(b);
            int bMonth = calendar2.get(Calendar.MONTH);
            return bMonth-aMonth+1;
        }catch (Exception e){

        }
        return null;
    }

    public static String distanceNowTimeString(int months, int days, int hours , int minutes , int seconds , int milliseconds, String formate) {
        try {

            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            calendar.add(Calendar.HOUR_OF_DAY, hours);
            calendar.add(Calendar.MINUTE, minutes);
            calendar.add(Calendar.SECOND, seconds);
            calendar.add(Calendar.MILLISECOND, milliseconds);
            return  new SimpleDateFormat(formate).format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTimeString(int months, int days, int hours , int minutes , int seconds , int milliseconds, String formate) {
        try {

            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            if(months!=-1) calendar.set(Calendar.MONTH, months);
            if(days!=-1)calendar.set(Calendar.DAY_OF_MONTH, days);
            if(hours!=-1)calendar.set(Calendar.HOUR_OF_DAY, hours);
            if(minutes!=-1)calendar.set(Calendar.MINUTE, minutes);
            if(seconds!=-1) calendar.set(Calendar.SECOND, seconds);
            if(milliseconds!=-1) calendar.set(Calendar.MILLISECOND, milliseconds);
            return  new SimpleDateFormat(formate).format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getDelayHourMillSecond(int hour) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date date = new Date();
            if (date.getTime() > calendar.getTime().getTime()) {
                calendar.add(Calendar.DAY_OF_MONTH,1);
            }
            return calendar.getTime().getTime() - date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean isMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
        return lastDay==nowDay;
    }

    public static boolean isMonthDay(int day){
        Calendar calendar = Calendar.getInstance();
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
        return day==nowDay;
    }

    public static Date getMonthStart(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }



    public static void main(String[] args) {
        // String recharge_time = TimeUtil.changeDateByFormat("20150101020304","yyyyMMddHHmmss","yyyy年MM月dd日HH点mm分");

        // System.out.println(recharge_time);

        // System.out.println(getUnixTimeStampByFormat("yyyyMMddHHmmss","20150916120000")/1000);
        //  System.out.println(System.currentTimeMillis());
        //   System.out.println(getTomorrowBeginSecond());
        //  System.out.println(getAfterMonthBegin().toString());
        //   System.out.println(getAfterMonthBeginSecond());

        //  System.out.println(getTimeByFormat(getBeforeNowMinuteTime(60*4), "yyyyMMddHHmmss"));
      //  System.out.println(isMonthDay(29));

      //  System.out.println(distanceNowTimeString( 0, 0, 1, 0 , 0 , 0, "yyyyMMddHHmmss"));
//        System.out.println(getTimeString(-1,-1, 5, 0, 0, 0, "yyyyMMddHHmmss"));
//
//        String date  = TimeUtil.distanceNowTimeString(0, -4, 0, 0, 0, 0, "yyyyMMdd");
//        System.out.println(date);
    	
    	//System.out.println(getTimeStampFromStr("1999-12-25 22:22:22").toLocaleString());
        System.out.println(getLastYearStart(new Date(),1).toLocaleString());
    }
}
