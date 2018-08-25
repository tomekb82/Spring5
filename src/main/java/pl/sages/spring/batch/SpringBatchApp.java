package pl.sages.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchApp {

  public static void main(String[] args)throws Exception {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jobConfig.xml");

    JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class);
    Job job = context.getBean("helloWorldJob", Job.class);

    JobExecution execution = jobLauncher.run(job, new JobParameters());
    System.out.println("Exit Status : " + execution.getStatus());
  }
}
