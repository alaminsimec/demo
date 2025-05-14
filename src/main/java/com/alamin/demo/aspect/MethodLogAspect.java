package com.alamin.demo.aspect;


import com.alamin.demo.annotation.MethodLog;
import com.alamin.demo.core.dto.log.MethodLogDTO;
import com.alamin.demo.core.services.log.MethodLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;


/**
 * Aspect class for logging method execution details.
 */
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class MethodLogAspect {
    private final MethodLogService methodLogService;

    /**
     * Logs method execution details annotated with @MethodLog.
     *
     * @param pjp       the proceeding join point
     * @param methodLog the method log annotation
     * @return the result of the method execution
     * @throws Throwable if the method execution fails
     */
    @Around(value = "@annotation(com.alamin.demo.annotation.MethodLog) && @annotation(methodLog)", argNames = "pjp, methodLog")
    public Object methodLog(ProceedingJoinPoint pjp, MethodLog methodLog) throws Throwable {
        long startTime = System.currentTimeMillis();
        String threadName = Thread.currentThread().getName();
        String className = methodLog.clazzName();
        String methodName = pjp.getSignature().getName();
        String exceptionMessage = null;
        try {
            Object result = pjp.proceed();
            long endTime = System.currentTimeMillis();
            log.info("\nThread-Name: {}\nClass-Name: {}\nMethod-Name: {}\nExecute-Time: {} ms",
                    Thread.currentThread().getName(),
                    methodName,
                    pjp.getSignature().getName(),
                    (endTime - startTime));
            exceptionMessage = "SUCCESS";
            return result;
        } catch (Throwable e) {
            long endTime = System.currentTimeMillis();
            log.error("\n[EXCEPTION] Thread: {}\nClass: {}\nMethod: {}\nTime: {} ms\nMessage: {}",
                    Thread.currentThread().getName(),
                    methodName,
                    pjp.getSignature().getName(),
                    (endTime - startTime),
                    e.getMessage(), e);
            exceptionMessage = "ERROR";
            throw e; // Propagate exception for @RestControllerAdvice to handle
        }finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            methodLogService.logMethodExecution(new MethodLogDTO(threadName, className, methodName, executionTime, exceptionMessage, startTime, endTime));
        }
    }

//    /**
//     * Logs method execution with a String parameter.
//     *
//     * @param name the String parameter
//     */
//    @Before("execution(* com.alamin.coreSpringDataJpa.core.service.impl.AspectTestServiceImpl.parameterData(String)) && args(name)")
//    public void beforeStringParam(String name) {
//        log.info("==> [BEFORE] parameterData called with: {}", name);
//    }
//
//    /**
//     * Logs method execution with an AspectDTO parameter.
//     *
//     * @param dto the AspectDTO parameter
//     */
//    @Before("execution(* com.alamin.coreSpringDataJpa.core.service.impl.AspectTestServiceImpl.parameterObject(com.alamin.coreSpringDataJpa.core.dto.AspectDTO)) && args(dto)")
//    public void beforeObjectParam(AspectDTO dto) {
//        log.info("==> [BEFORE] parameterObject called with: {}", dto);
//    }
}
