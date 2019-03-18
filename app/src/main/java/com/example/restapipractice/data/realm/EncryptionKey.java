package com.example.restapipractice.data.realm;

public class EncryptionKey {

    private EncryptionKey(){}

    public static byte[] generateKey(){

        byte[] key = new  byte[64];
        for(int i = 0; i < 64; i++){
            key[i] = ((Integer) i).byteValue();
        }
        return key;
    }

}
