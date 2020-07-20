package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Suplier;
import club.banyuan.mbm.uti.PropUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuplierService {
    private static int suplierId;
    public static final String SUPLIER_STORE_PATH = "suplier.store.path";
    private static List<Suplier> suplierList;

    static {
        load();
        Optional<Suplier> max = suplierList.stream().max(Comparator.comparing(Suplier::getId));
        suplierId = max.map(suplier -> suplier.getId() + 1).orElse(1);
    }

    private static void load() {
        //PropUtil.getProp 用以获取资源文件；
        File file = new File(PropUtil.getProp(SUPLIER_STORE_PATH));
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] bytes = fileInputStream.readAllBytes();
                suplierList = JSONObject.parseArray(new String(bytes), Suplier.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("用户文件不存在");
            suplierList = new ArrayList<>();
        }
    }

    private static void save() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PropUtil.getProp(SUPLIER_STORE_PATH))){
        String jsonStr = JSONObject.toJSONString(suplierList);
        byte[] bytes = jsonStr.getBytes();
        fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Suplier login(String supliername,String pwd) {
        for (Suplier suplier : suplierList) {
            if (suplier.getName().equals(supliername) && suplier.getPwd().equals(pwd)) {
                return suplier;
            }

        }
        return null;
    }

    public List<Suplier> getSuplierList() {
        return suplierList;
    }

    public void setSuplierList(List<Suplier> suplierList) {
        SuplierService.suplierList = suplierList;
    }

    public static void main(String[] args) {
        suplierList = new ArrayList<>();
        Suplier s1 = new Suplier();
        s1.setName("s1");
        s1.setPwd("123456");
        s1.setSuplierType(1);

        Suplier s2 = new Suplier();
        s2.setName("s2");
        s2.setPwd("123456");
        s2.setSuplierType(2);
        suplierList.add(s1);
        suplierList.add(s2);

        save();
    }

    }

