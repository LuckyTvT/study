package test;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/6 10:24
 */
public class Test3 {

    public static void main(String[] args) {
        T t = new T();
        t.te();
        t.te1();
    }


//    public static String Encrypt(String sSrc, String sKey) throws Exception {
//        if (sKey == null) {
//            System.out.print("Key为空null");
//            return null;
//        }
//        // 判断Key是否为16位
//        if (sKey.length() != 16) {
//            System.out.print("Key长度不是16位");
//            return null;
//        }
//        byte[] raw = sKey.getBytes("utf-8");
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
//        IvParameterSpec iv = new IvParameterSpec(cKey.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
//        return new Base64().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
//
//
//    }
}

class T{
    public synchronized void te(){
        System.out.println(11);
    }

    public void te1(){
        synchronized(this){
            System.out.println(22);
        }
    }

}