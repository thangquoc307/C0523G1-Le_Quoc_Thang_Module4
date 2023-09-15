package com.repository;
import com.model.Product;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    private static List<Product> list = new ArrayList<>();
    static {
        list.add(new Product(1,"sản phẩm 1", 10000, "nhìn như sản phẩm 2", "Bà Hồng"));
        list.add(new Product(2,"sản phẩm 2", 15000, "nhìn như sản phẩm 3", "Hàng xóm bà Hồng"));
        list.add(new Product(3,"sản phẩm 3", 20000, "nhìn như sản phẩm 4", "Hàng xóm của hàng xóm bà Hồng"));
        list.add(new Product(4,"sản phẩm 4", 25000, "nhìn như sản phẩm 1", "Hàng xóm của hàng xóm của hàng xóm bà Hồng"));
    }
    @Override
    public List<Product> getAll() {
        return list;
    }

    @Override
    public void create(Product product) {
        list.add(product);
    }

    @Override
    public void edit(int index, Product newProduct) {
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == index){
                list.set(i, newProduct);
            }
        }
    }

    @Override
    public void delete(int index) {
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == index){
                list.remove(i);
            }
        }
    }

    @Override
    public Product detail(int index) {
        for (Product product : list){
            if (product.getId() == index){
                return product;
            }
        }
        return new Product();
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> listSearch = new ArrayList<>();
        for(Product product : list){
            if (product.getName().contains(keyword)){
                listSearch.add(product);
            }
        }
        return listSearch;
    }
}
