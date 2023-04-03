package spkt.nhom16.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spkt.nhom16.Entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartItemModel {
	private Long cartItemId;
	private Integer count;
	private Product product;
	private String status;
}
