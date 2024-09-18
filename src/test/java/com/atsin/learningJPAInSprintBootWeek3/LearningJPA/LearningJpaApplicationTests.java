package com.atsin.learningJPAInSprintBootWeek3.LearningJPA;

import com.atsin.learningJPAInSprintBootWeek3.LearningJPA.entities.ProductEntity;
import com.atsin.learningJPAInSprintBootWeek3.LearningJPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LearningJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);


		//Homework
		List<ProductEntity> entity = productRepository.findByPriceBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(150));
		System.out.println(entity);

		System.out.println("2--------------------");
		List<ProductEntity> entity2 = productRepository.findByTitleEndingWith("a");
		System.out.println(entity2);

		System.out.println("3--------------------");
		List<ProductEntity> entity3 = productRepository.findByQuantityOrPrice(2, 12.4);
		System.out.println(entity3);

		System.out.println("4--------------------");
		Optional<Boolean> entity4 = productRepository.existsByTitle("Mazza");
		System.out.println(entity4);

		System.out.println("5--------------------");
		List<ProductEntity> entity5 = productRepository.findAllByQuantityGreaterThan(2);
		System.out.println(entity5);

		System.out.println("6--------------------");
		List<ProductEntity> entity6 = productRepository.findAllByQuantityGreaterThanEqual(2);
		System.out.println(entity6);

		System.out.println("7--------------------");
		List<ProductEntity> entity7 = productRepository.findByQuantityIn(Arrays.asList(1, 3));
		System.out.println(entity7);

		System.out.println("8--------------------");
		List<ProductEntity> entity8 = productRepository.findByCreatedAtNull();
		System.out.println(entity8);

		System.out.println("9--------------------");
		List<ProductEntity> entity9 = productRepository.findByCreatedAtNotNull();
		System.out.println(entity9);

		System.out.println("10--------------------");
//		List<ProductEntity> entity10 = productRepository.findByQuantityIsEmpty();
//		System.out.println(entity10);
//		IsEmpty / IsNotEmpty can only be used on collection properties

		System.out.println("11--------------------");
		List<ProductEntity> entity11 = productRepository.findByTitleLike("%zza%");
		System.out.println(entity11);

		System.out.println("12--------------------");
		List<ProductEntity> entity12 = productRepository.findByTitleNotLike("Mazza");
		System.out.println(entity12);

//		System.out.println("13--------------------");
//		List<ProductEntity> entity13 = productRepository.findByTitleNotStartingWith("P");
//		System.out.println(entity13);

	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2024, 1, 1, 0, 0, 0));


//		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(12, BigDecimal.valueOf(123.45));
//		System.out.println(entities);


//		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(5, BigDecimal.valueOf(130));
//		System.out.println(entities);

		List<ProductEntity> entities = productRepository.findByTitleContaining("Nes");
		List<ProductEntity> entities2 = productRepository.findByTitleLike("%Nes%");
		System.out.println(entities);
		System.out.println(entities2);

	}


	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> entity = productRepository.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));
		entity.ifPresent(entity_ -> {
			System.out.println(entity_);
		});
	}


}
