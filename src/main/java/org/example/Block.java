package org.example;

public class Block {
    public String hash;
    public String previousHash;
    private String data;            //원래는 Transaction
    private long timeStamp;
    private int nonce = 0;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
    }

    public String calculateHash() {
        String input = previousHash + Long.toString(timeStamp) + data + Integer.toString(nonce);

        return StringUtil.applySha256(input);
    }

//    public String getData() {
//        return data;
//    }
//
//    public long getTimeStamp() {
//        return timeStamp;
//    }
}
