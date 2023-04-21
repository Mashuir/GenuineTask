package com.example.genuinetask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductModel {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("ProductList")
    @Expose
    private List<Product> productList;
    @SerializedName("PageInfo")
    @Expose
    private PageInfo pageInfo;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public class PageInfo {

        @SerializedName("PageNo")
        @Expose
        private Integer pageNo;
        @SerializedName("PageSize")
        @Expose
        private Integer pageSize;
        @SerializedName("PageCount")
        @Expose
        private Integer pageCount;
        @SerializedName("TotalRecordCount")
        @Expose
        private Integer totalRecordCount;

        public Integer getPageNo() {
            return pageNo;
        }

        public void setPageNo(Integer pageNo) {
            this.pageNo = pageNo;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getTotalRecordCount() {
            return totalRecordCount;
        }

        public void setTotalRecordCount(Integer totalRecordCount) {
            this.totalRecordCount = totalRecordCount;
        }

    }

    public class Product {

        @SerializedName("Id")
        @Expose
        private Integer id;
        @SerializedName("Type")
        @Expose
        private String type;
        @SerializedName("ParentCode")
        @Expose
        private Object parentCode;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Code")
        @Expose
        private String code;
        @SerializedName("Price")
        @Expose
        private Double price;
        @SerializedName("CostPrice")
        @Expose
        private Double costPrice;
        @SerializedName("UnitName")
        @Expose
        private String unitName;
        @SerializedName("CategoryName")
        @Expose
        private String categoryName;
        @SerializedName("BrandName")
        @Expose
        private String brandName;
        @SerializedName("ModelName")
        @Expose
        private String modelName;
        @SerializedName("VariantName")
        @Expose
        private String variantName;
        @SerializedName("SizeName")
        @Expose
        private String sizeName;
        @SerializedName("ColorName")
        @Expose
        private String colorName;
        @SerializedName("OldPrice")
        @Expose
        private Double oldPrice;
        @SerializedName("ImagePath")
        @Expose
        private Object imagePath;
        @SerializedName("ProductBarcode")
        @Expose
        private String productBarcode;
        @SerializedName("Description")
        @Expose
        private String description;
        @SerializedName("ChildList")
        @Expose
        private List<List<Integer>> childList;
        @SerializedName("WarehouseList")
        @Expose
        private List<Warehouse> warehouseList;
        @SerializedName("CurrentStock")
        @Expose
        private Double currentStock;
        @SerializedName("CreateDate")
        @Expose
        private String createDate;
        @SerializedName("UpdateDate")
        @Expose
        private String updateDate;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getParentCode() {
            return parentCode;
        }

        public void setParentCode(Object parentCode) {
            this.parentCode = parentCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(Double costPrice) {
            this.costPrice = costPrice;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getVariantName() {
            return variantName;
        }

        public void setVariantName(String variantName) {
            this.variantName = variantName;
        }

        public String getSizeName() {
            return sizeName;
        }

        public void setSizeName(String sizeName) {
            this.sizeName = sizeName;
        }

        public String getColorName() {
            return colorName;
        }

        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        public Double getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Double oldPrice) {
            this.oldPrice = oldPrice;
        }

        public Object getImagePath() {
            return imagePath;
        }

        public void setImagePath(Object imagePath) {
            this.imagePath = imagePath;
        }

        public String getProductBarcode() {
            return productBarcode;
        }

        public void setProductBarcode(String productBarcode) {
            this.productBarcode = productBarcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<List<Integer>> getChildList() {
            return childList;
        }

        public void setChildList(List<List<Integer>> childList) {
            this.childList = childList;
        }

        public List<Warehouse> getWarehouseList() {
            return warehouseList;
        }

        public void setWarehouseList(List<Warehouse> warehouseList) {
            this.warehouseList = warehouseList;
        }

        public Double getCurrentStock() {
            return currentStock;
        }

        public void setCurrentStock(Double currentStock) {
            this.currentStock = currentStock;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

    }

    public class Warehouse {

        @SerializedName("CostCalculatedId")
        @Expose
        private Integer costCalculatedId;
        @SerializedName("WhShortName")
        @Expose
        private String whShortName;
        @SerializedName("CurrentStock")
        @Expose
        private Double currentStock;
        @SerializedName("AverageCosting")
        @Expose
        private Double averageCosting;
        @SerializedName("CostingValue")
        @Expose
        private Double costingValue;
        @SerializedName("SalesValue")
        @Expose
        private Double salesValue;

        public Integer getCostCalculatedId() {
            return costCalculatedId;
        }

        public void setCostCalculatedId(Integer costCalculatedId) {
            this.costCalculatedId = costCalculatedId;
        }

        public String getWhShortName() {
            return whShortName;
        }

        public void setWhShortName(String whShortName) {
            this.whShortName = whShortName;
        }

        public Double getCurrentStock() {
            return currentStock;
        }

        public void setCurrentStock(Double currentStock) {
            this.currentStock = currentStock;
        }

        public Double getAverageCosting() {
            return averageCosting;
        }

        public void setAverageCosting(Double averageCosting) {
            this.averageCosting = averageCosting;
        }

        public Double getCostingValue() {
            return costingValue;
        }

        public void setCostingValue(Double costingValue) {
            this.costingValue = costingValue;
        }

        public Double getSalesValue() {
            return salesValue;
        }

        public void setSalesValue(Double salesValue) {
            this.salesValue = salesValue;
        }

    }
}
