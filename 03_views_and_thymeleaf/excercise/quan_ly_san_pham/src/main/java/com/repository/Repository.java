package com.repository;
import com.model.Product;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository {
    private static List<Product> list;
    static {
        list.add(new Product(1,"note 10", 7000000, "đồ hàn xẻng", "samsung"));
        list.add(new Product(2,"iphone 16", 90000000, "đồ tới từ tương lai", "apple"));
        list.add(new Product(3,"redmi note 12", 10000000, "đồ tàu", "xiaomi"));
        list.add(new Product(4,"oppo find n2", 12000000, "đồ tàu too", "oppo"));
    }
    public List<Product> showAll(){
        return list;
    }
    public void create(Product product){
        list.add(product);
    }
    public void edit(int index, Product product){
        list.set(index, product);
    }
    public void delete(int index){
        list.remove(index);
    }
    public Product detail(int index){
        return list.get(index);
    }
    public List<Product> search(String keyword){
        List<Product> result = new ArrayList<>();
        for (Product product : list){
            if (product.getName().matches(".*" + keyword + ".*")){
                result.add(product);
            }
        }
        return result;
    }
}
