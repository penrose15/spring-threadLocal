package hello.advance.v2;

import hello.advance.helloTrace.HelloTraceV2;
import hello.advance.trace.TraceId;
import hello.advance.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) throws InterruptedException {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(status.getTraceId(),itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; //예외 다시 던져줘야 함
        }

    }

}
