package bg.softuni.advancedquerying.repositories;

import bg.softuni.advancedquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
//    List<Ingredient> findByNameStartsWith(String name);
//
//    List<Ingredient> findByNameInOrderByPrice(List<String> names);
//
//    void deleteByName(String name);
//
//    @Query("UPDATE Ingredient AS i " +
//            "SET i.price = i.price * 1.10 ")
//    @Modifying
//    void updateAllPrice();
//
//    @Query("DELETE FROM Ingredient AS i WHERE i.name = :name")
//    @Modifying
//    void deleteByName2(String name);
}
