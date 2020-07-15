package club.banyuan.Form.practice.Form.src;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static final String USER_STORE_PATH = "user.store.path";
    private static List<User> userList;

    static {
        load();
    }

    private static void load() {
        File file = new File(PropUtil.getProp(USER_STORE_PATH));
        if(file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)){
                byte[] bytes = fileInputStream.readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("用户文件不存在");
            userList = new ArrayList<>();
        }
    }
    private static void save(){
        try (FileInputStream fileInputStream = new FileInputStream(PropUtil.getProp(USER_STORE_PATH))){
            String jsonStr = JSONObject.toJSONString(userList);
            byte[] bytes = jsonStr.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User login(String username, String pwd) {
        for (User user : userList) {
            if (user.getName().equals(username) && user.getPwd().equals(pwd)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        userList = new ArrayList<>();
        User user = new User();
        user.setName("u1");
        user.setName("123456");
        userList.add(user);
        save();
    }
}
