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
public class Entrance {
    
    /**
     * la première position 
     * vị trí thứ 1
     */
    private Point position1 = new Point();

    /**
     * la première position 
     * vị trí thứ 2
     */
    private Point position2 = new Point();

    /**
     * @return the position
     */
    public Point getPosition1() {
        return position1;
    }

    /**
     * @param position the position to set
     */
    public void setPosition1(Point position) {
        this.position1 = position;
    }

    /**
     * @return the position
     */
    public Point getPosition2() {
        return position2;
    }

    /**
     * @param position the position to set
     */
    public void setPosition2(Point position) {
        this.position2 = position;
    }
    
    public Entrance(int x, int y) {
        this.position1.x = x;
        this.position1.y = y;
        this.position2.x = x + 5;
        this.position2.y = y - 7;
    }
    
    public void apply(Supermarket s) {
        // deux colonnes
        for (int i = this.position1.y; i > this.position2.y; i--) {
            s.status[i][this.position1.x] = false;
            s.types[i][this.position1.x] = 0;
            s.status[i][this.position2.x] = false;
            s.types[i][this.position2.x] = 0;
        }
        // une ligne
        for (int i = this.position1.x; i < this.position2.x + 1; i++) {
            s.status[this.position1.y][i] = false;
            s.types[this.position1.y][i] = 0;
        }
        // sous forme U 6*7
        // hình chữ U 6*7
    }
    
}
