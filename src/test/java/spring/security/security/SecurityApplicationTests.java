package spring.security.security;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security.security.api.CategoriesRestController;
import spring.security.security.dto.*;
import spring.security.security.mapper.*;
import spring.security.security.model.*;
import spring.security.security.model.Laptop.Laptop;
import spring.security.security.model.Laptop.Model;
import spring.security.security.model.Laptop.Processor;
import spring.security.security.model.Laptop.VideoCard;
import spring.security.security.model.Phone.Phone;
import spring.security.security.model.Phone.PhoneProcessor;
import spring.security.security.repository.*;
import spring.security.security.service.*;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SecurityApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShoppingCart shoppingCart;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderService orderService;

	@Test
	void contextLoads() {
	}

	@Test
	void testLaptop() {
		Laptop laptop = new Laptop();
		laptop.setId(1L);
		assertEquals(1L, laptop.getId());

		Item item = new Item();
		laptop.setItem(item);
		assertEquals(item, laptop.getItem());

		Processor processor = new Processor();
		laptop.setProcessor(processor);
		assertEquals(processor, laptop.getProcessor());

		VideoCard videoCard = new VideoCard();
		laptop.setVideoCard(videoCard);
		assertEquals(videoCard, laptop.getVideoCard());

		Memory memory = new Memory();
		laptop.setMemory(memory);
		assertEquals(memory, laptop.getMemory());

		Ozu ozu = new Ozu();
		laptop.setOzu(ozu);
		assertEquals(ozu, laptop.getOzu());

		Diagonal diagonal = new Diagonal();
		laptop.setDiagonal(diagonal);
		assertEquals(diagonal, laptop.getDiagonal());
	}
