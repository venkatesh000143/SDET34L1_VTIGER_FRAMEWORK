package com.vtiger.practice.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateTest {
public static void main(String[] args) {
	Date date=new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ssss");
	String date1 = f.format(date);
	System.out.println(date1);
}
}
