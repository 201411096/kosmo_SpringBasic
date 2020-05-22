package aop1_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingSample {
	public void before(JoinPoint p) {
		System.out.println("before: 메소드 호출전--------------------");
		
	}
//	public void after(JoinPoint p) {}
//	public Object around(PreceedingJoinPoint p) {}
	public void afterReturning(JoinPoint p) {
		System.out.println("afterReturning : 메소드 호출 후 예외 발생이 없는 경우");
	}
	
	public Object around(ProceedingJoinPoint point) throws Throwable
	{
		String methodName = point.getSignature().getName();
		System.out.println("[사전 작업sample] : " + methodName);
		Object obj = point.proceed();
		System.out.println("(((사후 작업sample))) : " + methodName);
		return obj;
	}
}
