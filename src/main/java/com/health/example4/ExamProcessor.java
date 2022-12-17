package com.health.example4;

import org.springframework.batch.item.ItemProcessor;

public class ExamProcessor implements ItemProcessor<Exam, Exam> {
	
	public Exam process(Exam exam) throws Exception {
		exam.setGrade(Exam.Grade.convertScore(exam.getScore()));
		
		return exam;
	}

}
