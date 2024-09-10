package com.standard.sparta.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Aspect : module // advice + pointcut
 */
@Slf4j
@Aspect
public class AspectPractice {
    // 포인트컷들..



    /**
     * PointCut : 서비스 패키지 기반
     */
//    @Pointcut("execution(* com.standard.sparta.service..*(..))")
//    private void serviceLayer() {}

//    @Around("serviceLayer()")
//    public Object advicePackageMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 측정 시작
//        Long start = System.currentTimeMillis();
//        try {
//            Object result = joinPoint.proceed();
//            return result;
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            Long end = System.currentTimeMillis();
//            Long executionTime = end - start;
//            log.info("executionTime {}ms", executionTime);
//        }
//
//    }

    /**
     * 포인트컷 어노테이션 기반
     */
    @Pointcut("@annotation(com.standard.sparta.annotation.TrackTime)")
    private void trackTimeAnnotation(){}

    /**
     * advice : 어노테이션 범위 기반
     */
    @Around("trackTimeAnnotation()")
    public Object adviceAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        Long start = System.currentTimeMillis();
        try {
            Object result = pjp.proceed();
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            Long end = System.currentTimeMillis();
            Long executionTime = end - start;
            log.info("executionTime {}ms", executionTime);
        }
    }

    // 어드바이스들..
    /**
     * Advice : @Before
     * 메서드 실행전에 수행되는 로직을 처리할떄 사용
     */
//    @Before("serviceLayer()")
//    public void beforeMethod(){
//        log.info("::: BEFORE 실행 :::");
//    }

    /**
     * Advice : @AfterReturning
     * 메서드가 "정상적"으로 반환된후에 실행
     * 예외 발생 x
     */

//    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
//    public void afterReturning(Object result){
//        log.info("::: AFTER 실행 :::");
//    }

    /**
     * Advice : @AfterThrowing
     * 메서드 실행중 예외가 발생됐을때 실행됨
     */

//    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
//    public void afterThrowing(Throwable ex){
//        // ex <- 예외가 발생됐을때 필요한 조작
//        log.info("::: THROW 실행 :::");
//    }

    /**
     * Advice : @After
     * 메서드가 정상,예외 상관없이 항상 실행됨
     */
//    @After("serviceLayer()")
//    public void afterMethod(){
//        log.info("::: AFTER :::");
//    }

    /**
     * Advice : @Around
     * 가장 강력한 advice, 전체 흐름 제어 가능한 어드바이스
     */
//    @Around("serviceLayer()")
//    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("::: BEFORE :::");
//        try {
//            Object result = joinPoint.proceed();
//            log.info("::: AFTER RETURNING :::");
//            return result;
//        } catch (Exception e) {
//            log.info("::: AFTER TRHOWING :::");
//            throw e;
//        } finally {
//            log.info("::: AFTER :::");
//        }
//    }
}
