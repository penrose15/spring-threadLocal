package hello.advance.trace.strategy;

import hello.advance.trace.strategy.strategy.ContextV1;
import hello.advance.trace.strategy.strategy.Strategy;
import hello.advance.trace.strategy.strategy.StrategyLogic1;
import hello.advance.trace.strategy.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void abstractV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 실행 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 실행 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();

    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = () -> log.info("비즈니스 로직1 실행");
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();
        log.info("strategyLogic1={}",strategyLogic1.getClass());

        Strategy strategyLogic2 = () -> log.info("비즈니스 로직2 실행");
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
        log.info("strategyLogic2={}",strategyLogic2.getClass());

    }

    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        context2.execute();

    }

}