//	@Test
//	public void testCreateOrderFromShoppingCart() {
//		// setup
//		Long userId = 1L;
//		User user = new User();
//		user.setId(userId);
//		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//		Item item1 = new Item();
//		item1.setId(1L);
//		Item item2 = new Item();
//		item2.setId(2L);
//		List<Item> items = Arrays.asList(item1, item2);
//		when(shoppingCart.getItems()).thenReturn(items);
//		when(shoppingCart.getItemQuantity(item1)).thenReturn(2);
//		when(shoppingCart.getItemQuantity(item2)).thenReturn(3);
//		when(shoppingCart.getTotal()).thenReturn(BigDecimal.valueOf(100));
//
//		Order order = new Order();
//		order.setId(1L);
//		when(orderRepository.save(any(Order.class))).thenReturn(order);
//
//		// execute
//		OrderDto result = orderService.createOrderFromShoppingCart(userId);
//
//		// verify
//		assertNotNull(result);
//		assertEquals(userId, result.getUser().getId());
//		assertEquals(2, result.getOrderItems().size());
//		assertEquals(BigDecimal.valueOf(100), result.getTotal());
//	}

	@Test
	void testItem() {
		Item item = new Item();
		item.setId(1L);
		assertEquals(1L, item.getId());

		item.setName("Laptop");
		assertEquals("Laptop", item.getName());

		item.setDescription("A portable computer");
		assertEquals("A portable computer", item.getDescription());

		BigDecimal price = new BigDecimal("1000.00");
		item.setPrice(price);
		assertEquals(price, item.getPrice());

		Categories categories = new Categories();
		item.setCategories(categories);
		assertEquals(categories, item.getCategories());

		Model model = new Model();
		item.setModel(model);
		assertEquals(model, item.getModel());

		item.setImage("image.jpg");
		assertEquals("image.jpg", item.getImage());

		item.setWeight(2.5);
		assertEquals(2.5, item.getWeight());

		item.setColor("Black");
		assertEquals("Black", item.getColor());
	}
	@Test
	void testPhone() {
		Phone phone = new Phone();
		phone.setId(1L);
		assertEquals(1L, phone.getId());

		Item item = new Item();
		phone.setItem(item);
		assertEquals(item, phone.getItem());

		Memory memory = new Memory();
		phone.setMemory(memory);
		assertEquals(memory, phone.getMemory());

		Ozu ozu = new Ozu();
		phone.setOzu(ozu);
		assertEquals(ozu, phone.getOzu());

		PhoneProcessor phoneProcessor = new PhoneProcessor();
		phone.setPhoneProcessor(phoneProcessor);
		assertEquals(phoneProcessor, phone.getPhoneProcessor());

		phone.setPhoto(12);
		assertEquals(12, phone.getPhoto());

		phone.setFrontPhoto(8);
		assertEquals(8, phone.getFrontPhoto());

		Diagonal diagonal = new Diagonal();
		phone.setDiagonal(diagonal);
		assertEquals(diagonal, phone.getDiagonal());

		phone.setSim(2);
		assertEquals(2, phone.getSim());

		phone.setOS("Android");
		assertEquals("Android", phone.getOS());
	}
	@Test
	void testPhoneProcessor() {
		PhoneProcessor phoneProcessor = new PhoneProcessor();
		phoneProcessor.setId(1L);
		assertEquals(1L, phoneProcessor.getId());

		phoneProcessor.setName("Snapdragon");
		assertEquals("Snapdragon", phoneProcessor.getName());
	}
	@Test
	void testModel() {
		Model model = new Model();
		model.setId(1L);
		assertEquals(1L, model.getId());

		model.setName("iPhone");
		assertEquals("iPhone", model.getName());
	}
	@Test
	void testProcessor() {
		Processor processor = new Processor();
		processor.setId(1L);
		assertEquals(1L, processor.getId());

		processor.setModel("Intel Core i7");
		assertEquals("Intel Core i7", processor.getModel());
	}
	@Test
	void testVideoCard() {
		VideoCard videoCard = new VideoCard();
		videoCard.setId(1L);
		assertEquals(1L, videoCard.getId());

		videoCard.setModel("Nvidia GeForce RTX 3080");
		assertEquals("Nvidia GeForce RTX 3080", videoCard.getModel());
	}
	@Test
	void testCategories() {
		Categories categories = new Categories();
		categories.setId(1L);
		assertEquals(1L, categories.getId());

		categories.setName("Electronics");
		assertEquals("Electronics", categories.getName());
	}
	@Test
	void testDiagonal() {
		Diagonal diagonal = new Diagonal();
		diagonal.setId(1L);
		assertEquals(1L, diagonal.getId());

		diagonal.setDiagonal(15.6);
		assertEquals(15.6, diagonal.getDiagonal());
	}
	@Test
	void testMemory() {
		Memory memory = new Memory();
		memory.setId(1L);
		assertEquals(1L, memory.getId());

		memory.setMemory(16);
		assertEquals(16, memory.getMemory());
	}
	@Test
	void testOzu() {
		Ozu ozu = new Ozu();
		ozu.setId(1L);
		assertEquals(1L, ozu.getId());

		ozu.setOzu(8);
		assertEquals(8, ozu.getOzu());
	}
	@Test
	void testPermission() {
		Permission permission = new Permission();
		permission.setId(1L);
		assertEquals(1L, permission.getId());

		permission.setRole("ROLE_ADMIN");
		assertEquals("ROLE_ADMIN", permission.getRole());
	}
	@Test
	void testOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(1L);
		assertEquals(1L, orderItem.getId());

		Item item = new Item();
		orderItem.setItem(item);
		assertEquals(item, orderItem.getItem());

		orderItem.setQuantity(2);
		assertEquals(2, orderItem.getQuantity());
	}
	@Test
	void testComment() {
		Comment comment = new Comment();
		comment.setId(1L);
		assertEquals(1L, comment.getId());

		comment.setText("Great product!");
		assertEquals("Great product!", comment.getText());

		comment.setUserN("John");
		assertEquals("John", comment.getUserN());

		Item item = new Item();
		comment.setItem(item);
		assertEquals(item, comment.getItem());

		LocalDateTime time = LocalDateTime.now();
		comment.setTime(time);
		assertEquals(time, comment.getTime());
	}
	@Test
	void testOrder() {
		Order order = new Order();
		order.setId(1L);
		assertEquals(1L, order.getId());

		List<OrderItem> orderItems = new ArrayList<>();
		order.setOrderItems(orderItems);
		assertEquals(orderItems, order.getOrderItems());

		BigDecimal total = new BigDecimal("100.00");
		order.setTotal(total);
		assertEquals(total, order.getTotal());

		LocalDateTime createdDate = LocalDateTime.now();
		order.setCreatedDate(createdDate);
		assertEquals(createdDate, order.getCreatedDate());

		User user = new User();
		order.setUser(user);
		assertEquals(user, order.getUser());

		order.setStatus(1);
		assertEquals(1, order.getStatus());
	}
	@Test
	void testCartItem() {
		Item item = new Item();
		CartItem cartItem = new CartItem(item, 2);
		assertEquals(item, cartItem.getItem());
		assertEquals(2, cartItem.getQuantity());

		cartItem.setItem(null);
		assertNull(cartItem.getItem());

		cartItem.setQuantity(0);
		assertEquals(0, cartItem.getQuantity());
	}

	@Test
	void testUser() {
		User user = new User();
		user.setId(1L);
		assertEquals(1L, user.getId());

		user.setEmail("test@example.com");
		assertEquals("test@example.com", user.getEmail());

		user.setPassword("password");
		assertEquals("password", user.getPassword());

		user.setFullName("John Doe");
		assertEquals("John Doe", user.getFullName());

		user.setPhone("1234567890");
		assertEquals("1234567890", user.getPhone());

		List<Permission> permissions = new ArrayList<>();
		user.setPermissions(permissions);
		assertEquals(permissions, user.getPermissions());

		assertTrue(user.isAccountNonExpired());
		assertTrue(user.isAccountNonLocked());
		assertTrue(user.isCredentialsNonExpired());
		assertTrue(user.isEnabled());
	}
}

class ShoppingCartTest {

	@InjectMocks
	private ShoppingCart shoppingCart;

	@Mock
	private Item item1;

	@Mock
	private Item item2;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddItem() {
		when(item1.getId()).thenReturn(1L);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item1);

