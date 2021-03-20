    private static String unicode2String(String unicode) {
        StringBuilder sb = new StringBuilder();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            sb.append((char) data);

        }
        System.out.println("\u500a");
        System.out.println(sb.toString());
        return sb.toString();
    }
