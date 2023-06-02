package hello.advance.trace.template;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {
    private final LogTrace logTrace;

    protected AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String message) throws InterruptedException {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);

            //logic execute
            T result = call();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call() throws InterruptedException;
}
