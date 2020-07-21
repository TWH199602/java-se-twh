package club.banyuan.mbm.entity;

public class Suplier {
    private int id;
    @Validation(regex = "[^!@#$%^&*()]{3,10}", msg = "供应商名称不合法")
    private String name;
    @Validation(regex = "1[0-9]{10}", msg = "供应商电话不合法")
    private String phone;
    private String desc;
    private String contactPerson;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
