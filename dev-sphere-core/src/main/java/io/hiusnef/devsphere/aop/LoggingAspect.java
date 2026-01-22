package io.hiusnef.devsphere.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Order(1)
@Slf4j
public class LoggingAspect {

    private static final long SLOW_EXECUTION_THRESHOLD_MS = 500; // 0.5 second
    private static final long VERY_SLOW_EXECUTION_THRESHOLD_MS = 1000; // 1 second

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void service() {
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repository() {
    }

    @Around("restController()")
    public Object logRestControllerExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = getLogger(joinPoint);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();

        String httpMethod = "";
        String uri = "";

        if (attributes != null && attributes instanceof ServletRequestAttributes servletAttributes) {
            HttpServletRequest request = servletAttributes.getRequest();
            httpMethod = request.getMethod();
            uri = request.getRequestURI();
        }

        logger.info("REQUEST: {} {}", httpMethod, uri);

        Object result = joinPoint.proceed();
        stopWatch.stop();
        long latency = stopWatch.getTotalTimeMillis();

        logger.info("RESPONSE: {} {} ({}ms)", httpMethod, uri, latency);
        latencyNotice(latency, logger);
        return result;
    }

    private void latencyNotice(long latency, Logger logger) {
        if (latency < SLOW_EXECUTION_THRESHOLD_MS) {
            return;
        }
        logger.warn("Response in {} ms => {}", latency,
                latency < VERY_SLOW_EXECUTION_THRESHOLD_MS ? "SLOW" : "VERY SLOW");
    }

    @Around("service() || repository()")
    public Object logServiceExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = getLogger(joinPoint);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        long startTime = System.currentTimeMillis();
        logger.info("Enter: {}.{}() started", className, methodName);
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("Exit: {}.{}() completed in {}ms", className, methodName, executionTime);

        return result;
    }

    private Logger getLogger(JoinPoint joinPoint) {
        Class<?> clazz = joinPoint.getTarget().getClass();
        return LoggerFactory.getLogger(clazz);
    }
}