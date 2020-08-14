package 购物街原型.java;

public class Users {
//    `loginName` varchar(255) NOT NULL COMMENT '登录名',
//            `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
//            `password` varchar(255) NOT NULL COMMENT '密码',
//            `sex` int(2) DEFAULT '1' COMMENT '性别(1:男 0：女)',
//            `identityCode` varchar(60) DEFAULT NULL COMMENT '身份证号',
//            `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
//            `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
//            `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
    private int Id;
    private String loginName;
    private String userName;
    private String password;
    private int sex;
    private String identityCode;
    private String email;
    private String mobile;
    private int type;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Id=" + Id +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", identityCode='" + identityCode + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                '}';
    }
}
