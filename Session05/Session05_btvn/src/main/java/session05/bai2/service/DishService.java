package session05.bai2.service;

import org.springframework.stereotype.Service;
import session05.bai2.common.Dish;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    public List<Dish> getAllDishes() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish(1, "Cơm rang", 50000, true));
        list.add(new Dish(2, "Phở bò", 60000, false));
        list.add(new Dish(3, "Bún chả", 55000, true));

        return list;
    }
}
