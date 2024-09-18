package com.atsin.learningJPAInSprintBootWeek3.LearningJPA.repositories;

import com.atsin.learningJPAInSprintBootWeek3.LearningJPA.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

//    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findByPriceBetween(BigDecimal price, BigDecimal price2);

    List<ProductEntity> findByTitleEndingWith(String str);

    List<ProductEntity> findByQuantityOrPrice(int quantity, double price);

    Optional<Boolean> existsByTitle(String title);

    List<ProductEntity> findAllByQuantityGreaterThan(int quantity);

    List<ProductEntity> findAllByQuantityGreaterThanEqual(int quantity);

    List<ProductEntity> findByQuantityIn(List<Integer> list);

    List<ProductEntity> findByCreatedAtNull();

    List<ProductEntity> findByCreatedAtNotNull();

//    List<ProductEntity> findByQuantityIsEmpty();

    List<ProductEntity> findByTitleNotLike(String title);

//    List<ProductEntity> findByTitleNotStartingWith(String title);
}
