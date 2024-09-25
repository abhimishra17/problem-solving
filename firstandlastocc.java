package recursion;

public class firstandlastocc {
    public static int first=-1;
    public static int last=-1;

    public static void occurance(String str,char element,int pos){
        if(pos>=str.length()){
            System.out.println("The first ocuurance of the given element is : "+first);
            System.out.println("the last ocuurance of the element : "+last);
            return;
        }
        if(str.charAt(pos)==element){
            if(first==-1)
            first=pos;
            else
            last=pos;
        }
        occurance(str, element, pos+1);
        

    }
    public static void main(String[] args) {
        String str="abhiabhi";
        char element='a';
        int pos=0;
        occurance(str, element, pos);
        
    }
    
}
