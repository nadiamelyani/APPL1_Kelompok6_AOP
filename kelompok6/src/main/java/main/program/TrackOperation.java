package main.program;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;

@Aspect
public class TrackOperation {
 
   @Pointcut("execution(* main.program.Operation(..)")
   private void selectAll(){}

   @Before("execution(* main.program.Operation.create(..)")
   public void beforeAdvice(JoinPoint joinpoint){
	  System.out.println("-------------------------------");
      System.out.println("Going to setup student profile.");
      System.out.println("-------------------------------");
   }

   @After("selectAll()")
   public void afterAdvice(){
	   System.out.println("-------------------------------");
      System.out.println("Student profile has been setup.");
      System.out.println("-------------------------------");
   }

   @AfterReturning(pointcut = "selectAll()", returning = "retVal")
   public void afterReturningAdvice(Object retVal){
	   System.out.println("-------------------------------");
      System.out.println("Returning:" + retVal.toString() );
      System.out.println("-------------------------------");
   }

   @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
   public void AfterThrowingAdvice(IllegalArgumentException ex){
      System.out.println("There has been an exception: " + ex.toString());   
   }
}
