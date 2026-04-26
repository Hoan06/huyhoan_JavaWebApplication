package sesison15.bai3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Page<Order> getOrders(Long userId, String status, int page, String sortBy, String direction) {
        int validatedPage = (page < 0) ? 0 : page;

        List<String> allowedSortFields = Arrays.asList("createdAt", "totalPrice", "status");
        String validatedSortBy = allowedSortFields.contains(sortBy) ? sortBy : "createdAt";

        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(validatedSortBy).ascending()
                : Sort.by(validatedSortBy).descending();

        Pageable pageable = PageRequest.of(validatedPage, 10, sort);

        Page<Order> resultPage;
        if (status == null || status.equalsIgnoreCase("ALL")) {
            resultPage = orderRepository.findByUserId(userId, pageable);
        } else {
            resultPage = orderRepository.findByUserIdAndStatus(userId, status, pageable);
        }

        if (validatedPage >= resultPage.getTotalPages() && resultPage.getTotalPages() > 0) {
            pageable = PageRequest.of(resultPage.getTotalPages() - 1, 10, sort);
            return (status == null || status.equalsIgnoreCase("ALL"))
                    ? orderRepository.findByUserId(userId, pageable)
                    : orderRepository.findByUserIdAndStatus(userId, status, pageable);
        }

        return resultPage;
    }
}