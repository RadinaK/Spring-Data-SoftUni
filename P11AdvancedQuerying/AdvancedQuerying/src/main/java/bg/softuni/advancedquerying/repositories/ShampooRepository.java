package bg.softuni.advancedquerying.repositories;

import bg.softuni.advancedquerying.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findByBrand(String brand);


//    List<Shampoo> findByBrandAndSize(String brand, Size size);
//
//    List<Shampoo> findBySizeOrderByIdDesc(Size parsed);
//
//    @Query("SELECT s FROM Shampoo AS s " +
//            "JOIN s.ingredients AS i " +
//            "WHERE i.name = :name")
//    List<Shampoo> findByIngredient(@Param("name") String ingredient);
//
//    @Query("SELECT s FROM Shampoo AS s " +
//            "JOIN s.ingredients AS i " +
//            "WHERE i.name IN :ingredients")
//    List<Shampoo> findByIngredients(List<String> ingredients);
//
//    List<Shampoo> findBySizeOrLabelId(Size parsed, long labelId);
//
//    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
//
//    long countByPriceLessThan(BigDecimal price);
//
//    @Query("SELECT s FROM Shampoo AS s " +
//            "WHERE s.ingredients.size < :count")
//    List<Shampoo> findByIngredientCountLessThan(int count);
}
