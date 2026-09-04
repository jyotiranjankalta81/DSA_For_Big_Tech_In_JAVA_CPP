public class ReverseWordsInaSentence {

    public static void  reverseWords(char[] arr){
        reverse( arr,0,arr.length-1);;
        int start=0;

        for (int end =0;end<=arr.length;end++){
            if(arr.length==end || arr[end]==' '){
                //reverse current word
                reverse(arr,start,end-1);
                //start of the next word
                start = end+1;
            }
        }


    }
    public static void reverse(char[] arr,int left,int right){
        while (left<right){
            char temp = arr[left];
            arr[left]= arr[right];
            arr[right]= temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        char[] arr = "I love Java".toCharArray();

        reverseWords(arr);

        System.out.println(new String(arr));
    }
}
