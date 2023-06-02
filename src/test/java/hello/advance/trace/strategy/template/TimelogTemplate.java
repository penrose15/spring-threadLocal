package hello.advance.trace.strategy.template;

import hello.advance.trace.strategy.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class TimelogTemplate {
    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();

        callback.call();
        //비즈니스 로직 실행 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
