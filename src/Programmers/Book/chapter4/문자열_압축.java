//package Programmers.Book.chapter4;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class 문자열_압축 {
//// 이해도 없이 문제를 푸는건 병신짓이야
//    static String str = "ababcdcdababcdcd";
//
//    public static void main(String[] args) {
//
//
//
//    }
//
//    public static int solution(String s) {
//
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < s.length(); i++) {
//            int compressed = compress(s, i);
//            if (compressed < min) {
//                min = compressed;
//            }
//        }
//        return min;
//    }
//
//    public static List<String> split(String source, int length) {
//
//        List<String> tokens = new ArrayList<>();
//
//        for (int startindex = 0; startindex < source.length(); startindex += length) {
//            int endIndex = startindex + length;
//
//            if (endIndex > source.length()) {
//                endIndex = source.length();
//            }
//            tokens.add(source.substring(startindex, endIndex));
//        }
//        return tokens;
//    }
//
////    public static int compress(String source, int length) {
////        StringBuilder builder = new StringBuilder();
////
////        String last = "";
////        int count = 0;
////
////        for (String token : split(source, length)) {
////            if (token.equals(last)) {
////                count++;
////            } else {
////                if (count > 1) {
////                    builder.append(count);
////                }
////              //  builder.append(l)
////            }
////
////        }
////    }
//
//}
