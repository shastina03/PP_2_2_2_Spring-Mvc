package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao{
    private final List<Car> cars;

    {
        cars = new ArrayList<>(List.of(
                new Car("Infiniti","Q50",2021),
                new Car("Volkswagen","Passat B8",2018),
                new Car("Mazda","6",2020),
                new Car("Audi","A4",2021),
                new Car("Toyota","Camry",2017)
        ));
    }

    @Override
    public List<Car> getCars(int count) {
        count = (count == 0 || count > 5) ? 5 : count;
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
