/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
* @file BTS.java
* @description LinkedList yapımın bulunduğu yer.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/

public class LinkedList {

    private ListNode head;

    void addFirst(ListNode newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }
    }

    void addFirst(String newData) {
        addFirst(new ListNode(newData));
    }

    void addLast(ListNode newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            ListNode temp = head;

            while (temp.nextNode != null) {

                if (temp.fileName.equals(newNode.fileName)) {

                    temp.counter += newNode.counter;//eğer eklenen node un isminde zaten varsa adetini güncelliyorum
                    return;
                }

                temp = temp.nextNode;
            }

            if (temp.fileName.equals(newNode.fileName)) {

                temp.counter += newNode.counter;//eğer eklenen node un isminde zaten varsa adetini güncelliyorum
                return;
            }
            //fonksiyondan çıkılmamışsa demek ki o kelime eşşsiz o yüzden ekleme yapıyorum
            temp.nextNode = newNode;
        }
    }

    void addLast(String newData) {
        addLast(new ListNode(newData));
    }
    
    //ekrana basıyorum
    void print() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.fileName + ","+ temp.counter +" -> ");
            temp = temp.nextNode;
        }

        System.out.print("null");
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.nextNode;
        }

        return count;
    }
    
    
    public ListNode getHead(){
        return this.head;
    }
    
    
}
