package hello.advance.trace.threadLocal;

import hello.advance.trace.threadLocal.code.FieldService;
import hello.advance.trace.threadLocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = new Runnable() {
            @Override
            public void run() {
                service.logic("userA");
            }
        };
        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread B");

        threadA.start();
        sleep(100); //동시성 문제 x
        threadB.start();

        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
