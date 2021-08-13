package br.com.exerciciosspringboot.productwebservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.exerciciosspringboot.productwebservice.repositories.CategoryRepository;
import br.com.exerciciosspringboot.productwebservice.repositories.OrderItemRepository;
import br.com.exerciciosspringboot.productwebservice.repositories.OrderRepository;
import br.com.exerciciosspringboot.productwebservice.repositories.ProductRepository;
import br.com.exerciciosspringboot.productwebservice.repositories.UserRepository;

@Configuration
@Profile("dev")
public class DevConfiguration implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) {
//		User user1 = new User("Rafael Rodrigues", "rafa@gmail.com", "123456", "999887777");
//		User user2 = new User("Joyce Melo", "joyce@gmail.com", "123456", "933336666"); 
//		
//		userRepository.saveAll(Arrays.asList(user1, user2));
//		
//		Order order1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
//		Payment payment = new Payment(Instant.parse("2019-06-20T21:53:07Z"), order1);
//		order1.setPayment(payment);
//		Order order2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
//		Order order3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
//		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
//		
//		Category category1 = new Category("Electronics");
//		Category category2 = new Category("Books");
//		Category category3 = new Category("Computers"); 
//		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
//		
//		Product product1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit.", 90.5, "");
//		product1.getCategories().add(category2);
//		Product product2 = new Product("Smart TV", "Nulla eu imperdiet purus.", 2190.0, "");
//		product2.getCategories().addAll(Arrays.asList(category1, category3));
//		Product product3 = new Product("Macbook Pro", "Nam eleifend maximus tortor.", 1250.0, "");
//		product3.getCategories().add(category3);
//		Product product4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
//		product4.getCategories().add(category3);
//		Product product5 = new Product("Rails for Dummies", "Cras fringilla ac rhoncus.", 100.99, ""); 
//		product5.getCategories().add(category2);
//		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
//	
//		OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
//		OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
//		OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
//		OrderItem orderItem4 = new OrderItem(order3, product4, 2, product4.getPrice()); 
//		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
//		order1.getOrderItems().addAll(Arrays.asList(orderItem1, orderItem2));
	}
}
