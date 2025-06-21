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

    public void mineBlock(int difficulty) {     //빈칸 4개 <- \0으로 되어있음  , \0을 0으로 replace
        String target = new String(new char[difficulty]).replace('\0','0');
        do {
            nonce++;
            hash = calculateHash();
        } while(!hash.substring(0, difficulty).equals(target));
        System.out.println("블록 채굴 완료 : " + hash);
    }

}
