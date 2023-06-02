package hello.advance.trace.strategy;

import hello.advance.trace.strategy.template.Callback;
import hello.advance.trace.strategy.template.TimelogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    @Test
    void callbackV1() {
        TimelogTemplate template = new TimelogTemplate();
        template.execute(() -> log.info("비즈니스 로직1 실행"));
        template.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
