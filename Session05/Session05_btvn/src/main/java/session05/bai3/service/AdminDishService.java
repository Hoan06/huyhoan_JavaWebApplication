package session05.bai3.service;


import org.springframework.stereotype.Service;
import session05.bai2.common.Dish;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    private static List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1, "Cơm rang", 50000, true));
        dishes.add(new Dish(2, "Phở bò", 60000, false));
        dishes.add(new Dish(3, "Bún chả", 55000, true));
    }

    public Dish findById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
