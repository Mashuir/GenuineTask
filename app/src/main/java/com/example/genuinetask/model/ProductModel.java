package com.example.genuinetask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ProductModel {

    private int Id;
    private String Type;
    private String ParentCode;
    private String Name;
    private String Code;
    private double Price;
    private double CostPrice;
    private String UnitName;
    private String CategoryName;
    private String BrandName;
    private String ModelName;
    private String VariantName;
    private String SizeName;
    private String ColorName;
    private double OldPrice;
    private String ImagePath;
    private String ProductBarcode;
    private String Description;
    private List<List<Integer>> ChildList;
    private List<Object> WarehouseList;
    private double CurrentStock;
    private String CreateDate;
    private String UpdateDate;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getParentCode() {
        return ParentCode;
    }

    public void setParentCode(String parentCode) {
        ParentCode = parentCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(double costPrice) {
        CostPrice = costPrice;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public String getVariantName() {
        return VariantName;
    }

    public void setVariantName(String variantName) {
        VariantName = variantName;
    }

    public String getSizeName() {
        return SizeName;
    }

    public void setSizeName(String sizeName) {
        SizeName = sizeName;
    }

    public String getColorName() {
        return ColorName;
    }

    public void setColorName(String colorName) {
        ColorName = colorName;
    }

    public double getOldPrice() {
        return OldPrice;
    }

    public void setOldPrice(double oldPrice) {
        OldPrice = oldPrice;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getProductBarcode() {
        return ProductBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        ProductBarcode = productBarcode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<List<Integer>> getChildList() {
        return ChildList;
    }

    public void setChildList(List<List<Integer>> childList) {
        ChildList = childList;
    }

    public List<Object> getWarehouseList() {
        return WarehouseList;
    }

    public void setWarehouseList(List<Object> warehouseList) {
        WarehouseList = warehouseList;
    }

    public double getCurrentStock() {
        return CurrentStock;
    }

    public void setCurrentStock(double currentStock) {
        CurrentStock = currentStock;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String updateDate) {
        UpdateDate = updateDate;
    }
}

