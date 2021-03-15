package bitcoin;

import java.time.LocalDateTime;

public class BlockChain {

    private String hash = "00000000839a8e6886ab5951d76f411475428afc90947ee320161bbf18eb6048"; // 256 bit
    private String confirmations = "669,888";
    private String timestamp; //LocalDateTime.of(2009,1,9,3,54);
    private int height = 1;         // block number
    private String miner = "unknown";
    private int numberOfTransactions = 1;
    private double difficulty = 1.0;
    private String merkel_root = "0e3e2357e806b6cdb1f70b54c3a3a17b6714ee1f0e68bebb44a74b1efd512098";
    private String version = "0x1";
    private int bits =  486_604_799;
    private String weight = "860 WU";
    private int size = 215;
    private Long nonce = 2_573_394_689L;
    private double transactionVolume = 0.00000000;
    private double blockReward = 0.00000000;
    private double feeReward = 0.00000000;

    public static void main(String[] args) {
        BlockChain bc = new BlockChain();
        System.out.println(486604799*0.000001);
    }
}
//Hash
//        00000000839a8e6886ab5951d76f411475428afc90947ee320161bbf18eb6048
//        Confirmations
//        669,888
//        Timestamp
//        2009-01-09 03:54
//        Height
//        1
//        Miner
//        Unknown
//        Number of Transactions
//        1
//        Difficulty
//        1.00
//        Merkle root
//        0e3e2357e806b6cdb1f70b54c3a3a17b6714ee1f0e68bebb44a74b1efd512098
//        Version
//        0x1
//        Bits
//        486,604,799
//        Weight
//        860 WU
//        Size
//        215 bytes
//        Nonce
//        2,573,394,689
//        Transaction Volume
//        0.00000000 BTC
//        Block Reward
//        50.00000000 BTC
//        Fee Reward
//        0.00000000 BTC