		assertEquals(2, shoppingCart.getItemQuantity(item1));
	}

	@Test
	void testRemoveItem() {
		when(item1.getId()).thenReturn(1L);
		when(item2.getId()).thenReturn(2L);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item1);

		assertEquals(2, shoppingCart.getItemQuantity(item1));
		assertEquals(1, shoppingCart.getItemQuantity(item2));

		shoppingCart.removeItem(item1);

		assertEquals(1, shoppingCart.getItemQuantity(item1));
		assertEquals(1, shoppingCart.getItemQuantity(item2));
	}

	@Test
	void testGetTotal() {
		when(item1.getId()).thenReturn(1L);
		when(item1.getPrice()).thenReturn(BigDecimal.valueOf(100));
		when(item2.getId()).thenReturn(2L);
		when(item2.getPrice()).thenReturn(BigDecimal.valueOf(50));

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);

		BigDecimal expectedTotal = BigDecimal.valueOf(250);
		assertEquals(expectedTotal, shoppingCart.getTotal());
	}

	@Test
	void testClearCart() {
		when(item1.getId()).thenReturn(1L);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item1);

		assertEquals(2, shoppingCart.getItemQuantity(item1));

		shoppingCart.clearCart();

		assertEquals(0, shoppingCart.getItemQuantity(item1));
		assertEquals(BigDecimal.ZERO, shoppingCart.getTotal());
	}

	@Test
	void testRemoveItemById() {
		when(item1.getId()).thenReturn(1L);
		when(item2.getId()).thenReturn(2L);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item1);

		assertEquals(2, shoppingCart.getItemQuantity(item1));
		assertEquals(1, shoppingCart.getItemQuantity(item2));

		shoppingCart.removeItemById(1L);

		assertEquals(0, shoppingCart.getItemQuantity(item1));
		assertEquals(1, shoppingCart.getItemQuantity(item2));
	}

	@Test
	void testGetTotalQuantity() {
		when(item1.getId()).thenReturn(1L);
		when(item2.getId()).thenReturn(2L);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item1);

		assertEquals(3, shoppingCart.getTotalQuantity());
	}

	@Test
	void testGetItems() {
		when(item1.getId()).thenReturn(1L);
		when(item2.getId()).thenReturn(2L);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);

		assertEquals(2, shoppingCart.getItems().size());
	}

}

class CategoriesServiceTest {

	@Test
	void testCategoriesService() {
		CategoriesRepository categoriesRepository = mock(CategoriesRepository.class);
		CategoriesMapper categoriesMapper = mock(CategoriesMapper.class);
		CategoriesService categoriesService = new CategoriesService(categoriesRepository, categoriesMapper);

		List<Categories> categoriesList = new ArrayList<>();
		when(categoriesRepository.findAll()).thenReturn(categoriesList);

		List<CategoriesDto> categoriesDtoList = new ArrayList<>();
		when(categoriesMapper.toDtoList(categoriesList)).thenReturn(categoriesDtoList);

		assertEquals(categoriesDtoList, categoriesService.getCategories());

		CategoriesDto categoriesDto = new CategoriesDto();
		Categories categories = new Categories();
		when(categoriesMapper.toModel(categoriesDto)).thenReturn(categories);
		when(categoriesRepository.save(categories)).thenReturn(categories);
		when(categoriesMapper.toDto(categories)).thenReturn(categoriesDto);

		assertEquals(categoriesDto, categoriesService.addCategories(categoriesDto));
		assertEquals(categoriesDto, categoriesService.editCategories(categoriesDto));

		Long id = 1L;
		Optional<Categories> optionalCategories = Optional.of(categories);
		when(categoriesRepository.findById(id)).thenReturn(optionalCategories);

		assertEquals(categoriesDto, categoriesService.getCategory(id));

		doNothing().when(categoriesRepository).deleteById(id);
		categoriesService.deleteCategories(id);
	}
}

class CommentServiceTest {
	@Test
	void testCommentService() {
		CommentRepository commentRepository = mock(CommentRepository.class);
		CommentMapper commentMapper = mock(CommentMapper.class);
		CommentService commentService = new CommentService(commentRepository, commentMapper);

		Long itemId = 1L;
		List<Comment> commentList = new ArrayList<>();
		when(commentRepository.findByItemId(itemId)).thenReturn(commentList);

		List<CommentDto> commentDtoList = new ArrayList<>();
		when(commentMapper.toDtoList(commentList)).thenReturn(commentDtoList);

		assertEquals(commentDtoList, commentService.getComments(itemId));

		CommentDto commentDto = new CommentDto();
		Comment comment = new Comment();
		when(commentMapper.toModel(commentDto)).thenReturn(comment);
		when(commentRepository.save(comment)).thenReturn(comment);
		when(commentMapper.toDto(comment)).thenReturn(commentDto);

		assertEquals(commentDto, commentService.addComment(commentDto));
		assertEquals(commentDto, commentService.editComment(commentDto));

		Long id = 1L;
		Optional<Comment> optionalComment = Optional.of(comment);
		when(commentRepository.findById(id)).thenReturn(optionalComment);

		assertEquals(commentDto, commentService.getNComment(id));

		doNothing().when(commentRepository).deleteById(id);
		commentService.deleteComment(id);
	}
}

