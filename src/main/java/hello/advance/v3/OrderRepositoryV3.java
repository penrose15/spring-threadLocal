package hello.advance.v3;

import hello.advance.helloTrace.HelloTraceV2;
import hello.advance.trace.TraceId;
import hello.advance.trace.TraceStatus;
import hello.advance.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;
    public void save(String itemId) throws InterruptedException {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; //예외 다시 던져줘야 함
        }
    }
    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
