package spkt.nhom16.Model;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryModel {
	private Long categoryId;
	private String name;
	private Boolean isEdit =false;
	private MultipartFile image;

}
