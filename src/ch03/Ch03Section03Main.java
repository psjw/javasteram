package ch03;

import ch02.model.User;
import ch03.model.Car;
import ch03.model.Sedan;
import ch03.model.Suv;
import ch03.model.Van;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Ch03Section03Main {
    public static void main(String[] args) {
        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("suv", Suv::new);
        carTypeToConstructorMap.put("van", Van::new);


        User user = new User(1, "Alicea"); //BiFunction 형태로 유저를 나타냄
        BiFunction<Integer, String, User> userCreator = User::new;
        User charlie = userCreator.apply(3, "Charlie");
        System.out.println(charlie);

        String[][] inputs = new String[][]{
                {"sedan", "Sonata", "Hyundai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sorento", "KIA"},
        };

        List<Car> cars = new ArrayList<>();
        for(int i =0; i<inputs.length;i++){
            String[] input = inputs[i];
            String carType = input[0];
            String carName = input[1];
            String carBrand = input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(carName, carBrand));
        }
        System.out.println(cars);
        for(Car car: cars){
            car.drive();
        }
    }
}
