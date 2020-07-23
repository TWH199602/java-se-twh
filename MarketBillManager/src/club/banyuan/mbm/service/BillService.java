package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.Bill;
import club.banyuan.mbm.entity.Suplier;
import club.banyuan.mbm.uti.PropUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static club.banyuan.mbm.uti.ValidationUtil.validate;

public class BillService {
    private static int billId;
    private static int providerId;
    public static final String BILL_STORE_PATH = "bill.store.path";
    public static final String SUPLIER_STORE_PATH = "suplier.store.path";
    private static List<Bill> billList;
    private static SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
//    关联ID；
    public void setBillList(List<Bill> billList) {
        BillService.billList = billList;
    }

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

//    isPay=1表示已付款，0表示未付款。新增或修改账单后，需要记录新增或修改时刻的时间。
//    记录时间，使用SimpleDateFormate格式化时间字符串。
//    操作成功：重定向到bill_list.html
//    操作失败：重定向到form_post_fail.html
//    private int id;
//    private int providerId;
//    private int money;
//    private String product;
//    private boolean isPay;

    public void addBill(Bill bill) {
        validate(bill);
        synchronized (billList) {
            bill.setId(billId++);
            bill.setProviderName(bill.getProviderName());
            bill.setProduct(bill.getProduct());
            bill.setUpDateTime(time.format(new Date()));
            bill.setIsPay(bill.getIsPay());
            billList.add(bill);
            save();

        }
    }
//    product表示按照商品名称进行模糊匹配，isPay表示按照是否付款过滤结果，
//    这两项是可选的，可以都不存在，或是只存在一项。按照条件返回符合条件的集合，
//    如果都不存在，则返回全部数据
    public String getProviderName(Bill bill) {
        try (FileInputStream fileInputStream = new FileInputStream(PropUtil.getProp(SUPLIER_STORE_PATH))){
            byte[] bytes = fileInputStream.readAllBytes();
            List<Suplier> suplierList = JSONObject.parseArray(new String(bytes),Suplier.class);
            for (Suplier suplier : suplierList) {
                if(suplier.getId() == bill.getProviderId()){
                    return suplier.getName();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Bill> findBill(String product,int isPay) {
        List<Bill> list = new ArrayList<>();
        for (Bill bill : billList) {
            if(bill.getProduct().contains(product.trim()) || product.length() == 0){
                if(isPay != -1){
                    if(bill.getIsPay() == isPay) {
                        bill.getIsPay();
                    }
                }else {
                    list.add(bill);
                }
            }
        }
        return list;
    }



//    public Bill getBillByProduct(String product){
//        for (Bill bill : billList) {
//            if(String.format(product).equals(bill.getProduct())){
//                return bill;
//            }
//        }
//        return null;
//    }
//
//    public Bill getBillByIspay(boolean isPay){
//        for (Bill bill : billList) {
//            if(bill.getIsPay() == 1){
//            return bill;
//            }
//        }
//        return null;
//    }
//    查询账单对象中id匹配的数据，返回一个账单对象的json
    public static Bill getBillById(int id) {
        for (Bill bill : billList) {
            if(id == bill.getId()) {
                return bill;
            }
        }
        return null;
    }
    public  void updateBill(Bill bill) {
        synchronized (billList) {
            Bill billById = getBillById(bill.getId());
            billById.setMoney(bill.getMoney());
            billById.setProduct(bill.getProduct());
            billById.setIsPayStr(bill.getIsPayStr());
            billById.setProviderId(bill.getProviderId());
            bill.setUpDateTime(time.format(new Date()));
        }

    }

    public List<Bill> getBillList() {
        return billList;
    }

    public List<Bill> getBillList(Bill bill) {
        if(bill.getProduct() == null || bill.getProduct().trim().length() == 0) {
            return getBillList();
        }
        List<Bill> list = new ArrayList<>();
        for (Bill bill1 : billList) {
            if(bill1.getProduct().contains(bill.getProduct().trim())){
                list.add(bill1);
            }
        }
        return list;
    }

//    查询账单对象中id匹配的数据，删除账单
    public static void deleteBillById(int id) {
        Bill billById = getBillById(id);
        billList.remove(billById);
    }
    }



