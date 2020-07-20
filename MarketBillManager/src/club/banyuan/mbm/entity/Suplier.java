package club.banyuan.mbm.entity;

public class Suplier {
    private int id;
    @Validation(regex = "[^!@#$%^&*()]{3,10}", msg = "供应商名称不合法")
    private String name;
    @Validation(regex = "\\w{3,15}", msg = "密码不合法")
    private String pwd;
    private String phoneNumber;
    @Validation(regex = "1[0,9]{10}", msg = "供应商电话不合法")
    private String pwdConfirm;
    private String description;
    private int suplierType;
    // 如果userType = 0，str = 普通用户
    // 如果userType = 1，str = 经理
    private String suplierTypeStr;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhonenumber() {
        return phoneNumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdConfirm() {
        return pwdConfirm;
    }

    public void setPwdConfirm(String pwdConfirm) {
        this.pwdConfirm = pwdConfirm;
    }

    public int getSuplierType() {
        return suplierType;
    }

    public void setSuplierType(int suplierType) {
        this.suplierType = suplierType;
        if (suplierType == 0) {
            suplierTypeStr = "普通供应商";
        } else if (suplierType == 1) {
            suplierTypeStr = "供应商经理";
        }
    }

    public String getSuplierTypeStr() {
        return suplierTypeStr;
    }

    public void setSuplierTypeStr(String suplierTypeStr) {
        this.suplierTypeStr = suplierTypeStr;
    }
}
