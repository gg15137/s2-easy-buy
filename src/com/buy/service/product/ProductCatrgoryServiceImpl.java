package com.buy.service.product;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProdyuctCategoryimpl;
import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public class ProductCatrgoryServiceImpl implements IProductCategoryService {
    private IProductCategory productCategory = new ProdyuctCategoryimpl();
    @Override
    public List<EasybuyProductCategory> queryAllproductCategory(String parentId) {
        parentId = "0";
        return productCategory.queryAllproductCategory(parentId);
    }
}
