package com.java.algorithm.tree;

import java.util.*;

public class ClientsCreditInfo {
    private int offset = 0;
    private Map<String,Integer> clientToCredit = new HashMap<>();
    private NavigableMap<Integer,Set<String>> creditToClients = new TreeMap<>();

    public void insert(String clientId,int c) {
        remove(clientId);
        Set<String> clients = creditToClients.getOrDefault(c - offset, new HashSet<>());
        /*if(clients == null) {
            clients = new HashSet<>();
            creditToClients.put(c - offset,clients);
        }*/

        clients.add(clientId);
    }

    public boolean remove(String clientId) {
        Integer clientCredit = clientToCredit.get(clientId);

        // remove the clientId from creditToClients
        // if creditToClients is empty for clientCredit then remove clientCredit from creditToClients
        // remove clientId from clientToCredit
        if(clientCredit != null) {
            creditToClients.get(clientCredit).remove(clientId);

            if(creditToClients.get(clientCredit).isEmpty()) {
                creditToClients.remove(clientCredit);
            }

            clientToCredit.remove(clientId);
            return true;
        }

        return false;
    }

    public int lookup(String clientId) {
        Integer clientCredit = clientToCredit.get(clientId);
        return clientCredit == null ? -1 : clientCredit + offset;
    }

    public void addAll(int c) {
        offset += c;
    }

    public String max() {
        return creditToClients.isEmpty() ? null : creditToClients.lastEntry().getValue().iterator().next();
    }



}
