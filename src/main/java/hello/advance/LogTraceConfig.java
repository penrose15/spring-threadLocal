package hello.advance;

import hello.advance.trace.logtrace.FieldLogTrace;
import hello.advance.trace.logtrace.LogTrace;
import hello.advance.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
