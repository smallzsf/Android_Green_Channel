package com.xyj.strokeaid.helper;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * @author DG
 * @date 2017/11/21
 */

public class RsaUitl {

    /**
     * 非对称加密密钥算法
     */
    public static final String RSA = "RSA";
    /**
     * 加密填充方式
     */
    public static final String ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    /**
     * 秘钥默认长度
     */
    public static final int DEFAULT_KEY_SIZE = 2048;
    /**
     * 当要加密的内容超过bufferSize，则采用partSplit进行分块加密
     */
    public static final byte[] DEFAULT_SPLIT = "#PART#".getBytes();

//    public static void test() throws Exception {
//
//
//        KeyPair keyPair=generateRSAKeyPair(DEFAULT_KEY_SIZE);
//        // 公钥
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        // 私钥
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        //原始内容
//        Log.e("MoreMenuActivity","私钥---->"+ Base64Util.encode(privateKey.getEncoded()));
//        Log.e("MoreMenuActivity","公钥---->"+ Base64Util.encode(publicKey.getEncoded()));
//        //公钥加密
//        long start=System.currentTimeMillis();
//        byte[] encryptBytes=  encryptByPublicKey(getData("18567278203"), Base64Util.decode(publickey));
//        long end=System.currentTimeMillis();
//        Log.e("MoreMenuActivity","公钥加密耗时 cost time---->"+(end-start));
//        String encryStr= Base64Util.encode(encryptBytes);
//        Log.e("MoreMenuActivity","加密后数据 --1-->"+encryStr);
//        Log.e("MoreMenuActivity","加密后数据长度 --1-->"+encryStr.length());
//        //私钥解密
//        start=System.currentTimeMillis();
//        byte[] decryptBytes=  decryptByPrivateKey(Base64Util.decode(encryStr),Base64Util.decode(privatekey));
//        String decryStr=new String(decryptBytes);
//        end=System.currentTimeMillis();
//        Log.e("MoreMenuActivity","私钥解密耗时 cost time---->"+(end-start));
//        Log.e("MoreMenuActivity","解密后数据 --1-->"+decryStr);
//    }
    /**
     * 当前秘钥支持加密的最大字节数
     */
    public static final int DEFAULT_BUFFERSIZE = (DEFAULT_KEY_SIZE / 8) - 11;
    public static String privatekey = "";
    public static String publickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhCwSbhJ/Ilvzlewj++PiknX4vpgyuYkT9m7gUDW0s7ERol/eAYvS4nX0U/6qXV8bIJrtACzJXVito46rW4h15e/mkL1bCCw29NfF2ELJrm52jw/XVyCbLby6Y7/biX2XHyAY9W0i8R7lCsDbRCGEn+z5Qf0+8rRxNysqD7+3Mbnq/xj6fqfCGIuwmP9ixLpP2YkEnjPvSD/bJMmDg8Ur9a+Tndkq8PuisjHWt6jUpVpsPWD2ZtnFvi6DdPzNtd1b5Rym3RGGXCouSZvYVjGjArS2uu32GeVdHtn8GLHrE05HSz80S3g/EeIUJ49R1Hi7mMcL6+k13IcGJnU/a4s/4QIDAQAB";
    public static String STROKE_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBQkpzZvv1q3XVnSLRa7h1hbbcLl6UdeWlBNsteLV76gFkVS1BRmqmULj/PQbuCN6UQ08MTKbqBMt4MTTyw/GCwLJB1sBZmJCSQ5jk2zw/J4YeFR6tUWDH9EMm8zvQqiLUXCQnFoBGteUI19wc7sCaevhCCArvnAe8HHu2YSUAmwIDAQAB";

    public static byte[] getData(String phone) {
        String str = "Xyj@te.C!h|" + phone + "|" + System.currentTimeMillis() / 1000;
        return str.getBytes();
    }

    /**
     * 随机生成RSA密钥对
     *
     * @param keyLength 密钥长度，范围：512～2048
     *                  一般1024
     * @return
     */
    public static KeyPair generateRSAKeyPair(int keyLength) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA);
            kpg.initialize(keyLength);
            return kpg.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用私钥进行解密
     */
    public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) throws Exception {
        // 得到私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PrivateKey keyPrivate = kf.generatePrivate(keySpec);

        // 解密数据
        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
        cp.init(Cipher.DECRYPT_MODE, keyPrivate);
        byte[] arr = cp.doFinal(encrypted);
        return arr;
    }

    /**
     * 公钥解密
     *
     * @param data      待解密数据
     * @param publicKey 密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        // 得到公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PublicKey keyPublic = kf.generatePublic(keySpec);
        // 数据解密
        Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, keyPublic);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data       待加密数据
     * @param privateKey 密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {
        // 得到私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PrivateKey keyPrivate = kf.generatePrivate(keySpec);
        // 数据加密
        Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, keyPrivate);
        return cipher.doFinal(data);
    }

    /**
     * 用公钥对字符串进行加密
     *
     * @param data 原文
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        // 得到公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);
        PublicKey keyPublic = kf.generatePublic(keySpec);
        // 加密数据
        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
        cp.init(Cipher.ENCRYPT_MODE, keyPublic);
        return cp.doFinal(data);
    }

}
