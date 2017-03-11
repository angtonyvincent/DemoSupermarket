/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 * @version 1352034
 * @author Ang Tony Vincent
 */
public class Client {

    /**
     * la position 
     * vị trí
     */
    private Point position = new Point();

    /**
     * temps nécessaires pour payer (0 : charrette vide ou de 1 à 10 : déjà
     * acheté)
     */
    private int checkoutTime;

    /**
     * direction (1 : Est, 2 : Sud, 3 : Ouest ou 4 : Nord)
     */
    private int direction;

    /**
     * type de l'image à utiliser (de 1 à n)
     */
    private int type;

    /**
     * style (0 : image à gauche ou 1 : image à droite)
     */
    private boolean style;

    /**
     * le temps pour faire ses courses 
     * si le temps égale 0, le client va aller à la caisse
     */
    private int shoppingTime;
    
    /**
     * la caisse à aller pour payer
     * quầy tính tiền cần đến
     */
    private Point destination = new Point();
    
    /**
     * le constructeur par la création aléatiore de position
     *
     * @param s supermarché
     * @param unitsize taille de l'unité
     */
    public Client(Supermarket s, int unitsize) {
        int ex1 = s.entrance.getPosition1().x;
        int ex2 = s.entrance.getPosition2().x;
        int ey = s.entrance.getPosition1().y;
        int ny = ey - 1;
        int nx = (ex1 + 1) + (int) (Math.random() * (ex2 - ex1 - 1));
        while(!s.status[ny][nx]) {
            nx = (ex1 + 1) + (int) (Math.random() * (ex2 - ex1 - 1));
        }
        this.position.x = nx * unitsize;
        this.position.y = ny * unitsize;
        this.checkoutTime = 0;
        this.direction = 4; // Nord
        this.type = (int) (Math.random() * 4) + 1;
        this.style = false;
        this.shoppingTime = (int) (Math.random() * 1000) + 2000;
        this.destination.x = -1;
        this.destination.y = -1;
        s.status[ny][nx] = false;
    }

    public void move(int[][] unitType, boolean[][] unitStatus, int unitsize, Vector<Checkout> checkouts) {
                        int passY = this.getPosition().y / unitsize;
                int passX = this.getPosition().x / unitsize;
        if (this.shoppingTime > 0) {
            this.shoppingTime--;
            if (this.getPosition().x % unitsize == 0 && this.getPosition().y % unitsize == 0) {
                switch (unitType[passY][passX]) {
                    case 2:
                        // position à tourner
                        int rand = (int) (Math.random() * 7);
                        this.changeDirection(rand);
                        // ne peut pas se tourner vers le Sud
                        if (unitType[passY][passX] == 2 && direction == 2) {
                            this.direction = 4;
                        }
                        break;

                    case 3:
                        // acheter quelques choses
                        this.checkoutTime += (int) (Math.random() * 10) + 10;
                        break;

                    case 5:
                        Random r = new Random();
                        if (r.nextBoolean()) {
                            // Nord 50%
                            this.direction = 4;
                        } else if (r.nextBoolean()) {
                            // Est 25%
                            this.direction = 1;
                            this.style = false;
                        } else {
                            // Ouest 25%
                            this.direction = 3;
                            this.style = true;
                        }
                        break;

                    default:
                        break;
                }
            }
            run(unitStatus, unitsize);
        } else {
            if (this.getPosition().x % unitsize == 0 && this.getPosition().y % unitsize == 0) {
                switch (unitType[passY][passX]) {
                    case 4:
                        // position à payer
                        if (this.checkoutTime > 0) {
                            this.checkoutTime--;
                            return;
                        }
                        
                    case 5:
                        // se tourner à gauche / droite ou continuer à avancer
                        for (int i = 0; i < checkouts.size(); i++) {
                            if (checkouts.elementAt(i).getEntrance().x == passX
                                    && checkouts.elementAt(i).getEntrance().y == passY
                                    && this.checkoutTime == 0) {
                                if (unitStatus[passY][passX + 1]) {
                                    this.direction = 1;
                                } else {
                                    this.direction = 3;
                                }
                                run(unitStatus, unitsize);
                                return;
                            } else if (checkouts.elementAt(i).getEntrance0().x == passX
                                    && this.checkoutTime == 0) {
                                this.direction = 2;
                                run(unitStatus, unitsize);
                                return;
                            }
                        }
                        
                    default:
                        if (this.getDestination().x != -1) {
                            // destination trouvée
                            goToDestination(this.getDestination().x, this.getDestination().y, unitStatus, unitsize);
                            //} else if (unitType[passY][passX] != 5 && unitType[passY][passX] != 4) {
                        } else if (passY < checkouts.elementAt(0).getEntrance().y) {
                            // ne trouve pas la destination 
                            Point min = findMinCheckout(checkouts, unitsize);
                            goToDestination(min.x, min.y, unitStatus, unitsize);
                        } else {
                            // aller au Sud
                            this.direction = 2;
                            run(unitStatus, unitsize);
                        }
                        break;
                }
            } else {
                run(unitStatus, unitsize);
            }
        }
    }
    
