/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
* @file BTS.java
* @description LinkedListimin düğümünün bulunduğu yer.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/
public class ListNode {
    String fileName;
    int counter = 1;
    ListNode nextNode;

    public ListNode(String fileName) {
        this.fileName = fileName;
    }
    
    public ListNode(String fileName,int counter) {
        this.fileName = fileName;
        this.counter = counter;
    }
    
}
