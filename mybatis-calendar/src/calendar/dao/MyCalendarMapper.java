package calendar.dao;

import java.util.ArrayList;
import java.util.HashMap;

import calendar.vo.MyCalendar;

public interface MyCalendarMapper {

	public int insert(MyCalendar m);

	public ArrayList<MyCalendar> list();

	public MyCalendar read(int n);

	public int delete(int n);

	public MyCalendar search(HashMap<String, Object> map);

	public int update(HashMap<String, Object> map);
	
	
}