class DiagonalServiceTest {
	@Test
	void testDiagonalService() {
		DiagonalRepository diagonalRepository = mock(DiagonalRepository.class);
		DiagonalMapper diagonalMapper = mock(DiagonalMapper.class);
		DiagonalService diagonalService = new DiagonalService(diagonalRepository, diagonalMapper);

		List<Diagonal> diagonalList = new ArrayList<>();
		when(diagonalRepository.findAll()).thenReturn(diagonalList);

		List<DiagonalDto> diagonalDtoList = new ArrayList<>();
		when(diagonalMapper.toDtoList(diagonalList)).thenReturn(diagonalDtoList);

		assertEquals(diagonalDtoList, diagonalService.getDiagonals());

		DiagonalDto diagonalDto = new DiagonalDto();
		Diagonal diagonal = new Diagonal();
		when(diagonalMapper.toModel(diagonalDto)).thenReturn(diagonal);
		when(diagonalRepository.save(diagonal)).thenReturn(diagonal);
		when(diagonalMapper.toDto(diagonal)).thenReturn(diagonalDto);

		assertEquals(diagonalDto, diagonalService.addDiagonal(diagonalDto));
		assertEquals(diagonalDto, diagonalService.editDiagonal(diagonalDto));

		Long id = 1L;
		Optional<Diagonal> optionalDiagonal = Optional.of(diagonal);
		when(diagonalRepository.findById(id)).thenReturn(optionalDiagonal);

		assertEquals(diagonalDto, diagonalService.getDiagonal(id));

		doNothing().when(diagonalRepository).deleteById(id);
		diagonalService.deleteDiagonal(id);
	}
}

class ItemServiceTest {
	@Test
	void testItemService() {
		ItemRepository itemRepository = mock(ItemRepository.class);
		ItemMapper itemMapper = mock(ItemMapperImpl.class);
		CommentRepository commentRepository = mock(CommentRepository.class);
		ItemService itemService = new ItemService(itemRepository, itemMapper, commentRepository);

		List<Item> itemList = new ArrayList<>();
		when(itemRepository.findAll()).thenReturn(itemList);

		List<ItemDto> itemDtoList = new ArrayList<>();
		when(itemMapper.toDtoList(itemList)).thenReturn(itemDtoList);

		assertEquals(itemDtoList, itemService.getItems());

		Long modelId = 1L;
		when(itemRepository.findAllByModel_Id(modelId)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsModel(modelId));

		when(itemRepository.findByModel_IdOrderByPrice(modelId)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsModelsSortByPrice(modelId));

		when(itemRepository.findByModel_IdOrderByPriceDesc(modelId)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsModelsSortByPriceDesc(modelId));

		Sort sort = Sort.by("price");
		when(itemRepository.findAll(sort)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsSortByPrice());

		sort = Sort.by(Sort.Order.desc("price"));
		when(itemRepository.findAll(sort)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsSortDescPrice());

		Long id = 1L;
		Optional<Item> optionalItem = Optional.of(new Item());
		when(itemRepository.findById(id)).thenReturn(optionalItem);
		ItemDto itemDto = new ItemDto();
		when(itemMapper.toDto(optionalItem.get())).thenReturn(itemDto);
		assertEquals(itemDto, itemService.getItem(id));

		Long categoryId = 1L;
		when(itemRepository.findByCategoriesIdOrderByPrice(categoryId)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsCategoriesSortByPrice(categoryId));

		when(itemRepository.findByCategoriesIdOrderByPriceDesc(categoryId)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsCategoriesSortByPriceDesc(categoryId));

		when(itemRepository.findByCategoriesId(categoryId)).thenReturn(itemList);
		assertEquals(itemDtoList, itemService.getItemsCategories(categoryId));

		doNothing().when(commentRepository).deleteByItem_Id(id);
		doNothing().when(itemRepository).deleteById(id);
		itemService.deleteItem(id);

		Item item = new Item();
		when(itemMapper.toModel(itemDto)).thenReturn(item);
		when(itemRepository.save(item)).thenReturn(item);
		when(itemMapper.toDto(item)).thenReturn(itemDto);

		assertEquals(itemDto, itemService.addItem(itemDto));
		assertEquals(itemDto, itemService.editItemDto(itemDto));

		String query = "test";
		String[] parts = query.split(" ");

		when(
				itemRepository.findByNameContainingIgnoreCaseOrModelNameContainingIgnoreCase(
						parts[0], parts[0]
				)
		).thenReturn(
				itemList
		);

		assertEquals(
				itemDtoList,
				itemService.searchItems(query)
		);
	}
}

