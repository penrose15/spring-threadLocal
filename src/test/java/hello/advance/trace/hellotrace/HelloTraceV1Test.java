package hello.advance.trace.hellotrace;

import hello.advance.helloTrace.HelloTraceV1;
import hello.advance.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import javax.xml.transform.TransformerException;

public class HelloTraceV1Test {
    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }
    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }
}
