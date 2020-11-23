/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and openButton the template in the editor.
 */
package BinarySearchTree;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;


/**
* @file BTS.java
* @description Ağacımın bulunduğu yer.
* @assignment 2. Proje
* @date 17.05.2020
* @author Ahmet Cemalettin Kumru & acemalettin.kumru@stu.fsm.edu.tr & 1821221010
*/

public class BTS {
    
    private BTSNode root;
    
    
    
    public void createTree(){
        
        //dosya yolus sectiriyorum
        JButton openButton = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(""));
        fileChooser.setDialogTitle("Select File Path : ");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (fileChooser.showOpenDialog(openButton) == JFileChooser.APPROVE_OPTION) {

        }
        
        
        //secilen dosya yolundaki dosyaları alıyor bu kodu internette buldum
        File dir = new File(fileChooser.getSelectedFile().getAbsolutePath());
        File[] files = dir.listFiles();
        
        
        try {
        
        //dosyaları teker teker dolaşıyorum
        FileInputStream fis = null;
         
            for (File dosya : files) {
                //okunan kelimeyi tuttugum degisken
                String readingWord = "";
                
                fis = new FileInputStream(dosya);
                
                int ascii;
                char letter;
                    
                //asci kodunu alıyorum
                while ((ascii = fis.read()) != -1) {
                    
                    //asci kodunu harfa donusturuyorum
                    letter = (char) ascii;
                    
                    //sayı veya letter ise okunan kelimeye eklettiriyorum
                    if (Character.isLetterOrDigit(letter)) {
                        readingWord += letter;
                    } else {
                        
                        //kelimem boş olmaması lazım
                        if (readingWord.equals("")) {
                            
                        }else{
                            //kelimem boş değilse kelimeyi ağaca ekliyorum
                            readingWord = readingWord.toLowerCase();  
                            this.insert(readingWord, dosya.getName());
                            readingWord = "";

                            
                        }

                    }

                }
            }

        } catch (Exception e) {
            
        }
        
    }
    
    
    public void query(String sentence){
        
        
        
        LinkedList list = new LinkedList();
        
        
        //cumleyi dolasıyorum
        for (String word : sentence.toLowerCase().split(" ")){
            
            //her kelimenin node nu ortak bir linkedliste topluyorum
            ListNode temp = search(word);
            add(list, temp);           
        }
        
        //olusturdugum toplam linkedlistle heapi olusturuyorum
        createHeap(list);
        
        
        
        
    }
    
    public void add(LinkedList list,ListNode tempNode){
        
        while(tempNode != null){
            //bastan sona giderek teker teker eklettiriyorum
            ListNode eklenecek = new ListNode(tempNode.fileName,tempNode.counter);
            list.addLast(eklenecek);
            tempNode = tempNode.nextNode;
        }
        
    }
    
    public void createHeap(LinkedList list){
        
        //boyutunu alıyorum
        Heap heap = new Heap(list.size());
        
        ListNode tempNode = list.getHead();
        //donerek teker teker ekliyorum
        while(tempNode != null){
            
            heap.insert(tempNode.fileName,tempNode.counter);
            tempNode = tempNode.nextNode;
        }
        
        //siralayip ekrana bastiriyorum
        sortAndPrint(heap);
        
        
        
        
    }
    
    
    public void sortAndPrint(Heap heap){
        
        
        //insertionSort algoritması kulandım
         for (int i = 1; i < heap.getSize(); i++) {
             
            HeapNode currentElement = heap.getHeap()[i];

            int j = i - 1;
            while (j >= 0 && currentElement.counter > heap.getHeap()[j].counter) {
                heap.getHeap()[j + 1] = heap.getHeap()[j];
                j--;
            }

            heap.getHeap()[j + 1] = currentElement;
        }
         
        //siralanmis olan heapi ekrana bastiriyorum
        for (HeapNode element : heap.getHeap()) {
            System.out.print(element.fileName+"("+element.counter+") ");
        }
        System.out.println();
    
         
         
    }
    
    
    
    
    
    // iterative insert method
    void insert(String word,String fileName) {
        
        BTSNode newWord = new BTSNode(word);
        
        
        if (isEmpty()) {//agacım bosa ilk başa ekliyor yani root'a
            newWord.list.addLast(fileName);
            root = newWord;
        } else {
            BTSNode temp = root;

            while (temp != null) {
                if (word.compareTo(temp.word) > 0) {
                    if (temp.rightChild == null) {//en saga geldiyse oraya ekliyorum
                        newWord.list.addLast(fileName);//dosya adını linkedliste ekliyorum
                        temp.rightChild = newWord;
                        return;
                    }

                    temp = temp.rightChild;
                } else if (word.compareTo(temp.word) < 0) {
                    if (temp.leftChild == null) {//en sola geldiyse oraya ekliyorum
                        newWord.list.addLast(fileName);//dosya adını linkedliste ekliyorum
                        temp.leftChild = newWord;
                        return;
                    }

                    temp = temp.leftChild;
                } else {
                    temp.list.addLast(fileName);//ayni kelimeden varsa sadece linkedlistine dosya adını ekliyorum
                    return;
                }
            }
            
            
            
            
        }
    }

    void insertRecursive(String newData) {
        root = insertRecursive(root, newData);
    }

    // recursive insert method
    private BTSNode insertRecursive(BTSNode node, String newData) {
        if (node == null) {
            return new BTSNode(newData);
        } else {
            if (newData.compareTo(node.word) > 0) {
                node.rightChild = insertRecursive(node.rightChild, newData);
                
            } else if (newData.compareTo(node.word) < 0) {
                node.leftChild = insertRecursive(node.leftChild, newData);
                
            }
            return node;
        }
    }

    // iterative search method
    //kelimeye gore ağaçta yerini bulum linkedlistin head ini getiriyor
    ListNode search(String searchData) {
        if (isEmpty()) {
            System.out.println("BinarySearchTree is empty !");
        } else {
            BTSNode temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.word) > 0) {
                    temp = temp.rightChild;
                } else if (searchData.compareTo(temp.word) < 0) {
                    temp = temp.leftChild;
                } else {
                    return temp.list.getHead();
                }
            }
        }

        return null;
    }

    
    public void print(){
        System.out.print("inorder : ");
        inorder(root);
        System.out.println();
    }
    
    void preorder() {
        System.out.print("preorder : ");
        preorder(root);
        System.out.println();
    }

    private void preorder(BTSNode node) {
        if (node != null) {
            System.out.print(node.word + " ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    private void inorder(BTSNode node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.word + " (");
            node.list.print();
            System.out.println(") ");
            inorder(node.rightChild);
        }
    }

    void postorder() {
        System.out.print("postorder : ");
        postorder(root);
        System.out.println();
    }

    private void postorder(BTSNode node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.word + " ");
        }
    }

    private boolean isEmpty() {
        return root == null;
    }

    
    

    // TODO: int sizeRecursive
    int sizeRecursive() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(BTSNode node) {
        // implement recursive method to find size
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeRecursive(node.leftChild) + sizeRecursive(node.rightChild);
        }
    }

    // TODO: int fullNodeCountRecursive (node with both left and right child)
    int fullNodeCountRecursive() {
        return fullNodeCountRecursive(root);
    }

    private int fullNodeCountRecursive(BTSNode node) {
        // implement recursive method to find full node count
        if (node == null) {
            return 0;
        } else {
            if (node.leftChild != null && node.rightChild != null) {
                return 1 + fullNodeCountRecursive(node.leftChild) + fullNodeCountRecursive(node.rightChild);
            } else {
                return 0 + fullNodeCountRecursive(node.leftChild) + fullNodeCountRecursive(node.rightChild);
            }
        }
    }
    
    
}