class LaptopServiceTest {
	@Test
	void testLaptopService() {
		LaptopRepository laptopRepository = mock(LaptopRepository.class);
		LaptopMapper laptopMapper = mock(LaptopMapper.class);
		CommentRepository commentRepository = mock(CommentRepository.class);
		LaptopService laptopService = new LaptopService(laptopRepository, laptopMapper, commentRepository);

		List<Laptop> laptopList = new ArrayList<>();
		when(laptopRepository.findAll()).thenReturn(laptopList);

		List<LaptopDto> laptopDtoList = new ArrayList<>();
		when(laptopMapper.toDtoList(laptopList)).thenReturn(laptopDtoList);

		assertEquals(laptopDtoList, laptopService.getLaptops());

		LaptopDto laptopDto = new LaptopDto();
		Laptop laptop = new Laptop();
		when(laptopMapper.toModel(laptopDto)).thenReturn(laptop);
		when(laptopRepository.save(laptop)).thenReturn(laptop);
		when(laptopMapper.toDto(laptop)).thenReturn(laptopDto);

		assertEquals(laptopDto, laptopService.addLaptop(laptopDto));
		assertEquals(laptopDto, laptopService.editLaptop(laptopDto));

		Long id = 1L;
		Optional<Laptop> optionalLaptop = Optional.of(laptop);
		when(laptopRepository.findById(id)).thenReturn(optionalLaptop);

		assertEquals(laptopDto, laptopService.getLaptop(id));

		when(laptopRepository.findByItem_Id(id)).thenReturn(laptop);
		assertEquals(laptopDto, laptopService.getLaptopByItem(id));

		doNothing().when(commentRepository).deleteByItem_Id(id);
		doNothing().when(laptopRepository).deleteById(id);
		laptopService.deleteLaptop(id);
	}
}
class MemoryServiceTest {
	@Test
	void testMemoryService() {
		MemoryRepository memoryRepository = mock(MemoryRepository.class);
		MemoryMapper memoryMapper = mock(MemoryMapper.class);
		MemoryService memoryService = new MemoryService(memoryRepository, memoryMapper);

		List<Memory> memoryList = new ArrayList<>();
		when(memoryRepository.findAll()).thenReturn(memoryList);

		List<MemoryDto> memoryDtoList = new ArrayList<>();
		when(memoryMapper.toDtoList(memoryList)).thenReturn(memoryDtoList);

		assertEquals(memoryDtoList, memoryService.getMemories());

		MemoryDto memoryDto = new MemoryDto();
		Memory memory = new Memory();
		when(memoryMapper.toModel(memoryDto)).thenReturn(memory);
		when(memoryRepository.save(memory)).thenReturn(memory);
		when(memoryMapper.toDto(memory)).thenReturn(memoryDto);

		assertEquals(memoryDto, memoryService.addMemory(memoryDto));
		assertEquals(memoryDto, memoryService.editMemory(memoryDto));

		Long id = 1L;
		Optional<Memory> optionalMemory = Optional.of(memory);
		when(memoryRepository.findById(id)).thenReturn(optionalMemory);

		assertEquals(memoryDto, memoryService.getMemory(id));

		doNothing().when(memoryRepository).deleteById(id);
		memoryService.deleteMemory(id);
	}
}

class ModelServiceTest {
	@Test
	void testModelService() {
		ModelRepository modelRepository = mock(ModelRepository.class);
		ModelMapper modelMapper = mock(ModelMapper.class);
		ModelService modelService = new ModelService(modelRepository, modelMapper);

		List<Model> modelList = new ArrayList<>();
		when(modelRepository.findAll()).thenReturn(modelList);

		List<ModelDto> modelDtoList = new ArrayList<>();
		when(modelMapper.toDtoList(modelList)).thenReturn(modelDtoList);

		assertEquals(modelDtoList, modelService.getModels());

		ModelDto modelDto = new ModelDto();
		Model model = new Model();
		when(modelMapper.toModel(modelDto)).thenReturn(model);
		when(modelRepository.save(model)).thenReturn(model);
		when(modelMapper.toDto(model)).thenReturn(modelDto);

		assertEquals(modelDto, modelService.addModel(modelDto));
		assertEquals(modelDto, modelService.editModel(modelDto));

		Long id = 1L;
		Optional<Model> optionalModel = Optional.of(model);
		when(modelRepository.findById(id)).thenReturn(optionalModel);

		assertEquals(modelDto, modelService.getModel(id));

		doNothing().when(modelRepository).deleteById(id);
		modelService.deleteModel(id);
	}
}
class PhoneServiceTest {
	@Test
	void testPhoneService() {
		PhoneRepository phoneRepository = mock(PhoneRepository.class);
		PhoneMapperImpl phoneMapper = mock(PhoneMapperImpl.class);
		CommentRepository commentRepository = mock(CommentRepository.class);
		PhoneService phoneService = new PhoneService(phoneRepository, phoneMapper, commentRepository);

		List<Phone> phoneList = new ArrayList<>();
		when(phoneRepository.findAll()).thenReturn(phoneList);

		List<PhoneDto> phoneDtoList = new ArrayList<>();
		when(phoneMapper.toDtoList(phoneList)).thenReturn(phoneDtoList);

		assertEquals(phoneDtoList, phoneService.getPhones());

		PhoneDto phoneDto = new PhoneDto();
		Phone phone = new Phone();
		when(phoneMapper.toModel(phoneDto)).thenReturn(phone);
		when(phoneRepository.save(phone)).thenReturn(phone);
		when(phoneMapper.toDto(phone)).thenReturn(phoneDto);

		assertEquals(phoneDto, phoneService.addPhone(phoneDto));
		assertEquals(phoneDto, phoneService.editPhone(phoneDto));

		Long id = 1L;
		Optional<Phone> optionalPhone = Optional.of(phone);
		when(phoneRepository.findById(id)).thenReturn(optionalPhone);

		assertEquals(phoneDto, phoneService.getPhone(id));

		when(phoneRepository.findByItem_Id(id)).thenReturn(phone);
		assertEquals(phoneDto, phoneService.getPhoneByItem(id));

		doNothing().when(commentRepository).deleteByItem_Id(id);
		doNothing().when(phoneRepository).deleteById(id);

		assertDoesNotThrow(
				() -> phoneService.deletePhone(id)
		);
	}
}
@ExtendWith(MockitoExtension.class)
class OzuServiceTest {

	@Mock
	private OzuRepository ozuRepository;

	@Mock
	private OzuMapper ozuMapper;

	@InjectMocks
	private OzuService ozuService;

	@Test
	void testGetAllOzu() {
		// Arrange
		List<Ozu> ozuList = new ArrayList<>();
		when(ozuRepository.findAll()).thenReturn(ozuList);

		List<OzuDto> ozuDtoList = new ArrayList<>();
		when(ozuMapper.toDtoList(ozuList)).thenReturn(ozuDtoList);

		// Act
		List<OzuDto> result = ozuService.getAllOzu();

		// Assert
		assertEquals(ozuDtoList, result);

		verify(ozuRepository, times(1)).findAll();
		verify(ozuMapper, times(1)).toDtoList(ozuList);
		verifyNoMoreInteractions(ozuRepository, ozuMapper);
	}

