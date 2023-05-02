package hello.advance.V0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId) throws InterruptedException {
        orderRepository.save(itemId);
    }

}
