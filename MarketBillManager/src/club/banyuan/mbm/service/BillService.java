package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Bill;
import club.banyuan.mbm.entity.Suplier;
import club.banyuan.mbm.uti.PropUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BillService {
    private static int billId;
    private static int suplierId;
    public static final String BILL_STORE_PATH = "bill.store.path";
    public static final String SUPLIER_STORE_PATH = "suplier.store.path";
    private static List<Bill> billList;

    static {
        load();
        Optional<Bill> max = billList.stream().max(Comparator.comparing(Bill::getId));
        billId = max.map(bill -> bill.getId() + 1).orElse(1);
    }
    private static void load() {
        File file = new File(PropUtil.getProp(BILL_STORE_PATH));
        if(file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)){
                byte[] bytes = fileInputStream.readAllBytes();
                billList = JSONObject.parseArray(new String(bytes),Bill.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.err.println("用户文件不存在");
            billList = new ArrayList<>();
        }
    }
    private static void save() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PropUtil.getProp(BILL_STORE_PATH))){
            String jsonStr = JSONObject.toJSONString(billList);
            byte[] bytes = jsonStr.getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    数据描述：如果id是0，表示新增账单，如果id不是0表示修改这个id的账单，providerId关联已经添加过的供应商的id。
//    isPay=1表示已付款，0表示未付款。新增或修改账单后，需要记录新增或修改时刻的时间。
//    记录时间，使用SimpleDateFormate格式化时间字符串。
//    操作成功：重定向到bill_list.html
//    操作失败：重定向到form_post_fail.html
//    关联ID；

    public boolean CheckId (Bill bill) {
        File file = new File(PropUtil.getProp(SUPLIER_STORE_PATH));
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = fileInputStream.readAllBytes();
            List<Suplier> CheckList = JSONObject.parseArray(new String(bytes), Suplier.class);
            for (Suplier suplier : CheckList) {
                if (suplier.getId() == bill.getProviderId()) {
                    return true;
                }
            }
        }
            catch (IOException e) {
            e.printStackTrace();
        }
                    return false;
        }


    }



