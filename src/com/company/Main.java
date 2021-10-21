package com.company;


public class Main {
    public static void main(String[] args) {
        String comment = "public class Main {\n" +
                "    static void splitString(String str1, int n) {\n" +
                "    //Comment here    \n" +
                "    if(str1.length() % n != 0){\n" +
                "            System.out.println(\"It can`t be divided into equal parts.\");\n" +
                "            return;\n" +
                "        }\n" +
                "/*\n" +
                "    block comment here\n" +
                " */" +
                "\n" +
                "        int begin = 0;\n" +
                "        int end = str1.length() ;\n" +
                "\n      " +
                "        //One more comment here \n"  +
                "        for (int i = 0; i < n; i++) {\n" +
                "            System.out.println(str1.substring(begin, end ));\n" +
                "            begin = begin + n;\n" +
                "            end = end + n;\n" +
                "        }\n" +
                "    }";

        System.out.println(javaCommentParser(comment));
    }


    private static String javaCommentParser(String javaCode) {
        String str = "";

        for (int x = 0; x < javaCode.length(); x++) {
            if(x+2 > javaCode.length()) break;


            javaCode = removeCommentChars(javaCode, x,"//","\n");
            javaCode = removeCommentChars(javaCode, x,"/*","*/");

        }

        return javaCode;
    }

    private static String removeCommentChars(String javaCode, int x, String initChar, String finalChar) {
        if (javaCode.startsWith(initChar, x)) {
            String comment = javaCode.substring(x);
            for (int j = 0; j < comment.length(); j++) {
                if (comment.startsWith(finalChar, j)) {
                    String remove = comment.substring(0,j+2);
                    javaCode = javaCode.replace(remove,"");
                    break;
                }
            }

        }
        return javaCode;
    }
}