	@Test
	void testAddOzu() {
		// Arrange
		OzuDto ozuDto = new OzuDto();
		Ozu ozu = new Ozu();

		when(ozuMapper.toModel(ozuDto)).thenReturn(ozu);
		when(ozuRepository.save(ozu)).thenReturn(ozu);
		when(ozuMapper.toDto(ozu)).thenReturn(ozuDto);

		// Act
		OzuDto result = ozuService.addOzu(ozuDto);

		// Assert
		assertEquals(ozuDto, result);

		verify(ozuMapper, times(1)).toModel(ozuDto);
		verify(ozuRepository, times(1)).save(ozu);
		verify(ozuMapper, times(1)).toDto(ozu);
		verifyNoMoreInteractions(ozuRepository, ozuMapper);
	}

	@Test
	void testGetOzu() {
		// Arrange
		Long id = 1L;
		OzuDto ozuDto = new OzuDto();
		Ozu ozu = new Ozu();

		Optional<Ozu> optionalOzu = Optional.of(ozu);

		when(ozuRepository.findById(id)).thenReturn(optionalOzu);
		when(ozuMapper.toDto(ozu)).thenReturn(ozuDto);

		// Act
		OzuDto result = ozuService.getOzu(id);

		// Assert
		assertEquals(ozuDto, result);

		verify(ozuRepository, times(1)).findById(id);
		verify(ozuMapper, times(1)).toDto(ozu);
		verifyNoMoreInteractions(ozuRepository, ozuMapper);
	}

	@Test
	void testEditOzu() {
		// Arrange
		OzuDto ozuDto = new OzuDto();
		Ozu ozu = new Ozu();

		when(ozuMapper.toModel(ozuDto)).thenReturn(ozu);
		when(ozuRepository.save(ozu)).thenReturn(ozu);
		when(ozuMapper.toDto(ozu)).thenReturn(ozuDto);

		// Act
		OzuDto result = ozuService.editOzu(ozuDto);

		// Assert
		assertEquals(ozuDto, result);

		verify(ozuMapper, times(1)).toModel(ozuDto);
		verify(ozuRepository, times(1)).save(ozu);
		verify(ozuMapper, times(1)).toDto(ozu);
		verifyNoMoreInteractions(ozuRepository, ozuMapper);
	}

	@Test
	void testDeleteOzu() {
		// Arrange
		Long id = 1L;

		// Act & Assert
		assertDoesNotThrow(() -> ozuService.deleteOzu(id));

		verify(ozuRepository, times(1)).deleteById(id);
		verifyNoMoreInteractions(ozuRepository);
	}
}
@ExtendWith(MockitoExtension.class)
class PhoneProcessorServiceTest {

	@Mock
	private PhoneProcessorRepository processorRepository;

	@Mock
	private PhoneProcessorMapper phoneProcessorMapper;

	@InjectMocks
	private PhoneProcessorService phoneProcessorService;

	@Test
	void testGetProcessors() {
		// Arrange
		List<PhoneProcessor> processorList = new ArrayList<>();
		when(processorRepository.findAll()).thenReturn(processorList);

		List<PhoneProcessorDto> processorDtoList = new ArrayList<>();
		when(phoneProcessorMapper.toDtoList(processorList)).thenReturn(processorDtoList);

		// Act
		List<PhoneProcessorDto> result = phoneProcessorService.getProcessors();

		// Assert
		assertEquals(processorDtoList, result);

		verify(processorRepository, times(1)).findAll();
		verify(phoneProcessorMapper, times(1)).toDtoList(processorList);
		verifyNoMoreInteractions(processorRepository, phoneProcessorMapper);
	}

	@Test
	void testAddProcessor() {
		// Arrange
		PhoneProcessorDto processorDto = new PhoneProcessorDto();
		PhoneProcessor processor = new PhoneProcessor();

		when(phoneProcessorMapper.toModel(processorDto)).thenReturn(processor);
		when(processorRepository.save(processor)).thenReturn(processor);
		when(phoneProcessorMapper.toDto(processor)).thenReturn(processorDto);

		// Act
		PhoneProcessorDto result = phoneProcessorService.addProcessor(processorDto);

		// Assert
		assertEquals(processorDto, result);

		verify(phoneProcessorMapper, times(1)).toModel(processorDto);
		verify(processorRepository, times(1)).save(processor);
		verify(phoneProcessorMapper, times(1)).toDto(processor);
		verifyNoMoreInteractions(processorRepository, phoneProcessorMapper);
	}

	@Test
	void testGetProcessor() {
		// Arrange
		Long id = 1L;
		PhoneProcessorDto processorDto = new PhoneProcessorDto();
		PhoneProcessor processor = new PhoneProcessor();

		Optional<PhoneProcessor> optionalProcessor = Optional.of(processor);

		when(processorRepository.findById(id)).thenReturn(optionalProcessor);
		when(phoneProcessorMapper.toDto(processor)).thenReturn(processorDto);

		// Act
		PhoneProcessorDto result = phoneProcessorService.getProcessor(id);

		// Assert
		assertEquals(processorDto, result);

		verify(processorRepository, times(1)).findById(id);
		verify(phoneProcessorMapper, times(1)).toDto(processor);
		verifyNoMoreInteractions(processorRepository, phoneProcessorMapper);
	}

