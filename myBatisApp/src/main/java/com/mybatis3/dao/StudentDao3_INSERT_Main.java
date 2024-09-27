package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao3_INSERT_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudentBySequence(Dto)--------------------------");
		int insertRowCount=
				studentDao.insertStudentBySequence(
						new Student(null, "시퀀스1", "kim@naver.com", new Date(), "333-9090"));
		System.out.println(">>> dao return insertRowCount:"+insertRowCount);
		
		System.out.println("---------insertStudentBySequenceReturnPrimaryKey---------------");
		Student insertStudent=
				new Student(null, "시퀀스2", "kim2@naver.com", new Date(), "333-7777");
		int insertPrimaryKey = studentDao.insertStudentBySequenceReturnPrimaryKey(insertStudent);
		System.out.println(">>> dao return  insertPrimaryKey:"+insertPrimaryKey);
		System.out.println(">>> Student[Dto]     primary key:"+insertStudent.getStudId());
		
		
		
		
	}
}