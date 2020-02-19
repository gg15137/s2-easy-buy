package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;
import com.buy.util.DataSourceUtil;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdyuctCategoryimpl implements IProductCategory {
    @Override
    public List<EasybuyProductCategory> queryAllproductCategory(String parentId) {
        List<EasybuyProductCategory> productCategories = new ArrayList<EasybuyProductCategory>();
        EasybuyProductCategory productCategory = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" select * from easybuy_product_category  where 1=1  ");
            //判断parentId的值 如果为0，显示的是一级分类
            if (!"".equals(parentId)|| null!=parentId){
               parentId = "0";
               sql.append("and parentId ="+parentId);
            }
            //获取链接
            Connection conn = DataSourceUtil.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                productCategory = new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));
                productCategories.add(productCategory);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return productCategories;
    }
}
