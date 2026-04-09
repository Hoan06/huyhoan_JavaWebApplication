package session05.bai5.repository;

import org.springframework.stereotype.Repository;
import session05.bai2.common.Dish;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private static final List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1, "Cơm rang", 50000, true));
        dishes.add(new Dish(2, "Phở bò", 60000, true));
        dishes.add(new Dish(3, "Bún chả", 55000, false));
    }

    public List<Dish> findAll() {
        return dishes;
    }

    public Dish findById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}