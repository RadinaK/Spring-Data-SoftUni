package bg.softuni.advancedqueries.services;

import bg.softuni.advancedqueries.entities.Shampoo;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, String size);

    List<Shampoo> findBySize(String size);

    List<Shampoo> findByIngredient(String ingredient);

    List<Shampoo> findByIngredients(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelId(String size, Long labelId);

    List<Shampoo> findWithPriceGreaterThan(String price);

    long countWithPriceLowerThan(String price);

    List<Shampoo> findWithIngredientCountLessThan(int count);
}
