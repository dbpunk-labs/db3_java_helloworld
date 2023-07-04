package org.example;


import network.db3.client.AddDocResult;
import network.db3.client.Client;
import network.db3.store.ResultSet;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;


public class Main {
    public static void main(String[] args) throws Exception {
        // from web3j
        ECKeyPair keyPair = Keys.createEcKeyPair();
        Client client = new Client("https://rollup.cloud.db3.network", "https://index.cloud.db3.network", keyPair);
        // update the nonce for the first time
         client.updateNonce();
        String db = "0x6ef32f0d8fc6bc872ffa977eb80920a0a75d0206";
        String col = "book";
        String doc = "{"
                +  "\"name\":\"The Three-Body Problem\","
                + "\"author\":\"Cixin-Liu\","
                + "\"rate\":\"4.8\""
                + "}";
        AddDocResult addDocResult = client.addDoc(db, col, doc);
        ResultSet resultSet = client.runQuery(db, col, "/[author=Cixin-Liu]");
        System.out.println(resultSet.getDocs());
    }
}