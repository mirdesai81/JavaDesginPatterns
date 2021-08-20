package com.java.algorithm.educative.graph;

import java.util.LinkedList;

public class PrimMinimumSpanningTree {



        static class Edge {
            int source;
            int destination;
            int weight;

            public Edge(int source, int destination, int weight) {
                this.source = source;
                this.destination = destination;
                this.weight = weight;
            }
        }

        static class HeapNode{
            int vertex;
            int key;
        }

        static class ResultSet {
            int parent;
            int weight;
        }

        static class Graph {
            int vertices;
            LinkedList<Edge>[] adjacencylist;

            Graph(int vertices) {
                this.vertices = vertices;
                adjacencylist = new LinkedList[vertices];
                //initialize adjacency lists for all the vertices
                for (int i = 0; i <vertices ; i++) {
                    adjacencylist[i] = new LinkedList<>();
                }
            }

            public void addEdge(int source, int destination, int weight) {
                Edge edge = new Edge(source, destination, weight);
                adjacencylist[source].addFirst(edge);

                edge = new Edge(destination, source, weight);
                adjacencylist[destination].addFirst(edge); //for undirected graph
            }

            public void primMST(){

                boolean[] inHeap = new boolean[vertices];
                ResultSet[] resultSet = new ResultSet[vertices];
                //keys[] used to store the key to know whether min hea update is required
                int [] key = new int[vertices];
//          //create heapNode for all the vertices
                HeapNode [] heapNodes = new HeapNode[vertices];
                for (int i = 0; i <vertices ; i++) {
                    heapNodes[i] = new HeapNode();
                    heapNodes[i].vertex = i;
                    heapNodes[i].key = Integer.MAX_VALUE;
                    resultSet[i] = new ResultSet();
                    resultSet[i].parent = -1;
                    inHeap[i] = true;
                    key[i] = Integer.MAX_VALUE;
                }

                //decrease the key for the first index
                heapNodes[0].key = 0;

                //add all the vertices to the MinHeap
                MinHeap minHeap = new MinHeap(vertices);
                //add all the vertices to priority queue
                for (int i = 0; i <vertices ; i++) {
                    minHeap.insert(heapNodes[i]);
                }

                //while minHeap is not empty
                while(!minHeap.isEmpty()){
                    //extract the min
                    HeapNode extractedNode = minHeap.extractMin();

                    //extracted vertex
                    int extractedVertex = extractedNode.vertex;
                    inHeap[extractedVertex] = false;

                    //iterate through all the adjacent vertices
                    LinkedList<Edge> list = adjacencylist[extractedVertex];
                    for (int i = 0; i <list.size() ; i++) {
                        Edge edge = list.get(i);
                        //only if edge destination is present in heap
                        if(inHeap[edge.destination]) {
                            int destination = edge.destination;
                            int newKey = edge.weight;
                            //check if updated key < existing key, if yes, update if
                            if(key[destination]>newKey) {
                                decreaseKey(minHeap, newKey, destination);
                                //update the parent node for destination
                                resultSet[destination].parent = extractedVertex;
                                resultSet[destination].weight = newKey;
                                key[destination] = newKey;
                            }
                        }
                    }
                }
                //print mst
                printMST(resultSet);
            }

            public void decreaseKey(MinHeap minHeap, int newKey, int vertex){

                //get the index which key's needs a decrease;
                int index = minHeap.indexes[vertex];

                //get the node and update its value
                HeapNode node = minHeap.mH[index];
                node.key= newKey;
                minHeap.bubbleUp(index);
            }

            public void printMST(ResultSet[] resultSet){
                int total_min_weight = 0;
                System.out.println("Minimum Spanning Tree: ");
                for (int i = 1; i <vertices ; i++) {
                    System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                            " weight: " + resultSet[i].weight);
                    total_min_weight += resultSet[i].weight;
                }
                System.out.println("Total minimum key: " + total_min_weight);
            }
        }
        static class MinHeap{
            int capacity;
            int currentSize;
            HeapNode[] mH;
            int [] indexes; //will be used to decrease the key


            public MinHeap(int capacity) {
                this.capacity = capacity;
                mH = new HeapNode[capacity + 1];
                indexes = new int[capacity];
                mH[0] = new HeapNode();
                mH[0].key = Integer.MIN_VALUE;
                mH[0].vertex=-1;
                currentSize = 0;
            }

            public void display() {
                for (int i = 0; i <=currentSize; i++) {
                    System.out.println(" " + mH[i].vertex + "   key   " + mH[i].key);
                }
                System.out.println("________________________");
            }

            public void insert(HeapNode x) {
                currentSize++;
                int idx = currentSize;
                mH[idx] = x;
                indexes[x.vertex] = idx;
                bubbleUp(idx);
            }

            public void bubbleUp(int pos) {
                int parentIdx = pos/2;
                int currentIdx = pos;
                while (currentIdx > 0 && mH[parentIdx].key > mH[currentIdx].key) {
                    HeapNode currentNode = mH[currentIdx];
                    HeapNode parentNode = mH[parentIdx];

                    //swap the positions
                    indexes[currentNode.vertex] = parentIdx;
                    indexes[parentNode.vertex] = currentIdx;
                    swap(currentIdx,parentIdx);
                    currentIdx = parentIdx;
                    parentIdx = parentIdx/2;
                }
            }

            public HeapNode extractMin() {
                HeapNode min = mH[1];
                HeapNode lastNode = mH[currentSize];
//            update the indexes[] and move the last node to the top
                indexes[lastNode.vertex] = 1;
                mH[1] = lastNode;
                mH[currentSize] = null;
                sinkDown(1);
                currentSize--;
                return min;
            }

            public void sinkDown(int k) {
                int smallest = k;
                int leftChildIdx = 2 * k;
                int rightChildIdx = 2 * k+1;
                if (leftChildIdx < heapSize() && mH[smallest].key > mH[leftChildIdx].key) {
                    smallest = leftChildIdx;
                }
                if (rightChildIdx < heapSize() && mH[smallest].key > mH[rightChildIdx].key) {
                    smallest = rightChildIdx;
                }
                if (smallest != k) {

                    HeapNode smallestNode = mH[smallest];
                    HeapNode kNode = mH[k];

                    //swap the positions
                    indexes[smallestNode.vertex] = k;
                    indexes[kNode.vertex] = smallest;
                    swap(k, smallest);
                    sinkDown(smallest);
                }
            }

            public void swap(int a, int b) {
                HeapNode temp = mH[a];
                mH[a] = mH[b];
                mH[b] = temp;
            }

            public boolean isEmpty() {
                return currentSize == 0;
            }

            public int heapSize(){
                return currentSize;
            }
        }
        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.primMST();
        }

}