    public Point findMinCheckout(Vector<Checkout> checkouts, int unitsize) {
        Point p = new Point();
        if (checkouts.size() > 0) {
            int passX = this.getPosition().x / unitsize;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < checkouts.size(); i++) {
                if (checkouts.elementAt(i).isStatus()) {
                    // formule : chemin minimal = 25 * distance + 100 * client en attendant + somme des temps d'attente
                    int val = 25 * Math.abs(checkouts.elementAt(i).getEntrance().x - passX)
                            + 100 * checkouts.elementAt(i).getClient()
                            + checkouts.elementAt(i).getTime();
                    if (val < min) {
                        min = val;
                        p.x = checkouts.elementAt(i).getEntrance().x;
                        p.y = checkouts.elementAt(i).getEntrance().y;
                    }
                }
            }
        }
        return p;
    }

    public void goToDestination(int x, int y, boolean[][] unitStatus, int unitsize) {
        int passY = this.getPosition().y / unitsize;
        int passX = this.getPosition().x / unitsize;
        
        if (passX == this.getDestination().x && passY == this.getDestination().y) {
            this.destination.x = -1;
        }
        
        boolean south = true, west = true;
        this.direction = 2;
        if(!checkRun(unitStatus, unitsize) && y > passY)
            south = false;
        if(!south || passY == y - 1){
            if(x > passX){
                this.direction = 1;
                if(!checkRun(unitStatus, unitsize))
                    west = false;
            }
            else if(x < passX){
                this.direction = 3;
                if(!checkRun(unitStatus, unitsize))
                    west = false;
            }
        }
        if(y <= passY && x != passX){
            this.direction = 4;
            if(!checkRun(unitStatus, unitsize))
                this.direction = 1;
        }

        if(south || west)
            run(unitStatus, unitsize);
        if(!south && passX == x && passY != y - 1){
            this.destination.x = passX + 3;
            this.destination.y = passY;
        }
        
        if (this.direction == 1) {
            this.style = false;
        } else if (this.direction == 3) {
            this.style = true;
        }
    }

    public boolean checkRun(boolean[][] unitStatus, int unitsize) {
        int passY = this.getPosition().y / unitsize;
        int passX = this.getPosition().x / unitsize;
        try {
            if (this.direction == 1 && unitStatus[passY][passX + 1]) {
                return true;
            } else if (this.direction == 2 && unitStatus[passY + 1][passX]) {
                return true;
            } else if (this.direction == 3 && unitStatus[passY][passX - 1]) {
                return true;
            } else if (this.direction == 4 && unitStatus[passY - 1][passX]) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    void setStatus(boolean[][] unitStatus, int unitsize){
        int passY = this.getPosition().y / unitsize;
        int passX = this.getPosition().x / unitsize;
        switch (this.direction) {
            case 1:
                unitStatus[passY][passX] = true;
                passX++;
                unitStatus[passY][passX] = false;
                break;
            case 2:
                unitStatus[passY][passX] = true;
                passY++;
                unitStatus[passY][passX] = false;
                break;
            case 3:
                unitStatus[passY][passX] = true;
                passX--;
                unitStatus[passY][passX] = false;
                break;
            case 4:
                unitStatus[passY][passX] = true;
                passY--;
                unitStatus[passY][passX] = false;
                break;
            default:
                break;
        }
    }

    public void run(boolean[][] unitStatus, int unitsize) {
        int passY = this.getPosition().y / unitsize;
        int passX = this.getPosition().x / unitsize;
        if (this.getPosition().x % unitsize == 0 && this.getPosition().y % unitsize == 0) {
            if (!checkRun(unitStatus, unitsize)) {
                if (passY >= 17 && passX >= 23 && passX <= 26) {
                    this.direction = 4;
                } else {
                    Random r = new Random();
                    if (r.nextBoolean()) {
                        changeDirection(1);
                    } else {
                        changeDirection(2);
                    }
                }
                return;
            }
            else
                setStatus(unitStatus, unitsize);
        }
        switch (this.direction) {
            case 1:
                this.position.x += 1;
                break;
            case 2:
                this.position.y += 1;
                break;
            case 3:
                this.position.x -= 1;
                break;
            case 4:
                this.position.y -= 1;
                break;
            default:
                break;
        }
    }

    public void changeDirection(int i) {
        switch (i) {
            case 0:
            case 1:
                this.direction++;
                if (this.direction > 4) {
                    this.direction = 1;
                }
                break;
            case 2:
            case 3:
                this.direction--;
                if (this.direction < 1) {
                    this.direction = 4;
                }
                break;
            case 4:
                this.direction += 2;
                if (this.direction == 5) {
                    this.direction = 1;
                }
                if (this.direction == 6) {
                    this.direction = 2;
                }
                break;
        }

        if (this.direction == 1) {
            this.style = false;
        } else if (this.direction == 3) {
            this.style = true;
        }
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the style
     */
    public boolean isCheckStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setCheckStyle(boolean style) {
        this.style = style;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the shoppingTime
     */
    public int getShoppingTime() {
        return shoppingTime;
    }

    /**
     * @param shoppingTime the shoppingTime to set
     */
    public void setShoppingTime(int shoppingTime) {
        this.shoppingTime = shoppingTime;
    }

    /**
     * @return the checkoutTime
     */
    public int getCheckoutTime() {
        return checkoutTime;
    }

    /**
     * @param checkoutTime the checkoutTime to set
     */
    public void setCheckoutTime(int checkoutTime) {
        this.checkoutTime = checkoutTime;
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
     * @return the destination
     */
    public Point getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Point destination) {
        this.destination = destination;
    }

}
