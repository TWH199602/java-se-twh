package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Suplier;
import club.banyuan.mbm.exception.FormPostException;
import club.banyuan.mbm.uti.PropUtil;
import club.banyuan.mbm.uti.ValidationUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public List<Suplier> getSuplierList() {
        return suplierList;
    }

    public void setSuplierList(List<Suplier> suplierList) {
        SuplierService.suplierList = suplierList;
    }
    public void addSuplier(Suplier suplier) {
        validate(suplier);
        synchronized (suplierList) {
            suplier.setId(suplierId++);
            suplierList.add(suplier);
            save();
        }
    }
    private void validate(Suplier suplier) {
        try {
            ValidationUtil.validate(suplier);
        } catch (Exception e) {
            throw new FormPostException(e.getMessage());
        }
    }
    public Suplier getSuplierById(int id) {
        for (Suplier suplier : suplierList) {
            if(id == suplier.getId()){
                return suplier;
            }
        }
        return null;
    }
    public Suplier getSuplierByDescription(String description){
        for (Suplier suplier : suplierList) {
            if(description.equals(suplier.getDesc())){
                return suplier;
            }
        }
        return null;
    }
    public void updateSuplier(Suplier suplier) {
        synchronized (suplierList) {
            Suplier suplierById = getSuplierById(suplier.getId());
            suplierById.setName(suplier.getName());
            suplierById.setContactPerson(suplier.getContactPerson());
            suplierById.setDesc(suplier.getDesc());
            suplierById.setPhone(suplier.getPhone());

        }
    }
    public  List<Suplier> getSuplierList(Suplier suplier) {
        if(suplier.getName() == null || suplier.getName().trim().length() == 0) {
            return getSuplierList();
        }
        List<Suplier> list = new ArrayList<>();
        for (Suplier suplier1 : suplierList) {
            if(suplier1.getName().contains(suplier.getName().trim())) {
                list.add(suplier1);
            }
        }
        return list;
    }

    public void deleteSuplierById(int id) {
        List<Suplier> list = new ArrayList<>();
        synchronized (suplierList) {
            for (Suplier suplier : suplierList) {
                if (suplier.getId() == id) {
                    list.add(suplier);
                }
            }
            for (Suplier suplier : list) {
                suplierList.remove(suplier);
            }
            save();
        }
    }
    }

