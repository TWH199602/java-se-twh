# 作业

## 1.编写一个方法不使用 * 完成两个数相乘
    class Sum {
        public static void main(String[] args){
            int a = 10;
            int b = 10;
    int result = 0; 
    for(int i = 0; i < a; i++){
    result += b; 
    } 
    System.out.println(result);
    } 
    }

## 2.编写一个方法输入分钟时间，向控制台输出多少年，多少天
    class Calculation{
    
        public static void main(String[] args) {
            
            java.util.Scanner input = new java.util.Scanner(System.in);   //从键盘读入分钟数
            
            int div;
            int days;
            
            System.out.print("Enter minute:");
            
            int minute = input.nextInt();
            
            div = minute % 525600;
            days = div / 1440;
            
            int years = (minute-div) / 525600; 
            
                System.out.println(years);
                System.out.println(days);
        }
    }

## 3.编写一个sortArr方法
    class Sort{
        //根据布尔类型选择何种排序方式
    static void sort(int arr[], boolean isAsc) {
        if (isAsc == true)
            bubbleSort_Asc(arr); 
        if (isAsc == false)
            bubbleSort_Des(arr); 
    }
    //冒泡升序
    static void bubbleSort_Asc(int a[]) {
        int l = a.length;
        int temp = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j + 1 < l - i; j++) {
                if (a[j] > a[j + 1]){   
                temp = a[j];
                a[j] = a[j+1];           
                a[j+1] = temp;	 
                }
            }
        }
    }

    //冒泡降序
    static void bubbleSort_Des(int a[]) {
        int l = a.length;
        int temp = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j + 1 < l - i; j++) {
                if (a[j] < a[j + 1]){    
                temp = a[j];
                a[j] = a[j+1];          
                a[j+1] = temp;   
                }
            }
        }
    }

    //2.重载上述的sortArr方法，用来实现数组升序排列
    static void sort(int arr[]) {
        bubbleSort_Asc(arr);
    }

    3.编写一个main方法用来测试上述两个方法，定义一个数组，内容 
    {13,26,-3,4,54,26,37,18,69,-10}，编写一个print方法，
    使用字符串拼接的方式，将数组内容数组输出为如下格式，每5个换行

    public static void main(String[] args) {
        int[] a = {13,26,-3,4,54,26,37,18,69,-10};
        
        sort(a);
        for(int i = 0;i<a.length;i++){
            System.out.print("["+i+"]"+"="+a[i]+" ");
            if ((i+1)%5 == 0)           
                System.out.println();
        }
        sort(a,false);
        for(int i = 0;i<a.length;i++){
            System.out.print("["+i+"]"+"="+a[i]+" ");
            if ((i+1)%5 == 0)           
                System.out.println();
    }
    }
    }