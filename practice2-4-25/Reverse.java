class Reverse{
    
    public static String reverse(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length/2);
        String right = s.substring(length/2, length);
        return reverse(right) + reverse(left);
    }
    public static void main(String[] args) {
        String str = ("To be or not to be");
        System.out.println(str);
        String[] strArray = str.split(" ");
        for(String s : strArray){
            System.out.print(reverse(s)+" ");
        }
    }
}