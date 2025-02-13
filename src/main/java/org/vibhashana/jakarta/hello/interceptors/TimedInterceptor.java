package org.vibhashana.jakarta.hello.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Timed
public class TimedInterceptor {
	@AroundInvoke
	public Object timeInvocation(InvocationContext ctx) throws Exception {
		// Before method
		System.out.println("Running before method: " + ctx.getMethod());
		long start = System.currentTimeMillis();

		Object result = ctx.proceed();

		// After method
		System.out.println("Running after method: " + ctx.getMethod());
		long end = System.currentTimeMillis();

		return result.toString() + " calculated in " + (end - start) + " ms";
	}
}
