import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Blockchain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 6;

    public static void main(String[] args){

        //calculated and showed new hashes

        blockchain.add(new Block("First block", "0"));
        System.out.println("Trying to Mine block 1 ... ");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Second block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2 ...");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Third block", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3 ... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);

    }
    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        for(int i=1; i<blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous hashes not equal");
                return false;
            }
            if(!currentBlock.hash.equals(currentBlock.calculatedHash())){
                System.out.println("Current hashes not equal");
                return false;
            }
        }
        return true;
    }
}
