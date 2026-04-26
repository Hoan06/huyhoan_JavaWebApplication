package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.entity.Product;
import ra.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(
            @RequestParam(required = false) String producer,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "proName") String sortBy,
            @RequestParam(defaultValue = "asc") String orderBy,
            @RequestParam(defaultValue = "1") Integer page,
            Model model) {

        int size = 1;

        Page<Product> productPage = productService.getProductsByProducerAndPriceAndSorting(
                producer, minPrice, maxPrice, sortBy, orderBy, page, size);

        model.addAttribute("listProducts", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());

        // giữ lại filter khi submit
        model.addAttribute("producer", producer);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("orderBy", orderBy);

        return "listProduct";
    }
}