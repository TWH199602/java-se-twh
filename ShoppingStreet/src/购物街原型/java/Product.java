package 购物街原型.java;

public class Product {
//    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
//            `name` varchar(20) NOT NULL COMMENT '名称',
//            `description` varchar(1024) DEFAULT NULL COMMENT '描述',
//            `price` float NOT NULL COMMENT '价格',
//            `stock` int(10) NOT NULL COMMENT '库存',
//            `categoryLevel1Id` int(10) DEFAULT NULL COMMENT '分类1',
//            `categoryLevel2Id` int(10) DEFAULT NULL COMMENT '分类2',
//            `categoryLevel3Id` int(10) DEFAULT NULL COMMENT '分类3',
//            `fileName` varchar(200) DEFAULT NULL COMMENT '文件名称',
//            `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1：删除 0：未删除)'
    private int id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int categoryLevel1Id;
    private int categoryLevel2Id;
    private int categoryLevel3Id;
    private String fileName;
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(int categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public int getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(int categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public int getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(int categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", categoryLevel1Id=" + categoryLevel1Id +
                ", categoryLevel2Id=" + categoryLevel2Id +
                ", categoryLevel3Id=" + categoryLevel3Id +
                ", fileName='" + fileName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
