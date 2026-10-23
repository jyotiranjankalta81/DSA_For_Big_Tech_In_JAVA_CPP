public class ReverseWords {

    public static void reverseWordsInaSentence(char[] chars){
        int left=0,right=chars.length-1;
        reverseAString(chars,left,right);
        for(int i=0;i<chars.length;i++){
            if(chars.length== i || chars[i]==' '){
                reverseAString(chars,left,i-1);
                left = i+1;

            }
        }

    }

    public static void reverseAString(char[] chars,int left,int right){
        while (left<right){
            char temp = chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {

        char[] arr = "I love Java".toCharArray();

        reverseWordsInaSentence(arr);

        System.out.println(new String(arr));
    }
}
