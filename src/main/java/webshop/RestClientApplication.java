package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String serverBaseUrl = "http://localhost:8080/api/v1";
		String productURL = serverBaseUrl + "/products";
		String shoppingCartURL = serverBaseUrl + "/carts";

		System.out.println("----------- Add New Product (Test Product # 1) to Product Component -----------------------");
		// add new product
		restTemplate.postForLocation(productURL, new ProductDto(302, "Test Product # 1", 20.30, 10, "KHI-WAR-L12"));

		// get the product (Test Product # 1)
		ProductDto productDto = restTemplate.getForObject(productURL + "/{productNumber}", ProductDto.class, 302);
		System.out.println("----------- get product -----------------------");
		System.out.println(productDto);

		System.out.println("----------- Add new product (Test Product # 1) to the shopping cart -----------------------");
		// create CartLine Object
		List<CartLineDto> cartLineDtoList = new ArrayList<>();
		cartLineDtoList.add(new CartLineDto(productDto.getProductNumber(), productDto.getDescription(), productDto.getPrice(), 5));
		// add new product to shoppingCart
		restTemplate.postForLocation(shoppingCartURL, new ShoppingCartDto(1002, cartLineDtoList));

		// get the shopping cart (1002)
		ShoppingCartDto shoppingCartDto = restTemplate.getForObject(shoppingCartURL + "/{shoppingCartNumber}", ShoppingCartDto.class, 1002);
		System.out.println("----------- get shopping cart -----------------------");
		System.out.println(shoppingCartDto);
	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
