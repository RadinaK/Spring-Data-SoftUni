package bg.softuni.advancedquerying;

import bg.softuni.advancedquerying.entities.Shampoo;
import bg.softuni.advancedquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;


    @Autowired
    public Main(ShampooService shampooService) {
        this.shampooService = shampooService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();

        for (Shampoo shampoo : this.shampooService.findByBrand(size)) {
            System.out.println(shampoo.getId());
        }

//        List<String> ingredients = new ArrayList<>();

//        while (!nextLine.isBlank()) {
//            ingredients.add(nextLine);
//
//            nextLine = scanner.nextLine();
//        }

//        for (Shampoo shampoo : this.shampooService.findWithIngredientCountLessThan(count)) {
//            System.out.println(shampoo);
//        }

//        for (Ingredient ingredient : this.ingredientService.selectByNames(ingredients)) {
//            System.out.println(ingredient);
//        }

//        System.out.println(this.shampooService.countWithPriceLowerThan(price));

//        this.ingredientService.updatePrice();
    }
}
