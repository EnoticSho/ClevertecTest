package store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import store.cardService.CardService;
import store.cardService.DbCardService;
import store.model.Product;
import store.model.ProductsInit;
import store.productService.DbProductService;
import store.productService.InMemoryProductService;
import store.productService.ProductService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClass {
    private CardService cardService;
    private ProductService productService;

    @BeforeEach
    public void init() {
        cardService = new DbCardService();
        productService = new DbProductService();
    }

    @Test
    public void testCard(){
        assertEquals(null, productService.getProductById(10));
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of(17, "123"),
                Arguments.of(17, "124"),
                Arguments.of(17, "125")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    public void testCardService(int expected, String str){
        assertEquals(expected, cardService.getDiscountAmountByName(str));
    }

    private static Stream<Arguments> provideArgs1() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgs1")
    public void testProductService(int id, int expected){
        assertEquals(expected, productService.getProductById(id).getId());
    }
}
