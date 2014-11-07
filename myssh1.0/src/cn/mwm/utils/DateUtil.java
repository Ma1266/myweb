package cn.mwm.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	static SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yy");

	static SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static SimpleDateFormat df4 = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * 得到当前日期(java.sql.Date类型)，注意：没有时间，只有日期
	 * 
	 * @return 当前日期
	 */
	public static java.sql.Date getDate() {
		Calendar oneCalendar = Calendar.getInstance();
		return getDate(oneCalendar.get(Calendar.YEAR),
				oneCalendar.get(Calendar.MONTH) + 1,
				oneCalendar.get(Calendar.DATE));
	}

	/**
	 * 更具参数去日期年,月,日
	 * 
	 * @param date
	 * @param type
	 * @return
	 */
	public static int getCalendarInt(Date date, int type) {
		Calendar oneCalendar = Calendar.getInstance();
		oneCalendar.setTime(date);
		return oneCalendar.get(type);
	}

	/**
	 * 得到当前日期有时间
	 * 
	 * @return
	 */
	public static Timestamp getDateTime() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return t;
	}

	/**
	 * 根据所给年、月、日，得到日期(java.sql.Date类型)，注意：没有时间，只有日期。
	 * 年、月、日不合法，会抛IllegalArgumentException(不需要catch)
	 * 
	 * @param yyyy
	 *            4位年
	 * @param MM
	 *            月
	 * @param dd
	 *            日
	 * @return 日期
	 */
	public static java.sql.Date getDate(int yyyy, int MM, int dd) {

		if (!verityDate(yyyy, MM, dd)) {
			throw new IllegalArgumentException("This is illegimate date!");
		}

		Calendar oneCalendar = Calendar.getInstance();
		oneCalendar.clear();
		oneCalendar.set(yyyy, MM - 1, dd);
		return new java.sql.Date(oneCalendar.getTime().getTime());
	}

	/**
	 * 根据所给年、月、日，检验是否为合法日期。
	 * 
	 * @param yyyy
	 *            4位年
	 * @param MM
	 *            月
	 * @param dd
	 *            日
	 * @return
	 */
	public static boolean verityDate(int yyyy, int MM, int dd) {
		boolean flag = false;

		if (MM >= 0 && MM <= 12 && dd >= 1 && dd <= 31) {
			if (MM == 4 || MM == 6 || MM == 9 || MM == 11) {
				if (dd <= 30) {
					flag = true;
				}
			} else if (MM == 2) {
				if (yyyy % 100 != 0 && yyyy % 4 == 0 || yyyy % 400 == 0) {
					if (dd <= 29) {
						flag = true;
					}
				} else if (dd <= 28) {
					flag = true;
				}

			} else {
				flag = true;
			}

		}
		return flag;
	}

	/**
	 * 根据所给的起始,终止时间来计算间隔天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return 间隔天数
	 */
	public static int getIntervalDay(Date startDate, Date endDate) {
		long startdate = startDate.getTime();
		long enddate = endDate.getTime();
		long interval = enddate - startdate;
		long intervalday = interval / (1000 * 60 * 60 * 24);
		return new Long(intervalday).intValue();
	}

	/**
	 * 计算两个日期间相隔的周数
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public static int getIntervalWeeks(Date startDate, Date endDate) {
		int weeks = 0;
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		while (beginCalendar.before(endCalendar)) {
			// 如果开始日期和结束日期在同年、同月且当前月的同一周时结束循环
			if (beginCalendar.get(Calendar.YEAR) == endCalendar
					.get(Calendar.YEAR)
					&& beginCalendar.get(Calendar.MONTH) == endCalendar
							.get(Calendar.MONTH)
					&& beginCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) == endCalendar
							.get(Calendar.DAY_OF_WEEK_IN_MONTH)) {
				break;
			} else {
				beginCalendar.add(Calendar.DAY_OF_YEAR, 7);
				weeks += 1;
			}
		}
		return weeks;
	}

	/**
	 * 计算两个日期间相隔的月
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public static int getIntervalMonth(Date startDate, Date endDate) {
		int iMonth = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(startDate);
			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(endDate);
			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = (objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12
						+ objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}

	/**
	 * 根据所给的起始时间,间隔天数来计算终止时间
	 * 
	 * @param startDate
	 * @param day
	 * @return 终止时间
	 */
	public static java.sql.Date getStepDay(java.sql.Date date, int step) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, step);
		return new java.sql.Date(calendar.getTime().getTime());
	}

	/**
	 * 根据所给的起始时间,间隔天数来计算终止时间
	 * 
	 * @param date
	 * @param step
	 * @return
	 */
	public static java.sql.Date getStepWeek(java.sql.Date date, int step) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.WEEK_OF_YEAR, step);
		return new java.sql.Date(calendar.getTime().getTime());
	}

	/**
	 * 得到上一月的日期
	 * 
	 * @param date
	 * @param intBetween
	 * @return date加上intBetween月数后的日期
	 */
	public static java.sql.Date getLastMonth() {
		Calendar oneCalendar = Calendar.getInstance();
		oneCalendar.set(oneCalendar.get(Calendar.YEAR),
				oneCalendar.get(Calendar.MONTH) - 1, 1);
		return new java.sql.Date(oneCalendar.getTime().getTime());
	}

	/**
	 * 得到上一月的最后一天日期
	 * 
	 * @param date
	 * @param intBetween
	 * @return date加上intBetween月数后的日期
	 */
	public static java.sql.Date getLastMonthDay() {

		Calendar oneCalendar = Calendar.getInstance();
		oneCalendar.set(oneCalendar.get(Calendar.YEAR),
				oneCalendar.get(Calendar.MONTH), 1);
		int year = oneCalendar.get(Calendar.YEAR);
		int month = oneCalendar.get(Calendar.MONTH);
		Calendar oneCalendar1 = Calendar.getInstance();
		String lastday = getLastDays(new Integer(year).toString(), new Integer(
				month).toString());
		java.sql.Date lastdate = getDate(oneCalendar1.get(Calendar.YEAR),
				oneCalendar1.get(Calendar.MONTH),
				new Integer(lastday).intValue());
		return lastdate;
	}

	/**
	 * 取得本月第一天
	 * 
	 * @return
	 */
	public static java.sql.Date getMonthFirstDay() {
		Calendar oneCalendar = Calendar.getInstance();
		oneCalendar.set(oneCalendar.get(Calendar.YEAR),
				oneCalendar.get(Calendar.MONTH), 1);
		return new java.sql.Date(oneCalendar.getTime().getTime());
	}

	/**
	 * 取得本月最后一天
	 * 
	 * @return
	 */
	public static java.sql.Date getMonthLastDay() {
		Calendar calo = Calendar.getInstance();
		calo.setTime(getStepMonth(getLastMonthDay(), 1));
		return new java.sql.Date(calo.getTime().getTime());
	}

	/**
	 * 得到将date增加指定月数后的date
	 * 
	 * @param date
	 * @param intBetween
	 * @return date加上intBetween月数后的日期
	 */
	public static java.sql.Date getStepMonth(Date date, int intBetween) {
		Calendar calo = Calendar.getInstance();
		calo.setTime(date);
		calo.add(Calendar.MONTH, intBetween);
		return new java.sql.Date(calo.getTime().getTime());
	}

	/**
	 * 得到将date增加指定年数后的date
	 * 
	 * @param date
	 * @param intBetween
	 * @return
	 */
	public static java.sql.Date getStepYear(Date date, int intBetween) {
		Calendar calo = Calendar.getInstance();
		calo.setTime(date);
		calo.add(Calendar.YEAR, intBetween);
		return new java.sql.Date(calo.getTime().getTime());
	}

	public static java.sql.Date getStepMinute(Date date, int intBetween) {
		Calendar calo = Calendar.getInstance();
		calo.setTime(date);
		calo.add(Calendar.MINUTE, intBetween);
		return new java.sql.Date(calo.getTime().getTime());
	}

	public static String getDateStr(java.sql.Date date) {
		java.text.DateFormat format = java.text.DateFormat.getDateInstance();
		String dateStr = format.format(date);
		return dateStr;
	}

	public static String getDateFormat(Date date) {
		String dateStr = df.format(date);
		return dateStr;
	}

	public static Date getDateParse(int type, String str) throws Exception {
		if (str == null || str.equals(""))
			return null;
		Date date = new Date();
		switch (type) {
		case 1:
			date = df.parse(str);
			break;
		case 2:
			date = df2.parse(str);
			break;
		case 3:
			date = df3.parse(str);
			break;
		case 4:
			date = df4.parse(str);
			break;
		default:
			date = df.parse(str);
			break;
		}
		return date;
	}

	public static String getDateFormat(int type, Date date) {
		if (date == null)
			return "";
		String dateStr = "";
		switch (type) {
		case 1:
			dateStr = df.format(date);
			break;
		case 2:
			dateStr = df2.format(date);
			break;
		case 3:
			dateStr = df3.format(date);
			break;
		case 4:
			dateStr = df4.format(date);
			break;
		default:
			dateStr = df.format(date);
			break;
		}
		return dateStr;
	}

	/**
	 * 取得月份的最后一天的日期
	 * 
	 * @param yy
	 * @param mm
	 * @return
	 */
	public static String getLastDays(String yy, String mm) {
		String day = "30";
		int YY = 0;
		int MM = 0;
		boolean leapYear = false;

		YY = (new Integer(yy)).intValue();
		MM = (new Integer(mm)).intValue();
		if (YY < 1900 || YY > 2200) {
			return (day);
		}

		if (((YY % 4) != 0) && ((YY % 100) != 0)) { // 判断是否为闰年
			leapYear = false;
		} else {
			leapYear = true;
		}
		if (MM == 2) {
			if (leapYear) {
				return "29";
			} else {
				return "28";
			}
		}
		if ((MM == 1) || (MM == 3) || (MM == 5) || (MM == 7) || (MM == 8)
				|| (MM == 10) || (MM == 12) || (MM == 0)) {
			return "31";
		}

		if ((MM == 4) || (MM == 6) || (MM == 9) || (MM == 11)) {
			return day;
		}
		return day;
	}

	/**
	 * 判断是否是闰年
	 */
	public static boolean IsLeapYear(int year) {

		if ((year % 100) == 0)

			return ((year % 400) == 0);

		/* Otherwise leap year iff multiple of 4. */
		return ((year % 4) == 0);

	} // IsLeapYear

	/**
	 * 取得当前年分
	 */
	public static String getCurrentYear() {
		return getCurrentTime(4);
	}

	/*
	 * 得到当前时间自定义长度
	 */
	public static String getCurrentTime(int length) {
		java.sql.Timestamp ts = new java.sql.Timestamp(
				System.currentTimeMillis());
		if (length > ts.toString().length()) {
			length = ts.toString().length();
		}
		String currentTime = ts.toString().substring(0, length);
		return currentTime;
	}

	/**
	 * 取得当前月份
	 */
	public static String getCurrentMonth() {
		return getCurrentTime(7).substring(5, 7);
	}

	/**
	 * 获取当前日期是星期几
	 * 
	 * @param dt
	 * @return
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		java.text.DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String datestr = df.format(dt);
		return datestr + " " + weekDays[w];
	}

	public static String getTodayHms() {
		Date date = new Date();
		String dayStr = df3.format(date);
		return dayStr;
	}

	// 获取当前时间所在年的周数
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	// 获取当前时间所在年的最大周数
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	// 获取某年的第几周的开始日期
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	// 获取某年的第几周的结束日期
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	// 获取当前时间所在周的开始日期
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	// 获取当前时间所在周的结束日期
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * 日期格式解析
	 * 
	 * @param value
	 * @return
	 */
	public static Object processDate(Object value) {
		if (value == null)
			return "";
		if (value instanceof java.sql.Timestamp) {
			return df3.format(new java.util.Date(((java.sql.Timestamp) value)
					.getTime()));
		} else if (value instanceof java.sql.Date) {
			return df.format(new java.util.Date(((java.sql.Date) value)
					.getTime()));
		} else if (value instanceof java.util.Date) {
			return df.format(value);
		}
		return value.toString();
	}

	public static void main(String[] args) {
		Date d1 = new Date();
		try {
			d1 = df.parse("2012-01-06");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date d2 = new Date();
		try {
			d2 = df3.parse("2013-09-01 09:10:11");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// System.out.println(getIntervalDay(d1, d2));
		// System.out.println(getIntervalWeeks(d1, d2));
		// System.out.println(getIntervalMonth(d1, d2));
		// Calendar c = new GregorianCalendar();
		// c.setTime(d1);
		// System.out.println(c.get(Calendar.DAY_OF_MONTH));
		// System.out.println(c.get(Calendar.MONTH));
		// SimpleDateFormat dfd = new SimpleDateFormat("HH:mm");
		// System.out.println(dfd.format(d2));
		Calendar calo = Calendar.getInstance();
		calo.setTime(d1);
		calo.add(Calendar.WEEK_OF_YEAR, 6);
		System.out.println(df.format(calo.getTime()));
		System.out.println(df.format(getStepDay(
				new java.sql.Date(d1.getTime()), 41)));
		// System.out.println(System.getProperty("org.apache.commons.logging.LogFactory"));
	}

}
