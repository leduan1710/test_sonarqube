package spkt.nhom16.Model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spkt.nhom16.Entity.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private Long productId;
	private String name;
	private Long quantity;
	private Long price;
	private String urlImage;
	private MultipartFile image;
	private Category category;
	private StoreModel store;
	private Boolean isEdit = false;
}
