/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import java.awt.Point;

/**
 * @version 1352034
 * @author AngTonyVincent
 */
public class Shelf {

    /**
     * position
     * vị trí
     */
    private Point position = new Point();
    
    /**
     * position pour acheter quelques choses
     * nơi mua hàng
     */
    private Point shopping = new Point();

    /**
     * numéro
     * số thứ tự
     */
    private int no;

    /**
     * @return the no
     */
    public int getStyle() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setStyle(int no) {
        this.no = no;
    }

    /**
     * le constructeur de la classe
     * @param x la position x
     * @param y la position y
     * @param n le numéro
     */
    public Shelf(int x, int y, int n) {
        this.position.x = x;
        this.position.y = y;
        this.shopping.x = x + 2;
        this.shopping.y = y - 1;
        this.no = n;
    }
    
    /**
     * appliquer les changement des unités sur le supermarché
     *
     * @param s le supermarché
     */
    public void apply(Supermarket s) {
        // étagère de 5*4
        for (int i = this.position.y; i < this.position.y + 4; i++) {
            for (int j = this.position.x; j < this.position.x + 5; j++) {
                s.status[i][j] = false;
                s.types[i][j] = 0;
            }
        }
        
        // shopping point
        s.types[this.shopping.y][this.shopping.x] = 3;

        // turning point
        if (s.types[this.position.y + 4][this.position.x - 1] == 1) {
            s.types[this.position.y + 4][this.position.x - 1] = 2;
        }
        if (s.types[this.position.y + 4][this.position.x + 5] == 1) {
            s.types[this.position.y + 4][this.position.x + 5] = 2;
        }
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
     * @return the shopping
     */
    public Point getShopping() {
        return shopping;
    }

    /**
     * @param shopping the shopping to set
     */
    public void setShopping(Point shopping) {
        this.shopping = shopping;
    }

}
