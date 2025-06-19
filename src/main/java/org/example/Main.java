package org.example;

public class Main {
    public static void main(String[] args) {
        Block genesisBlock = new Block("꿍실냐옹","");

        String genesisBlockHash = genesisBlock.calculateHash();

        System.out.println(genesisBlockHash);
        System.out.println(genesisBlockHash.length());
//        System.out.println(genesisBlock.previousHash);
//        System.out.println(genesisBlock.getData());
//        System.out.println(genesisBlock.getTimeStamp());
    }
}