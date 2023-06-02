package hello.advance.trace.strategy;

import hello.advance.trace.strategy.strategy.ContextV2;
import hello.advance.trace.strategy.strategy.StrategyLogic1;
import hello.advance.trace.strategy.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    /*
    * 전략 패턴 적용
    * */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직 1실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
