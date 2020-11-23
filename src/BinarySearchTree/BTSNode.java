/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
* @file BTSNode.java
* @description Ağacımın düğümünün bulunduğu yer.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/


//ağacımın düğümü word ve bir linkedlist bulunduruyor
public class BTSNode {
    String word;
    LinkedList list;
    BTSNode leftChild;
    BTSNode rightChild;

    public BTSNode(String word) {
        this.word = word;
        list = new LinkedList();
    }

    
}
