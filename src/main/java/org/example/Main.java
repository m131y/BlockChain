package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        BlockChain.initialize();

        BlockChain.addBlock(new Block(new Transaction("Alice", "Bob", 40.0), BlockChain.chain.get(BlockChain.chain.size() - 1).hash));
        BlockChain.addBlock(new Block(new Transaction("Bob","h662", 35.0), BlockChain.chain.get(BlockChain.chain.size() - 1).hash));

        //BlockChain.chain.get(2).hash = "0000000000000000000000000000000000000000000000000000000000000000";
        System.out.println("블록체인 유효성 : " + BlockChain.isChainValid());

        System.out.println(new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(BlockChain.chain));
    }
}