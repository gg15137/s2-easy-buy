package com.buy.service.product;

import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<EasybuyProductCategory> queryAllproductCategory(String parentId);
}
