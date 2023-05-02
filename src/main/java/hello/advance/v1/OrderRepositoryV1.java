package hello.advance.v1;

import hello.advance.helloTrace.HelloTraceV1;
import hello.advance.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 trace;
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
