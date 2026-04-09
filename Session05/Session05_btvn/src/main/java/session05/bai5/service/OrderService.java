package session05.bai5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import session05.bai2.common.Dish;
import session05.bai5.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Dish> getMenu() {
        return repository.findAll();
    }

    public double calculateTotal(List<Dish> dishes) {
        return dishes.stream()
                .filter(Dish::isAvailable)
                .mapToDouble(Dish::getPrice)
                .sum();
    }

    public Dish getDishById(int id) {
        return repository.findById(id);
    }
}