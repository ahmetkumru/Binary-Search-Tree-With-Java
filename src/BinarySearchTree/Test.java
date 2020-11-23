/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;


/**
* @file BTS.java
* @description Test Sınıfım.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/
public class Test {

    public static void main(String[] args) {

        BTS bts = new BTS();
        //ağacı olusturuyorum
        bts.createTree();
        //ekrana bastırıyorum
        bts.print();
        //sorguyu yapıyorum
        bts.query("data structures");
        
    }
}
