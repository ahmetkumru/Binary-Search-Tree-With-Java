/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
* @file BTS.java
* @description Heap yapım.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/

public class Heap {
    private HeapNode[] heap;
    private int size;

    public Heap(int capacity) {
        this.heap =new HeapNode[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        HeapNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    
    //labdan fark olarak int le işlem yapmak yerine kendim yaptığım HeapNode üzerinde işlem yapıyorum
    //bu sayede dosya adını tutabilecem
    void insert(String fileName,int piece) {
        if (size < heap.length) {
            
            //boş olan yerde yeni bir HeapNode oluşturuyorum
            heap[size] = new HeapNode(fileName, piece);
            
            int current = size++;
            //HeapNode da bulunan dosyada gecme Adetine bakıp ona göre işlem yapıyorum
            while (heap[current].counter > heap[parent(current)].counter ) {
                swap(current, parent(current));
                current = parent(current);
            }
        } else {
            System.out.println("Heap is full !");
        }
    }

    
    public int getSize(){
        return size;
    }
    
    public HeapNode[] getHeap(){
        return this.heap;
    }
    
    
    

    

}
