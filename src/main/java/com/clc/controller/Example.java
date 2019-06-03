package com.clc.controller;

import java.util.ArrayList;

public class Example {
public static void main(String[] args) {
	ArrayList<String> s = new ArrayList<String>();
	s.add("ABC");
	s.add("pqr");
	s.add("ABC");
	s.add("xyz");
	
	System.out.println(s);
	ArrayList<String> s2 = new ArrayList<String>();
	s2.add("ABC");
	
	s.removeAll(s2);
	System.out.println(s);
	
}
}
