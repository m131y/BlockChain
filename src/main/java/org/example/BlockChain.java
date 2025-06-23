package org.example;

import java.util.ArrayList;

public class BlockChain {
    public static ArrayList<Block> chain = new ArrayList<>();
    public static int difficulty = 5;
    private static final long TARGET_TIME = 10_000;

    public static void initialize() {
        chain.add(new Block(new Transaction("0", "h662", 20.0), "0"));
        chain.get(0).mineBlock(difficulty);
    }

    public static void addBlock(Block newBlock) {
        long startTime = System.currentTimeMillis();

        newBlock.mineBlock(difficulty);

        long elapsed = System.currentTimeMillis() - startTime;

        if (elapsed < TARGET_TIME) {
            difficulty++;
            System.out.printf("채굴 시간: %.2f초 → 난이도 ↑ %d%n", elapsed/1000.0, difficulty);
        } else if (elapsed > TARGET_TIME) {
            difficulty = Math.max(1, difficulty - 1);
            System.out.printf("채굴 시간: %.2f초 → 난이도 ↓ %d%n", elapsed/1000.0, difficulty);
        } else {
            System.out.printf("채굴 시간: %.2f초 → 난이도 유지 %d%n", elapsed/1000.0, difficulty);
        }

        chain.add(newBlock);
    }

    public static boolean isChainValid() {                      //블록 체인 유효성 검사
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i-1);

            if (!current.hash.equals(current.calculateHash())) {    //Block에 저장된 값들로 해시를 새로돌려도 같은 값이 나와야함
                System.err.println("오류 : "+ i +" 번째 블록 해시 불일치");
                return false;
            }

            if (!current.previousHash.equals(previous.hash)) {      //이전 블록 해시와 현재 블록 previous 가 일치해야함
                System.err.println("오류 : "+ i +" 번째 블록 이전 해시 불일치");
                return false;
            }
        }
        return true;
    }
}
