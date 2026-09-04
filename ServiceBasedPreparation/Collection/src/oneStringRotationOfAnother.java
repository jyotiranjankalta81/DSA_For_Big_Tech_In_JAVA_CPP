public class oneStringRotationOfAnother {

    public static boolean isRotationOfAnother(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        StringBuilder s3 = new StringBuilder();
        s3=s3.append(s1);
        s3=s3.append(s1);
        return s3.toString().contains(s2);
    }

    public static boolean isRotation(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        String combined = s1 + s1;

        return combined.contains(s2);
    }

    public static void main (String[] args){
        String s1 = "ABCD";
        String s2 ="CDAB";
        System.out.println("Does s1 is the rotation of s2 " + isRotationOfAnother(s1,s2));
    }
}
