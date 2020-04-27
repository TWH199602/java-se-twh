class StringBuffer1{
    private char[] str;     //定义字符数组
    private int capacity = 10;   //定义初识容量
    private int len = 0;    //定义输入字符的长度
    
    
    public StringBuffer1(){
        this.str = new char[capacity];
    }

   
    public void append(String str){
        if((len+str.length()) > capacity){
            capacity += len+str.length();
            char[] newStr = new char[capacity];
            System.arraycopy(this.str, 0, newStr, 0, len);
            this.str = newStr; 
        }
        char[] temp = str.toCharArray();
        System.arraycopy(temp, 0, this.str, len, temp.length);
        len += temp.length;
    }

    
    public void append(char str){
        if(len == capacity){
            char[] newStr = new char[++capacity];
            System.arraycopy(this.str, 0, newStr, 0, len);
            this.str = newStr; 
        }
        this.str[len] = str;
        len++;
    }

   
    public String toString() {
        return new String(str);
    }

    
    public void clear(){
        capacity = 10;
        this.str = new char[capacity];
        len = 0;
    }

   
    public String reverse(){
        for(int i=0; i<len/2; i++){
            char temp = str[i];
            str[i] = str[len-1-i];
            str[len-1-i] = temp;
        }
        return new String(str);
    }

   
    public String reverse(int from, int to){
        for(int i=from; i<(to+from)/2; i++){
            char temp = str[i];
            str[i] = str[to-1];
            str[to-1] = temp;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        StringBuffer1 sb = new StringBuffer1();
        sb.append('s');
        sb.append("dgrwcbh");
        System.out.println(sb.toString());
        sb.reverse(2,4);
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb.toString());
        sb.reverse(2,4);
        System.out.println(sb.toString());
        sb.clear();
        sb.append('s');
        System.out.println(sb.toString());
        
    }
}