	@Test
	void testEditProcessor() {
		// Arrange
		PhoneProcessorDto processorDto = new PhoneProcessorDto();
		PhoneProcessor processor = new PhoneProcessor();

		when(phoneProcessorMapper.toModel(processorDto)).thenReturn(processor);
		when(processorRepository.save(processor)).thenReturn(processor);
		when(phoneProcessorMapper.toDto(processor)).thenReturn(processorDto);

		// Act
		PhoneProcessorDto result = phoneProcessorService.editProcessor(processorDto);

		// Assert
		assertEquals(processorDto, result);

		verify(phoneProcessorMapper, times(1)).toModel(processorDto);
		verify(processorRepository, times(1)).save(processor);
		verify(phoneProcessorMapper, times(1)).toDto(processor);
		verifyNoMoreInteractions(processorRepository, phoneProcessorMapper);
	}

	@Test
	void testDeleteProcessor() {
		// Arrange
		Long id = 1L;

		// Act & Assert
		assertDoesNotThrow(() -> phoneProcessorService.deleteProcessor(id));

		verify(processorRepository, times(1)).deleteById(id);
		verifyNoMoreInteractions(processorRepository);
	}
}
@ExtendWith(MockitoExtension.class)
class ProcessorServiceTest {

	@Mock
	private ProcessorRepository processorRepository;

	@Mock
	private ProcessorMapper processorMapper;

	@InjectMocks
	private ProcessorService processorService;

	@Test
	void testGetProcessors() {
		// Arrange
		List<Processor> processorList = new ArrayList<>();
		when(processorRepository.findAll()).thenReturn(processorList);

		List<ProcessorDto> processorDtoList = new ArrayList<>();
		when(processorMapper.toDtoList(processorList)).thenReturn(processorDtoList);

		// Act
		List<ProcessorDto> result = processorService.getProcessors();

		// Assert
		assertEquals(processorDtoList, result);

		verify(processorRepository, times(1)).findAll();
		verify(processorMapper, times(1)).toDtoList(processorList);
		verifyNoMoreInteractions(processorRepository, processorMapper);
	}

	@Test
	void testAddProcessor() {
		// Arrange
		ProcessorDto processorDto = new ProcessorDto();
		Processor processor = new Processor();

		when(processorMapper.toModel(processorDto)).thenReturn(processor);
		when(processorRepository.save(processor)).thenReturn(processor);
		when(processorMapper.toDto(processor)).thenReturn(processorDto);

		// Act
		ProcessorDto result = processorService.addProcessor(processorDto);

		// Assert
		assertEquals(processorDto, result);

		verify(processorMapper, times(1)).toModel(processorDto);
		verify(processorRepository, times(1)).save(processor);
		verify(processorMapper, times(1)).toDto(processor);
		verifyNoMoreInteractions(processorRepository, processorMapper);
	}

	@Test
	void testGetProcessor() {
		// Arrange
		Long id = 1L;
		ProcessorDto processorDto = new ProcessorDto();
		Processor processor = new Processor();

		Optional<Processor> optionalProcessor = Optional.of(processor);

		when(processorRepository.findById(id)).thenReturn(optionalProcessor);
		when(processorMapper.toDto(processor)).thenReturn(processorDto);

		// Act
		ProcessorDto result = processorService.getProcessor(id);

		// Assert
		assertEquals(processorDto, result);

		verify(processorRepository, times(1)).findById(id);
		verify(processorMapper, times(1)).toDto(processor);
		verifyNoMoreInteractions(processorRepository, processorMapper);
	}

	@Test
	void testEditProcessor() {
		// Arrange
		ProcessorDto processorDto = new ProcessorDto();
		Processor processor = new Processor();

		when(processorMapper.toModel(processorDto)).thenReturn(processor);
		when(processorRepository.save(processor)).thenReturn(processor);
		when(processorMapper.toDto(processor)).thenReturn(processorDto);

		// Act
		ProcessorDto result = processorService.editProcessor(processorDto);

		// Assert
		assertEquals(processorDto, result);

		verify(processorMapper, times(1)).toModel(processorDto);
		verify(processorRepository, times(1)).save(processor);
		verify(processorMapper, times(1)).toDto(processor);
		verifyNoMoreInteractions(processorRepository, processorMapper);
	}

