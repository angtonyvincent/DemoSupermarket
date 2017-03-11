/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import java.awt.Point;

/**
 * @version 1352034
 * @author Ang Tony Vincent
 */
public class Checkout {

    /**
     * position
     * vị trí
     */
    private Point position = new Point();

    /**
     * style (vrai : file d'attente à droite ou faux : celle à gauche) 
     * kiểu (true : hàng đợi bên phải hoặc false : hàng đợi bên trái)
     */
    private boolean style;

    /**
     * taille maximale des files d'attente (de 1 à 6) 
     * kích thước tối đa của hàng đợi (từ 1 đến 6)
     */
    private int queue;

    /**
     * nombre des clients à la caisse 
     * số lương khách hàng đang tính tiền
     */
    private int client;
    
    /**
     * somme des temps perdus à la caisse pour payer
     * tổng thời gian tính tiền tại quầy
     */
    private int time;
    
    /**
     * état (vrai : activé ou faux : fermé)
     * tình trạng (hoạt động hoặc đóng)
     */
    private boolean status;
    
    /**
     * entrée de la caisse pour payer
     * nơi vào quầy để thanh toán
     */
    private Point entrance = new Point();
    
    /**
     * entrée de la caisse pour sortir
     * nơi vào quầy để đi ra
     */
    private Point entrance0 = new Point();
    
    /**
     * position pour payer
     * nơi tính tiền
     */
    private Point checkout = new Point();

    /**
     * @return the queue
     */
    public int getQueue() {
        return queue;
    }

    /**
     * @param queue the queue to set
     */
    public void setQueue(int queue) {
        this.queue = queue;
    }

    /**
     * @return the client
     */
    public int getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(int client) {
        this.client = client;
    }

    /**
     * le constructeur par défault
     *
     * @param x la position x
     * @param y la position y
     * @param s le style
     * @param q la taille maximale des files d'attente
     * @param c le nombre des clients présent
     * @param t l'état actuel
     */
    public Checkout(int x, int y, boolean s, int q, int c, boolean t) {
        this.position.x = x;
        this.position.y = y;
        this.style = s;
        this.queue = q;
        this.client = c;
        this.status = t;
        if (s) {
            this.entrance.x = x + 5;
            this.entrance0.x = x + 6;
        } else {
            this.entrance.x = x - 1;
            this.entrance0.x = x - 2;
        }
        this.entrance.y = y - 4;
        this.entrance0.y = y - 4;
        
        this.checkout.x = this.entrance.x;
        this.checkout.y =  this.entrance.y + this.queue - 1;
    }

    /**
     * appliquer les changement des unités sur le supermarché
     * 
     * @param s le supermarché
     */
    public void apply(Supermarket s) {
        // caisse de 5*2
        for (int i = this.position.y; i < this.position.y + 2; i++) {
            for (int j = this.position.x; j < this.position.x + 5; j++) {
                s.status[i][j] = false;
                s.types[i][j] = 0;
            }
        }
        
        for (int i = 0; i < 8; i++) {
            // file d'attente
            s.types[this.entrance.y + i - 1][this.entrance.x] = 5;
            // sortie
            s.types[this.entrance0.y + i - 1][this.entrance0.x] = 5;
        }

        // portillon pour fermer la caisse
        if (!this.status) {
            s.status[this.entrance.y][this.entrance.x] = false;
            s.types[this.entrance.y][this.entrance.x] = 0;
            s.types[this.entrance.y - 1][this.entrance.x] = 1;
        } else {
            // chectout point
            s.types[this.checkout.y][this.checkout.x] = 4;
        }
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the entrance
     */
    public Point getEntrance() {
        return entrance;
    }

    /**
     * @param entrance the entrance to set
     */
    public void setEntrance(Point entrance) {
        this.entrance = entrance;
    }

    /**
     * @return the entrance0
     */
    public Point getEntrance0() {
        return entrance0;
    }

    /**
     * @param entrance0 the entrance0 to set
     */
    public void setEntrance0(Point entrance0) {
        this.entrance0 = entrance0;
    }

    /**
     * @return the checkout
     */
    public Point getCheckout() {
        return checkout;
    }

    /**
     * @param checkout the checkout to set
     */
    public void setCheckout(Point checkout) {
        this.checkout = checkout;
    }

    /**
     * @return the position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * @return the style
     */
    public boolean isStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(boolean style) {
        this.style = style;
    }

}
