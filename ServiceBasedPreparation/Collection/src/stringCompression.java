import java.util.Locale;

public class stringCompression {

    public static String stringCompressionbyValue(String str){

        if (str == null || str.isEmpty()) {
            return str;
        }
        System.out.println("stringLength " + str.length());

        StringBuilder result = new StringBuilder();

        int count = 1;


        for (int i = 1; i < str.length(); i++) {
        System.out.println("index is " + i+ " string at the position " + str.charAt(i));

            if (str.charAt(i) == str.charAt(i - 1)) {

                count++;

            } else {

                result.append(str.charAt(i - 1));
                result.append(count);

                count = 1;
            }
        }

        System.out.println("finalStringBefore print " + result.toString());

        // Last group is not handled inside the loop
        result.append(str.charAt(str.length() - 1));
        result.append(count);

        return result.toString();

    }

    public static void main (String[] args){
        String str = "aabbbcdddefffhh";
        System.out.println("the compressed string is " + stringCompressionbyValue(str));
    }
}