	@Test
	void testDeleteProcessor() {
		// Arrange
		Long id = 1L;

		// Act & Assert
		assertDoesNotThrow(() -> processorService.deleteProcessor(id));

		verify(processorRepository, times(1)).deleteById(id);
		verifyNoMoreInteractions(processorRepository);
	}
}
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	private UserService userService;

	@Test
	void testLoadUserByUsernameExistingUser() {
		// Arrange
		String username = "test@example.com";
		User user = new User();
		user.setEmail(username);

		// Stubbing the findByEmail method of userRepository to return the mock User
		when(userRepository.findByEmail(username)).thenReturn(user);

		// Act
		UserDetails userDetails = userService.loadUserByUsername(username);

		// Assert
		assertNotNull(userDetails);
		assertEquals(user.getEmail(), userDetails.getUsername());
	}

	@Test
	void testLoadUserByUsernameNonExistingUser() {
		// Arrange
		String username = "nonexistent@example.com";

		// Stubbing the findByEmail method of userRepository to return null
		when(userRepository.findByEmail(username)).thenReturn(null);

		// Act & Assert
		assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));
	}

	@Test
	void testAddUser() {
		// Arrange
		String email = "newuser@example.com";
		String password = "password123";
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		// Stubbing the findByEmail method of userRepository to return null
		when(userRepository.findByEmail(email)).thenReturn(null);

		// Stubbing the encode method of passwordEncoder to return the encoded password
		String encodedPassword = "encodedPassword123";
		when(passwordEncoder.encode(password)).thenReturn(encodedPassword);

		// Stubbing the save method of userRepository to return the mock User
		when(userRepository.save(user)).thenReturn(user);

		// Act
		User addedUser = userService.addUser(user);

		// Assert
		assertNotNull(addedUser);
		assertEquals(encodedPassword, addedUser.getPassword());
	}

	@Test
	void testAddUserExistingUser() {
		// Arrange
		String email = "existinguser@example.com";
		String password = "password123";
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		// Stubbing the findByEmail method of userRepository to return the mock User
		when(userRepository.findByEmail(email)).thenReturn(user);

		// Act
		User addedUser = userService.addUser(user);

		// Assert
		assertNull(addedUser);
	}



	@Test
	void testGetCurrentSessionUserAuthenticated() {
		// Arrange
		User user = new User();
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null);

		// Stubbing the getContext method of SecurityContextHolder to return the mock authentication
		SecurityContextHolder.setContext(new SecurityContextImpl(authentication));

		// Act
		User currentUser = userService.getCurrentSessionUser();

		// Assert
		assertNotNull(currentUser);
		assertEquals(user, currentUser);
	}

	@Test
	void testGetCurrentSessionUserAnonymous() {
		// Arrange
		Authentication authentication = new AnonymousAuthenticationToken("key", "anonymousUser", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));

		// Stubbing the getContext method of SecurityContextHolder to return the mock authentication
		SecurityContextHolder.setContext(new SecurityContextImpl(authentication));

		// Act
		User currentUser = userService.getCurrentSessionUser();

		// Assert
		assertNull(currentUser);
	}
}
@ExtendWith(MockitoExtension.class)
class VideoCardServiceTest {

	@Mock
	private VideoCardRepository videoCardRepository;

	@Mock
	private VideoCardMapper videoCardMapper;

	@InjectMocks
	private VideoCardService videoCardService;

	@Test
	void testGetVideoCards() {
		// Arrange
		List<VideoCard> videoCards = new ArrayList<>();
		when(videoCardRepository.findAll()).thenReturn(videoCards);

		List<VideoCardDto> videoCardDtos = new ArrayList<>();
		when(videoCardMapper.toDtoList(videoCards)).thenReturn(videoCardDtos);

		// Act
		List<VideoCardDto> result = videoCardService.getVideoCards();

		// Assert
		assertNotNull(result);
		assertEquals(videoCardDtos, result);
	}

	@Test
	void testAddVideoCard() {
		// Arrange
		VideoCardDto videoCardDto = new VideoCardDto();
		VideoCard videoCard = new VideoCard();
		when(videoCardMapper.toModel(videoCardDto)).thenReturn(videoCard);

		when(videoCardRepository.save(videoCard)).thenReturn(videoCard);

		VideoCardDto savedVideoCardDto = new VideoCardDto();
		when(videoCardMapper.toDto(videoCard)).thenReturn(savedVideoCardDto);

		// Act
		VideoCardDto result = videoCardService.addVideoCard(videoCardDto);

		// Assert
		assertNotNull(result);
		assertEquals(savedVideoCardDto, result);
	}

	@Test
	void testGetVideoCardExistingId() {
		// Arrange
		Long id = 1L;
		VideoCard videoCard = new VideoCard();
		when(videoCardRepository.findById(id)).thenReturn(Optional.of(videoCard));

		VideoCardDto videoCardDto = new VideoCardDto();
		when(videoCardMapper.toDto(videoCard)).thenReturn(videoCardDto);

		// Act
		VideoCardDto result = videoCardService.getVideoCard(id);

		// Assert
		assertNotNull(result);
		assertEquals(videoCardDto, result);
	}

	@Test
	void testGetVideoCardNonExistingId() {
		// Arrange
		Long id = 1L;
		when(videoCardRepository.findById(id)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(NoSuchElementException.class, () -> videoCardService.getVideoCard(id));
	}

	@Test
	void testEditVideoCard() {
		// Arrange
		VideoCardDto videoCardDto = new VideoCardDto();
		VideoCard videoCard = new VideoCard();
		when(videoCardMapper.toModel(videoCardDto)).thenReturn(videoCard);

		when(videoCardRepository.save(videoCard)).thenReturn(videoCard);

		VideoCardDto savedVideoCardDto = new VideoCardDto();
		when(videoCardMapper.toDto(videoCard)).thenReturn(savedVideoCardDto);

		// Act
		VideoCardDto result = videoCardService.editVideoCard(videoCardDto);

		// Assert
		assertNotNull(result);
		assertEquals(savedVideoCardDto, result);
	}

	@Test
	void testDeleteVideoCard() {
		// Arrange
		Long id = 1L;

		// Act
		assertDoesNotThrow(() -> videoCardService.deleteVideoCard(id));

		// Assert
		verify(videoCardRepository, times(1)).deleteById(id);
	}
}
