package com.health.example1;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


/*
 * 두 개의 메시지만 출력하고 끝내는 단순한 tasklet...
 */

public class HelloWorldTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
		System.out.println("작업 시작했음~~~~~~~~~~~~~~~~~~~");
		//원하는 작업을 여기에 기술.....
		
		System.out.println("작업 끝남~~~~~~~~~~~~~~~~~");
		return null;
	}
	
}
