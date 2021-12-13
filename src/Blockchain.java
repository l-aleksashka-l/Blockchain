public class Blockchain {
    public static void main(String[] args){

        //calculated and showed new hashes

        Block firstBlock = new Block("First block", "0");
        System.out.println("Hash for block 1: " + firstBlock.hash);

        Block secondBlock = new Block("Second block", firstBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        Block thirdBlock = new Block("Third block", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);
    }
}
