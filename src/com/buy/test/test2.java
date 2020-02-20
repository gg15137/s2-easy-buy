package com.buy.test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProdyuctCategoryimpl;
import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCatrgoryServiceImpl;
import org.junit.Test;

import java.util.List;

public class test2 {
    @Test
    public void testProduceCategory(){
        IProductCategoryService productCategory=new ProductCatrgoryServiceImpl();
        List<EasybuyProductCategory> productCategories=productCategory.queryAllproductCategory("0");
        for (EasybuyProductCategory category:productCategories){
            System.out.println(category.getName());
        }
    }
}
