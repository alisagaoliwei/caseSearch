package com.greatsoft.casecheck.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * <p>Title: 日期util</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: DigitalChina</p>
 *
 * @version 1.0
 *
 */

/**
 * 日期相关的操作
 */
public class DateUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    //每一天的毫秒数
    private static final long MS_EVERY_DAY = 1000 * 60 * 60 *24;

    //默认的pattern
    public final static String PATTERN = "yyyyMMdd";

    public final static String PATTERN_ = "yyMMdd";

    public final static String PATTERN_1 = "yyyy/MM/dd";
    
    public final static String PATTERN_2 = "yyyy/MM/dd HH:mm:ss";

    public final static String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss";

    public final static String PATTERN_TIME2 = "yyyy-MM-dd";

    public final static String PATTERN_TIME3 = "yyyy-MM-dd";

    public final static String PATTERN_TIME4 = "yyyy-MM-dd HH:mm";

    public final static String PATTERN_TIME5 = "yyyy年MM月dd日 HH时mm分";

    public final static String PATTERN_TIME7 = "yyyy年MM月dd日";

    public final static String TIMESTAMP_PATTERN = "yyyyMMddHHmmss";

    public final static String TIMESTAMP_1 = "yyyyMMddHHmmss";
    
    public final static String TIMESTAMP_2 = "HHmmss";
    
    public final static String TIMESTAMP_3 = "HH:mm:ss";
    
    public final static String TIMESTAMP_4 = "HH:mm";

    public  final static String PATTERN_3 = "yyyyMM";
    
    public  final static String PATTERN_4 = "yyyy-MM";

    public final static String PATTERN_TIME6 = "MM-dd HH:mm";
    
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    /**
     * 中文简写 如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";
    
    public static String PATTERN_5 = "yy";

    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    /**
     * 根据预设格式返回当前日期
     * 
     * @return
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 根据用户格式返回当前日期
     * 
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日期
     * 
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }

    /**
     * 使用用户格式格式化日期
     * 
     * @param date
     *            日期
     * @param pattern
     *            日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 使用预设格式提取字符串日期
     * 
     * @param strDate
     *            日期字符串
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用用户格式提取字符串日期
     * 
     * @param strDate
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return null;
        }
    }
    /**
     * 在日期上增加年
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的年
     * @return
     */
    public static Date addYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加数个整月
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的月数
     * @return
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
    
    

    /**
     * 在日期上增加天数
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }
    
    /**
     * 在日期上增加分钟
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的分钟
     * @return
     */
    public static Date addMinute(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加秒
     * 
     * @param date
     *            日期
     * @param n
     *            要增加的秒数
     * @return
     */
    public static Date addSecond(Date date, int n) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.SECOND, n);
    	return cal.getTime();
    }
    
    /**
     * 获取时间戳
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     * 
     * @param date
     *            日期
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 按默认格式的字符串距离今天的天数
     * 
     * @param date
     *            日期字符串
     * @return
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 按用户格式字符串距离今天的天数
     * 
     * @param date
     *            日期字符串
     * @param format
     *            日期格式
     * @return
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    // 日期格式化
    private static SimpleDateFormat dateFormat;


    static {
        dateFormat = new SimpleDateFormat();
    }
    /**
     *
     */
    public DateUtil() {
        super();
    }

    /*
     *  按自定义格式取得当前日期时间
     *  Sample: DateTimeUtil.getCurrDateTime("yyyyMMddHHmmss")
     */
    public static synchronized String getCurrDateTime(String format){
		Calendar calendar = GregorianCalendar.getInstance();
        Date date = calendar.getTime();
        dateFormat.applyPattern(format);
        return dateFormat.format(date);
	}

    /**
     * 返回昨天的日期
     * @return
     */
    public static String getYesterdayDate(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date beginDate = calendar.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
        String yesterdayDate = dateFmt.format(beginDate);

        return yesterdayDate;
    }

    /**
     * 由日期型转化为"yyyyMMdd"形式的String类型
     * @param date
     * @return
     */
    public static String dateToString(Date date){

        SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
        return dateFmt.format(date);
    }

    /**
     * 由日期型转化为"yyyyMMdd"形式的String类型
     * @param date
     * @return
     */
    public static String dateToString(Date date , String pattern){

        SimpleDateFormat dateFmt = new SimpleDateFormat( pattern );
        return dateFmt.format(date);
    }
    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate_Time( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN_TIME);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 由String类型，转化为日期型
     * @param strDate zhs加
     * @return
     * @throws ParseException
     */
    public static Date stringToDate_Time2( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN_TIME2);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringTo_Date_Time2( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN_TIME3);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate( String strDate, String pattern ) throws ParseException{
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 得到两个日期型数据之间所差的天数,此处为闭区间
     * @param beginDate 起始的日期
     * @param endDate 结束的日期
     * @return 相差的天数
     */
    public static long compare( Date beginDate, Date endDate ){
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        long betweenDays = (endTime - beginTime) / MS_EVERY_DAY;
        if( betweenDays >= 0) {
            return betweenDays + 1;
        }else {
            return betweenDays - 1;
        }
    }

    /**
     * 得到两个日期型数据之间所差的天数,此处为开区间
     * @param beginDate 起始的日期
     * @param endDate 结束的日期
     * @return 相差的天数
     */
    public static long compareDate( Date beginDate, Date endDate ){
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        long betweenDays = (endTime - beginTime) / MS_EVERY_DAY;
        if( betweenDays >= 0) {
            return betweenDays;
        }else {
            return betweenDays;
        }
    }

    /**
     * 得到一个日期与当前时间之间所差的天数,此处为闭区间
     * @param beginDate 起始的日期
     * @return 相差的天数
     */
    public static long compare( Date beginDate ){
        long beginTime = beginDate.getTime();
        Calendar calendar = GregorianCalendar.getInstance();
        Date endDate = calendar.getTime();
        long endTime = endDate.getTime();
        long betweenDays = (endTime - beginTime) / MS_EVERY_DAY;
        return betweenDays;
    }

    /**
     * 取date后第n天的Date
     * @param date
     * @param n
     * @return
     */
    public static Date nextDate( Date date , int n ){
        long day = n * MS_EVERY_DAY ;
        Date d = new Date( date.getTime() + day );
        return d ;
    }

    /**
     * 检查日期合法性,默认formatType为yyyyMMdd
     * @param date
     * @param formatType
     * @return
     */
    public static boolean checkDate(String date,String formatType){
    	if(null==date) {
            return false;
        }
    	if("".equalsIgnoreCase(formatType)||null==formatType){
            formatType = "yyyyMMdd";
        }
    	try{
    		  //以SimpleDateFormat來檢核日期
    		  //關於 SimpleDateFormat 請自己看Java api spec
    		  SimpleDateFormat dFormat = new SimpleDateFormat(formatType);

    		  //就是這下面這一行，花了我大半天找問題…
    		  dFormat.setLenient(false);

    		  //如果成功就是正確的日期，失敗就是有錯誤的日期。
//    		  java.util.Date d = dFormat.parse(date);
    		  dFormat.parse(date);

    		  return true;
    		}catch(ParseException e){
    		  //告訴user，這個日期不是一個正確的日期"
    			return false;
    		}
    }

     /**
     * 取得n天时间
     *
     * @param n n=0 今天 n=1 明天；n=0 今天 n=-1 昨天
     * @return String 返回n天时间 yyyy-mm-dd
     */
    public static String getDateList(int n) {

        GregorianCalendar gcDate = new GregorianCalendar();
        String sbDateTodayTime;
        int year = gcDate.get(1);
        int month = gcDate.get(2);
        int date = gcDate.get(5);
        GregorianCalendar oneWeek = new GregorianCalendar(year, month, date);
        oneWeek.add(5, n);
        Date date2 = oneWeek.getTime();
        sbDateTodayTime = dateFormat.format(date2);
        return sbDateTodayTime;
    }

    /**
     * 获取当前时间，返回时间格式(如果调用参数为true时返回yyyy-MM-dd
     * ，否则为false时返回yyyy-MM-dd HH:mm:ss不带日期格式)
     * @param time boolean
     * @return String
     *
     */
    public static String getNowTime(boolean time){
        Date now = new Date();
        String format = "";
        //yyyy-MM-dd HH:mm:ss:S 年月日时分秒毫杪
        if (time) {
            format = "yyyy-MM-dd ";
        } else {
            format = "yyyy-MM-dd HH:mm:ss.s";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(now);
        return nowtime;
    }


    /**
     * 获取当前时间，返回时间格式yyyyMMdd
     */
    public static String getNowTime(){
        Date now = new Date();
        String format = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(now);
        return nowtime;
    }

    /**
     * 返回6位当前时间 生成报文参考号时使用
     *
     * @return
     */
    public static String getCurrentTime() {
        return parseDate(new Date(), PATTERN_);
    }

    //
    // /**
    // * 返回当前时间 生成报文参考号时使用
    // *
    // * @return
    // */
    // public static String getCurrentTimeForHvps() {
    // return parseDate(new Date());
    // }

    /**
     * @param dateStr
     *            日期字符串
     * @return
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, PATTERN);
    }

    /**
     * @param date
     * @return
     */
    public static String parseDateTimeStamp(Date date) {
        return parseDate(date, TIMESTAMP_PATTERN);
    }

    /**
     * @param dateStr
     *            日期字符串
     * @return
     */
    public static Timestamp parseDateTimeStamp(String dateStr) {
        return new Timestamp(parseDate(dateStr, TIMESTAMP_PATTERN).getTime());
    }

    /**
     * @param dateStr
     *            日期字符串
     * @param pattern
     *            格式化字符串
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        // dateFmt.applyPattern(pattern);
        SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFmt.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     *
     * @param date
     *            日期
     * @return
     */
    public static String parseDate(Date date) {
        return parseDate(date, PATTERN);
    }

    /**
     * @param date
     *            日期
     * @param pattern
     *            格式化字符串
     * @return
     */
    public static String parseDate(Date date, String pattern) {
        SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
        return dateFmt.format(date);
    }

    /**
     * 计算某一月份的最大天数
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDay(int year, int month) {
    	Calendar time=Calendar.getInstance();
    	time.clear();//注：在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
    	time.set(Calendar.YEAR,year);
    	time.set(Calendar.MONTH,month-1);//注意,Calendar对象默认一月为0
    	int day=time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
    	return day;
    }

    /**计算两个时间之间相隔天数
     * @param startday  开始时间
     * @param endday 结束时间
     * @return
     */
    public int getIntervalDays(Calendar startday,Calendar endday){
        //确保startday在endday之前
        if(startday.after(endday)){
            Calendar cal=startday;
            startday=endday;
            endday=cal;
        }
        //分别得到两个时间的毫秒数
        long sl=startday.getTimeInMillis();
        long el=endday.getTimeInMillis();

        long ei=el-sl;
        //根据毫秒数计算间隔天数
        return (int)(ei/(1000*60*60*24));
    }
    /**计算两个时间之间相隔天数
     * @param startday  开始时间
     * @param endday 结束时间
     * @return
     */
    public static int getBetweenDays(Date startday,Date endday){
        //确保startday在endday之前
        if(startday.after(endday)){
            Date cal=startday;
            startday=endday;
            endday=cal;
        }
        //分别得到两个时间的毫秒数
        long sl=startday.getTime();
        long el=endday.getTime();

        long ei=el-sl;
        //根据毫秒数计算间隔天数
        return (int)(ei/(1000*60*60*24));
    }
    /**计算两个时间之间相隔天数
     * @param startday  开始时间
     * @param endday 结束时间
     * @return
     */
    public int getIntervalDays(Date startday,Date endday){
        //确保startday在endday之前
        if(startday.after(endday)){
            Date cal=startday;
            startday=endday;
            endday=cal;
        }
        //分别得到两个时间的毫秒数
        long sl=startday.getTime();
        long el=endday.getTime();

        long ei=el-sl;
        //根据毫秒数计算间隔天数
        return (int)(ei/(1000*60*60*24));
    }

    /**
     * 改进精确计算相隔天数的方法
     */
    public int getDaysBetween (Calendar d1, Calendar d2){
        if (d1.after(d2)){  // swap dates so that d1 is start and d2 is end
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2){
            d1 = (Calendar) d1.clone();
            do{
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);//得到当年的实际天数
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }
    /**
	 * 返回时间间隔的秒数
	 * @param endDate
	 * @param nowDate
	 * @return
	 */
    public static int calLastedTime(Date endDate, Date nowDate) {
		long a = endDate.getTime();
		long b = nowDate.getTime();
		int c = (int) ((a - b) / 1000);
		return c;
	}

	/**
	 * 比较一个日期大于等于另一个
	 * 
	 * @param bigger
	 * @param smaller
	 * @return
	 */
	public static boolean compareDateShort(Date bigger, Date smaller) {
		long biggerLong = DateUtil.parse(DateUtil.parseDate(bigger, DateUtil.FORMAT_SHORT), DateUtil.FORMAT_SHORT).getTime();
		long smallerLong = DateUtil.parse(DateUtil.parseDate(smaller, DateUtil.FORMAT_SHORT), DateUtil.FORMAT_SHORT).getTime();
		return biggerLong >= smallerLong;
	}
	
	public static boolean compareDateLong(Date bigger, Date smaller) {
		long biggerLong = DateUtil.parse(DateUtil.parseDate(bigger, DateUtil.FORMAT_LONG), DateUtil.FORMAT_LONG).getTime();
		long smallerLong = DateUtil.parse(DateUtil.parseDate(smaller, DateUtil.FORMAT_LONG), DateUtil.FORMAT_LONG).getTime();
		return biggerLong >= smallerLong;
	}

	/**
	 * 比较一个日期介于另外两个日期之间（包含顶点日期）--闭区间
	 * 
	 * @param now
	 * @param bigger
	 * @param smaller
	 * @return
	 */
	public static boolean compareDateShort(Date now, Date smaller, Date bigger) {
		return compareDateShort(now, smaller) && compareDateShort(bigger, now);
	}
	
	public static boolean compareDateLong(Date now, Date smaller, Date bigger) {
		return compareDateLong(now, smaller) && compareDateLong(bigger, now);
	}

    
    public static String timeDifference(String time) throws ParseException{
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date now = df.parse(DateUtil.getNow(DateUtil.FORMAT_LONG));
    	Date date=df.parse(time);
    	long l=now.getTime()-date.getTime();
	   	return l/1000+"";
    }
    
    /**
     * 判断两个日期是否是同一天
     * 
     * @param date1
     *            date1
     * @param date2
     *            date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                        .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }
    
    
    
    /**
     * 是否是指定日期
     *
     * @param date
     * @param day
     * @return
     */
     public static boolean isTheDay(final Date date, final Date day) {
             return date.getTime() >= DateUtil.dayBegin(day).getTime()
                             && date.getTime() <= DateUtil.dayEnd(day).getTime();
     }
     
     
     
     /**
     * 获取指定时间的那天 00:00:00.000 的时间
     *
     * @param date
     * @return
     */
     public static Date dayBegin(final Date date) {
             Calendar c = Calendar.getInstance();
             c.setTime(date);
             c.set(Calendar.HOUR_OF_DAY, 0);
             c.set(Calendar.MINUTE, 0);
             c.set(Calendar.SECOND, 0);
             c.set(Calendar.MILLISECOND, 0);
             return c.getTime();
     }
     /**
     * 获取指定时间的那天 23:59:59.999 的时间
     *
     * @param date
     * @return
     */
     public static Date dayEnd(final Date date) {
             Calendar c = Calendar.getInstance();
             c.setTime(date);
             c.set(Calendar.HOUR_OF_DAY, 23);
             c.set(Calendar.MINUTE, 59);
             c.set(Calendar.SECOND, 59);
             c.set(Calendar.MILLISECOND, 999);
             return c.getTime();
     }
     
     
     /**
      * 是否是今天
      *
      * @param date
      * @return
      */
      public static boolean isToday(final Date date) {
              return DateUtil.isTheDay(date,new Date());
      }
    
      public static Date turnForUTC(String date){
		try {
			date = date.replace("Z", " UTC");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			return df.parse(date);
		} catch (ParseException e) {
			return null;
		} 
      }

    /**
     * 获取日期的年
     * @param date
     * @return
     */
    public static int getDateYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取日期的月
     * @param date
     * @return
     */
    public static int getDateMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的日
     * @param date
     * @return
     */
    public static int getDateDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取日期的时
     * @param date
     * @return
     */
    public static int getDateHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取日期的分种
     * @param date
     * @return
     */
    public static int getDateMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取日期的秒
     * @param date
     * @return
     */
    public static int getDateSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取日期的秒
     * @param date
     * @return
     */
    public static int getDateMilliSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * 获取某天当前时间后的每半小时时间段 7-21
     *
     * @param date
     * @return
     */
    public static Map<Date,Date> getDateMap(Date date) {
        Map<Date,Date> map =  new TreeMap<>();
        Date currDate = new Date();
        Date dayBegin = dayBegin(date);
        long dayBeginTime = dayBegin.getTime() + 60 * 60 * 1000 * 7; // 获取dayBegin那天7点的毫秒数
        long dayEndTime = dayBegin.getTime() + 60 * 60 * 1000 * 21;  // 获取dayBegin那天21点的毫秒数

        // 判断当前时间是否大于7点
        if(currDate.getTime() > dayBeginTime){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currDate);
            // 毫秒和秒置为0
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND,0);
            int minute = 0;
            int dateMinute = getDateMinute(calendar.getTime());

            if(0 < dateMinute && dateMinute < 30){
                minute = 30 - getDateMinute(calendar.getTime());
            }else if(30 < dateMinute && dateMinute < 60){
                minute = 60 - getDateMinute(calendar.getTime());
            }

            dayBeginTime = addMinute(calendar.getTime(),minute).getTime();
        }

        long endTime = addMinute(new Date(dayBeginTime),30).getTime();
        while (endTime <= dayEndTime){
            map.put(new Date(dayBeginTime),new Date(endTime));

            dayBeginTime = endTime;
            endTime += 60 * 1000 * 30;
        }

        return map;
    }

    public static void main(String[] args) {
        Map<Date, Date> dateMap = getDateMap(new Date());
        System.out.println(JSON.toJSON(dateMap));
    }
}
