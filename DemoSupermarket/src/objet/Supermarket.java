/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import java.util.Vector;

/**
 * @version 1352034
 * @author Ang Tony Vincent
 */
public class Supermarket {

    /**
     * type des unités dans la carte 
     * (0 : obtacle, 1 : chemin, 2 : tournant, 3 : shopping point, 4 : checkout point ou 5 : file d'attente)
     * kiểu của các đơn vị trên bản đồ
     * (0 : vật cản, 1: đường đi, 2 : chỗ quẹo, 3 : điểm mua hàng, 4 : điểm tính tiền hoặc 5 : hàng đợi)
     */
    public int[][] types;

    /**
     * état des unités dans la carte (1 : disponible ou 0 : non-disponible)
     * tình trạng của các đơn vị (1 : đi được hoặc 0 : không đi được)
     */
    public boolean[][] status;

    /**
     * liste des clients
     */
    public Vector<Client> clients = new Vector();

    /**
     * liste des caisses
     */
    public Vector<Checkout> checkouts = new Vector();

    /**
     * liste des étagères
     */
    public Vector<Shelf> shelfs = new Vector();
    
    /**
     * entrée
     */
    public Entrance entrance;

    /**
     * le consctructeur par défault
     *
     * @param width la longueur
     * @param height la hauteur
     * @param nCheckout le nombre des caisses
     * @param nQueue la taille maximale de file d'attente
     */
    public Supermarket(int width, int height, int nCheckout, int nQueue) {
        
        // défaut constructeur de la carte
        this.types = new int[height][width];
        this.status = new boolean[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.types[i][j] = 1; // chemin
                this.status[i][j] = true; // disponible
            }
        }

        // mur en haut
        for (int i = 0; i <= 49; i++) {
            this.status[0][i] = false;
            this.types[0][i] = 0;
        }

        // mur à gauche et à droite
        for (int i = 0; i < 25; i++) {
            this.status[i][0] = false;
            this.status[i][49] = false;
            this.types[i][0] = 0;
            this.types[i][49] = 0;
        }
        
        this.entrance = new Entrance(22, 24);
        this.entrance.apply(this);
        
        // créer toutes les caisses 
        Checkout c1 = new Checkout(1, 22, true, nQueue, 0, true);
        Checkout c2 = new Checkout(8, 22, true, nQueue, 0, true);
        Checkout c3 = new Checkout(15, 22, true, nQueue, 0, true);
        Checkout c4 = new Checkout(30, 22, false, nQueue, 0, true);
        Checkout c5 = new Checkout(37, 22, false, nQueue, 0, true);
        Checkout c6 = new Checkout(44, 22, false, nQueue, 0, true);
        
        // fermer quelques caisses
        switch(nCheckout) {
            case 1:
                c6.setStatus(false);
                
            case 2:
                c2.setStatus(false);
                
            case 3:
                c5.setStatus(false);
                
            case 4:
                c3.setStatus(false);
                
            case 5:
                c4.setStatus(false);
                
            default:
                break;
        }
        
        // ajouter à la liste des caisses
        this.checkouts.add(c1);
        this.checkouts.add(c2);
        this.checkouts.add(c3);
        this.checkouts.add(c4);
        this.checkouts.add(c5);
        this.checkouts.add(c6);
        
        // changer la carte
        for(int i = 0; i < this.checkouts.size(); i++) {
            this.checkouts.elementAt(i).apply(this);
        }
        
        // créer toutes les étagères
        Shelf s1 = new Shelf(1, 18, 1);
        Shelf s2 = new Shelf(8, 18, 2);
        Shelf s3 = new Shelf(15, 18, 3);
        Shelf s4 = new Shelf(30, 18, 4);
        Shelf s5 = new Shelf(37, 18, 5);
        Shelf s6 = new Shelf(44, 18, 6);
        Shelf s7 = new Shelf(4, 11, 7);
        Shelf s8 = new Shelf(11, 11, 8);
        Shelf s9 = new Shelf(18, 11, 9);
        Shelf s10 = new Shelf(27, 11, 10);
        Shelf s11 = new Shelf(34, 11, 11);
        Shelf s12 = new Shelf(41, 11, 12);
        Shelf s13 = new Shelf(4, 4, 13);
        Shelf s14 = new Shelf(11, 4, 14);
        Shelf s15 = new Shelf(18, 4, 15);
        Shelf s16 = new Shelf(27, 4, 16);
        Shelf s17 = new Shelf(34, 4, 17);
        Shelf s18 = new Shelf(41, 4, 18);
        
        // ajouter à la liste des étagères
        this.shelfs.add(s1);
        this.shelfs.add(s2);
        this.shelfs.add(s3);
        this.shelfs.add(s4);
        this.shelfs.add(s5);
        this.shelfs.add(s6);
        this.shelfs.add(s7);
        this.shelfs.add(s8);
        this.shelfs.add(s9);
        this.shelfs.add(s10);
        this.shelfs.add(s11);
        this.shelfs.add(s12);
        this.shelfs.add(s13);
        this.shelfs.add(s14);
        this.shelfs.add(s15);
        this.shelfs.add(s16);
        this.shelfs.add(s17);
        this.shelfs.add(s18);
        
        // changer la carte
        for(int i = 0; i < this.shelfs.size(); i++) {
            this.shelfs.elementAt(i).apply(this);
        }
    }
}
