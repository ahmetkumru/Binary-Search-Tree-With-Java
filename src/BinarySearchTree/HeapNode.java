/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
* @file BTS.java
* @description Heap imin node yapısı.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/

//Heapimin içinde tutulacak olan dizinin yapısı
public class HeapNode {
    //dosya adı ve gecme adetini tutuyorum
    public String fileName;
    public int counter;
    
    public HeapNode(String fileName,int counter){
        this.fileName = fileName;
        this.counter = counter;
    }
    
    
}
