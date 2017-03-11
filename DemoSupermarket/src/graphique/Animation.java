/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import objet.*;

/**
 * @version 1352034
 * @author Ang Tony Vincent
 */
public class Animation extends JPanel implements ActionListener {
    
    Supermarket s;

    // pour changer l'image de client
    boolean cChange;

    // pour changer l'image de gardien et de vendeur
    int sChange;

    /**
     * nombre des clients
     */
    int client;

    /**
     * taille de l'unité
     */
    int unitsize;

    /**
     * taille de la carte
     */
    int width, height;

    /**
     * création d'un nouveau client après un instant
     */
    int time;

    /**
     * timer
     */
    Timer timer;

    /**
     * test mode
     */
    boolean test;
    
    /**
     * images de client
     */
    Image imgClient11 = null;
    Image imgClient12 = null;
    Image imgClient13 = null;
    Image imgClient14 = null;
    Image imgClient15 = null;
    Image imgClient16 = null;
    Image imgClient17 = null;
    Image imgClient18 = null;
    Image imgClient21 = null;
    Image imgClient22 = null;
    Image imgClient23 = null;
    Image imgClient24 = null;
    Image imgClient25 = null;
    Image imgClient26 = null;
    Image imgClient27 = null;
    Image imgClient28 = null;
    Image imgClient31 = null;
    Image imgClient32 = null;
    Image imgClient33 = null;
    Image imgClient34 = null;
    Image imgClient35 = null;
    Image imgClient36 = null;
    Image imgClient37 = null;
    Image imgClient38 = null;
    Image imgClient41 = null;
    Image imgClient42 = null;
    Image imgClient43 = null;
    Image imgClient44 = null;
    Image imgClient45 = null;
    Image imgClient46 = null;
    Image imgClient47 = null;
    Image imgClient48 = null;

    /**
     * chiffres
     */
    Image img0 = null;
    Image img1 = null;
    Image img2 = null;
    Image img3 = null;
    Image img4 = null;
    Image img5 = null;
    Image img6 = null;
    Image img7 = null;
    Image img8 = null;
    Image img9 = null;

    /**
     * images de supermarché
     */
    Image imgBackground = null;
    Image imgBuy = null;
    Image imgCheckout1 = null;
    Image imgCheckout2 = null;
    Image imgEntrance = null;
    Image imgExit = null;
    Image imgFlag = null;
    Image imgQueue = null;
    Image imgGate1 = null;
    Image imgGate2 = null;
    Image imgGo = null;
    Image imgSecurity1 = null;
    Image imgSecurity2 = null;
    Image imgShelf1 = null;
    Image imgShelf2 = null;
    Image imgStop = null;
    Image imgSalesman1 = null;
    Image imgSalesman2 = null;
    Image imgSalesman3 = null;
    Image imgSalesman4 = null;

    /**
     * le constructeur de la classe Animation
     *
     * @param client nombre maximal de clients
     * @param queue nombre de files d'attente
     * @param checkout taille maximale de chaque file
     * @param unitsize taille de l'unité
     * @param width longueur
     * @param height hauteur
     * @param delay pour repeindre
     * @param test test mode
     */
    public Animation(int client, int queue, int checkout, int unitsize, int width, int height, int delay, boolean test) {
        this.s = new Supermarket(width, height, checkout, queue);
        this.time = 0;
        this.client = client;
        this.unitsize = unitsize;
        this.width = width;
        this.height = height;
        this.test = test;
        this.cChange = false;
        this.sChange = 0;
        this.timer = new Timer(delay, this);
                
        try {
            // chargement des images
            imgBackground = ImageIO.read(new File("img/background.png"));
            imgShelf1 = ImageIO.read(new File("img/shelf1.png"));
            imgShelf2 = ImageIO.read(new File("img/shelf2.png"));
            imgSecurity1 = ImageIO.read(new File("img/security1.png"));
            imgSecurity2 = ImageIO.read(new File("img/security2.png"));
            imgEntrance = ImageIO.read(new File("img/entrance.png"));
            imgExit = ImageIO.read(new File("img/exit.png"));
            imgFlag = ImageIO.read(new File("img/flag.png"));
            imgCheckout1 = ImageIO.read(new File("img/checkout1.png"));
            imgCheckout2 = ImageIO.read(new File("img/checkout2.png"));
            imgQueue = ImageIO.read(new File("img/queue.png"));
            imgClient11 = ImageIO.read(new File("img/boy1.png"));
            imgClient12 = ImageIO.read(new File("img/boy2.png"));
            imgClient13 = ImageIO.read(new File("img/boy3.png"));
            imgClient14 = ImageIO.read(new File("img/boy4.png"));
            imgClient15 = ImageIO.read(new File("img/boy5.png"));
            imgClient16 = ImageIO.read(new File("img/boy6.png"));
            imgClient17 = ImageIO.read(new File("img/boy7.png"));
            imgClient18 = ImageIO.read(new File("img/boy8.png"));
            imgClient21 = ImageIO.read(new File("img/girl1.png"));
            imgClient22 = ImageIO.read(new File("img/girl2.png"));
            imgClient23 = ImageIO.read(new File("img/girl3.png"));
            imgClient24 = ImageIO.read(new File("img/girl4.png"));
            imgClient25 = ImageIO.read(new File("img/girl5.png"));
            imgClient26 = ImageIO.read(new File("img/girl6.png"));
            imgClient27 = ImageIO.read(new File("img/girl7.png"));
            imgClient28 = ImageIO.read(new File("img/girl8.png"));
            imgClient31 = ImageIO.read(new File("img/mario1.png"));
            imgClient32 = ImageIO.read(new File("img/mario2.png"));
            imgClient33 = ImageIO.read(new File("img/mario3.png"));
            imgClient34 = ImageIO.read(new File("img/mario4.png"));
            imgClient35 = ImageIO.read(new File("img/mario5.png"));
            imgClient36 = ImageIO.read(new File("img/mario6.png"));
            imgClient37 = ImageIO.read(new File("img/mario7.png"));
            imgClient38 = ImageIO.read(new File("img/mario8.png"));
            imgClient41 = ImageIO.read(new File("img/minion1.png"));
            imgClient42 = ImageIO.read(new File("img/minion2.png"));
            imgClient43 = ImageIO.read(new File("img/minion3.png"));
            imgClient44 = ImageIO.read(new File("img/minion4.png"));
            imgClient45 = ImageIO.read(new File("img/minion5.png"));
            imgClient46 = ImageIO.read(new File("img/minion6.png"));
            imgClient47 = ImageIO.read(new File("img/minion7.png"));
            imgClient48 = ImageIO.read(new File("img/minion8.png"));
            imgSalesman1 = ImageIO.read(new File("img/salesman1.png"));
            imgSalesman2 = ImageIO.read(new File("img/salesman2.png"));
            imgSalesman3 = ImageIO.read(new File("img/salesman3.png"));
            imgSalesman4 = ImageIO.read(new File("img/salesman4.png"));
            imgGate1 = ImageIO.read(new File("img/gate1.png"));
            imgGate2 = ImageIO.read(new File("img/gate2.png"));
            imgBuy = ImageIO.read(new File("img/buy.png"));
            imgGo = ImageIO.read(new File("img/go.png"));
            imgStop = ImageIO.read(new File("img/stop.png"));
            img0 = ImageIO.read(new File("img/0.png"));
            img1 = ImageIO.read(new File("img/1.png"));
            img2 = ImageIO.read(new File("img/2.png"));
            img3 = ImageIO.read(new File("img/3.png"));
            img4 = ImageIO.read(new File("img/4.png"));
            img5 = ImageIO.read(new File("img/5.png"));
            img6 = ImageIO.read(new File("img/6.png"));
            img7 = ImageIO.read(new File("img/7.png"));
            img8 = ImageIO.read(new File("img/8.png"));
            img9 = ImageIO.read(new File("img/9.png"));

            if (test) {
                System.out.println("BEGIN TYPE");
                for (int i = 0; i < 25; i++) {
                    for (int j = 0; j < 50; j++) {
                        System.out.print("" + this.s.types[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("END TYPE");
                System.out.println("BEGIN STATUS");
                for (int i = 0; i < 25; i++) {
                    for (int j = 0; j < 50; j++) {
                        if (this.s.status[i][j]) {
                            System.out.print("" + 1);
                        } else {
                            System.out.print("" + 0);
                        }
                    }
                    System.out.println();
                }
                System.out.println("END STATUS");
            }
        } catch (Exception e) {
            System.out.println("Exception capturée dans Animation: " + e);
        }
    }

    public void paintSupermarket(Graphics g) {
        // arrière-plan
        g.drawImage(imgBackground, 1, 1, this.width * this.unitsize, this.height * this.unitsize, this);

        // raies
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i <= this.width; i++) {
            for (int j = 0; j <= this.height; j++) {
                g.drawLine(0, j * this.unitsize, this.width * this.unitsize, j * this.unitsize);
                g.drawLine(i * this.unitsize, 0, i * this.unitsize, this.height * this.unitsize);
                if (j <= this.height) {
                    g.drawString(j + "", this.unitsize * this.width + 10, this.unitsize * j);
                }
            }
            if (i < this.width) {
                g.drawString(i + 1 + "", this.unitsize * i, this.unitsize * (this.height + 1));
            }
        }

        g.setColor(Color.BLUE);
        g.drawString("Checkout's information : Client(s) / Queue max & Total checkout time "
                + "       Client's information : Checkout time"
                + "       Clients : " + this.s.clients.size(), 
                this.unitsize, this.unitsize * (this.height + 2));
        
        // étagères
        for (int i = 0; i < this.s.shelfs.size(); i++) {
            int x = this.s.shelfs.elementAt(i).getPosition().x;
            int y = this.s.shelfs.elementAt(i).getPosition().y;
            
            if (i % 2 == 0) {
                g.drawImage(imgShelf1, x * this.unitsize + 1, y * this.unitsize,
                        5 * this.unitsize - 1, 4 * this.unitsize - 1, this);
            } else {
                g.drawImage(imgShelf2, x * this.unitsize + 1, y * this.unitsize,
                        5 * this.unitsize - 1, 4 * this.unitsize - 1, this);
            }
            
            // le premier nombre
            if ((i + 1) > 9) {
                g.drawImage(img1, x * this.unitsize + 3 * this.unitsize / 2, y * this.unitsize,
                        this.unitsize - 1, this.unitsize - 1, this);
            } else {
                g.drawImage(img0, x * this.unitsize + 3 * this.unitsize / 2, y * this.unitsize,
                        this.unitsize - 1, this.unitsize - 1, this);
            }
            
            // le deuxième nombre
            switch ((i + 1) % 10) {
                case 0:
                    g.drawImage(img0, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 1:
                    g.drawImage(img1, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 2:
                    g.drawImage(img2, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 3:
                    g.drawImage(img3, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 4:
                    g.drawImage(img4, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 5:
                    g.drawImage(img5, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 6:
                    g.drawImage(img6, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 7:
                    g.drawImage(img7, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 8:
                    g.drawImage(img8, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                case 9:
                    g.drawImage(img9, x * this.unitsize + 5 * this.unitsize / 2 + 2, y * this.unitsize,
                            this.unitsize - 1, this.unitsize - 1, this);
                    break;

                default:
                    break;
            }
            
            // shopping point
            x = this.s.shelfs.elementAt(i).getShopping().x;
            y = this.s.shelfs.elementAt(i).getShopping().y;
            
            g.drawImage(imgBuy, x * this.unitsize + 1, y * this.unitsize + 1,
                    this.unitsize - 1, this.unitsize - 1, this);
            if (!this.s.status[y][x]) {
                g.setColor(Color.GREEN);
                g.drawRect(x * this.unitsize + 1, y * this.unitsize + 1, this.unitsize - 2, this.unitsize - 2);
            }
        }

        // entrée
        g.drawImage(imgEntrance,
                (this.s.entrance.getPosition1().x + 1) * this.unitsize + 1,
                this.s.entrance.getPosition1().y * this.unitsize + 1,
                (this.s.entrance.getPosition2().x - this.s.entrance.getPosition1().x - 1) * this.unitsize - 1,
                this.unitsize - 1, this);
        for (int i = this.s.entrance.getPosition2().y + 1; i < this.s.entrance.getPosition1().y - 1; i++) {
            g.drawImage(imgFlag, this.s.entrance.getPosition1().x * this.unitsize + 1, i * this.unitsize + 1,
                    this.unitsize - 1, this.unitsize - 1, this);
            g.drawImage(imgFlag, this.s.entrance.getPosition2().x * this.unitsize + 1, i * this.unitsize + 1,
                    this.unitsize - 1, this.unitsize - 1, this);
        }

        // gardiens et vendeurs
        if (this.sChange > 5) {
            for (int i = 0; i < this.s.checkouts.size(); i++) {
                if (this.s.checkouts.elementAt(i).isStatus()) {
                    if (this.s.checkouts.elementAt(i).isStyle()) {
                        g.drawImage(imgSalesman1, (this.s.checkouts.elementAt(i).getPosition().x + 2) * this.unitsize + 1,
                                this.s.checkouts.elementAt(i).getPosition().y * this.unitsize + 1,
                                this.unitsize - 1, 2 * this.unitsize - 1, this);
                    } else {
                        g.drawImage(imgSalesman3, (this.s.checkouts.elementAt(i).getPosition().x + 2) * this.unitsize + 1,
                                this.s.checkouts.elementAt(i).getPosition().y * this.unitsize + 1,
                                this.unitsize - 1, 2 * this.unitsize - 1, this);
                    }
                }
            }

            g.drawImage(imgSecurity1, 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
            g.drawImage(imgSecurity1, 22 * this.unitsize + 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
            g.drawImage(imgSecurity1, 27 * this.unitsize + 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
            g.drawImage(imgSecurity1, 49 * this.unitsize + 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
        } else {
            for (int i = 0; i < this.s.checkouts.size(); i++) {
                if (this.s.checkouts.elementAt(i).isStatus()) {
                    if (this.s.checkouts.elementAt(i).isStyle()) {
                        g.drawImage(imgSalesman2, (this.s.checkouts.elementAt(i).getPosition().x + 2) * this.unitsize + 1,
                                this.s.checkouts.elementAt(i).getPosition().y * this.unitsize + 1,
                                this.unitsize - 1, 2 * this.unitsize - 1, this);
                    } else {
                        g.drawImage(imgSalesman4, (this.s.checkouts.elementAt(i).getPosition().x + 2) * this.unitsize + 1,
                                this.s.checkouts.elementAt(i).getPosition().y * this.unitsize + 1,
                                this.unitsize - 1, 2 * this.unitsize - 1, this);
                    }
                }
            }

            g.drawImage(imgSecurity2, 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
            g.drawImage(imgSecurity2, 22 * this.unitsize + 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
            g.drawImage(imgSecurity2, 27 * this.unitsize + 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
            g.drawImage(imgSecurity2, 49 * this.unitsize + 1, 23 * this.unitsize + 1, this.unitsize - 1, 2 * this.unitsize - 1, null);
        }
    }
    
    public void paintCaisse(Graphics g) {
        for (int i = 0; i < this.s.checkouts.size(); i++) {
            int px = this.s.checkouts.elementAt(i).getPosition().x;
            int py = this.s.checkouts.elementAt(i).getPosition().y;  
            int cx = this.s.checkouts.elementAt(i).getCheckout().x;
            int cy = this.s.checkouts.elementAt(i).getCheckout().y;
            int ex = this.s.checkouts.elementAt(i).getEntrance().x;
            int ey = this.s.checkouts.elementAt(i).getEntrance().y;
            int e0x = this.s.checkouts.elementAt(i).getEntrance0().x;
            int e0y = this.s.checkouts.elementAt(i).getEntrance0().y;
            int nq = this.s.checkouts.elementAt(i).getQueue();
            int nc = this.s.checkouts.elementAt(i).getClient();
            int t = this.s.checkouts.elementAt(i).getTime();
            boolean style = this.s.checkouts.elementAt(i).isStyle();
            boolean status = this.s.checkouts.elementAt(i).isStatus();
            
            Image img = null;
            switch(i+1) {
                case 1:
                    img = this.img1;
                    break;
                case 2:
                    img = this.img2;
                    break;
                case 3:
                    img = this.img3;
                    break;
                case 4:
                    img = this.img4;
                    break;
                case 5:
                    img = this.img5;
                    break;
                case 6:
                    img = this.img6;
                    break;
                default:
                    break;
            }
            
            if (style) {
                // table de la caisse style 2
                g.drawImage(imgCheckout2, (px + 2) * this.unitsize + 1, py * this.unitsize + 1,
                        3 * this.unitsize - 1, 2 * this.unitsize - 1, this);
                // numéro
                g.drawImage(img0, px * this.unitsize + 1, (py + 1) * this.unitsize + 1,
                        this.unitsize - 1, this.unitsize - 1, this);
                g.drawImage(img, (px + 1) * this.unitsize + 1, (py + 1) * this.unitsize + 1,
                        this.unitsize - 1, this.unitsize - 1, this);
                // état
                if (status) {
                    g.setColor(Color.BLUE);
                    g.drawString(nc + "/" + nq, px * this.unitsize + 1, (py + 1) * this.unitsize - 1);
                    g.drawString(t + "", (px + 1) * this.unitsize + 1, (py + 1) * this.unitsize - 1);
                }
            } else {
                // table de la caisse style 1
                g.drawImage(imgCheckout1, px * this.unitsize + 1, py * this.unitsize + 1,
                        3 * this.unitsize - 1, 2 * this.unitsize - 1, this);
                // numéro
                g.drawImage(img0, (px + 3) * this.unitsize + 1, (py + 1) * this.unitsize + 1,
                        this.unitsize - 1, this.unitsize - 1, this);
                g.drawImage(img, (px + 4) * this.unitsize + 1, (py + 1) * this.unitsize + 1,
                        this.unitsize - 1, this.unitsize - 1, this);
                // état
                if (status) {
                    g.setColor(Color.BLUE);
                    g.drawString(nc + "/" + nq, (px + 3) * this.unitsize + 1, (py + 1) * this.unitsize - 1);
                    g.drawString(t + "", (px + 4) * this.unitsize + 1, (py + 1) * this.unitsize - 1);
                }
            }
            
            // sortie
            g.drawImage(imgExit, e0x * this.unitsize + 1, e0y * this.unitsize + 1,
                    this.unitsize - 1, 6 * this.unitsize - 1, this);
            // symbole "go"
            g.drawImage(imgGo, e0x * this.unitsize + 1, (e0y + 6) * this.unitsize + 1,
                    this.unitsize - 1, this.unitsize - 1, this);
            
            // files d'attente
            for (int j = 0; j < nq; j++) {
                g.drawImage(imgQueue, ex * this.unitsize + 1, (ey + j) * this.unitsize + 1,
                        this.unitsize - 1, this.unitsize - 1, this);
                if (!this.s.status[ey + j][ex]) {
                    g.setColor(Color.CYAN);
                    g.drawRect(ex * this.unitsize + 1, (ey + j) * this.unitsize + 1,
                            this.unitsize - 2, this.unitsize - 2);
                }
            }
            
            // portillon et message
            if (!status) {
                if (style) {
                    g.drawImage(imgGate2, (ex - 1) * this.unitsize + 1, ey * this.unitsize + 1,
                            2 * this.unitsize - 1, this.unitsize - 1, this);
                } else {
                    g.drawImage(imgGate1, ex * this.unitsize + 1, ey * this.unitsize + 1,
                            2 * this.unitsize - 1, this.unitsize - 1, this);
                }
            } else {
                if (this.s.status[cy][cx]) {
                    g.drawImage(imgGo, cx * this.unitsize + 1, (cy + 1) * this.unitsize + 1,
                            this.unitsize - 1, this.unitsize - 1, this);
                } else {
                    g.drawImage(imgStop, cx * this.unitsize + 1, (cy + 1) * this.unitsize + 1,
                            this.unitsize - 1, this.unitsize - 1, this);
                }
            }
        }
    }

    public void paintClient(Graphics g) {
        for (int i = 0; i < this.s.clients.size(); i++) {
            int x = this.s.clients.elementAt(i).getPosition().x;
            int y = this.s.clients.elementAt(i).getPosition().y;
            int st = this.s.clients.elementAt(i).getShoppingTime();
            int ct = this.s.clients.elementAt(i).getCheckoutTime();
            int type = this.s.clients.elementAt(i).getType();
            boolean style = this.s.clients.elementAt(i).isCheckStyle();
            
            if (!style && !this.cChange) {
                if (ct == 0) {
                    switch (type) {
                        case 1:
                            g.drawImage(imgClient11, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 2:
                            g.drawImage(imgClient21, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 3:
                            g.drawImage(imgClient31, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 4:
                            g.drawImage(imgClient41, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        default:
                            break;
                    }
                } else {
                    switch (type) {
                        case 1:
                            g.drawImage(imgClient15, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 2:
                            g.drawImage(imgClient25, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 3:
                            g.drawImage(imgClient35, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 4:
                            g.drawImage(imgClient45, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        default:
                            break;
                    }
                }
            } else if (!style) {
                if (ct == 0) {
                    switch (type) {
                        case 1:
                            g.drawImage(imgClient12, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 2:
                            g.drawImage(imgClient22, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 3:
                            g.drawImage(imgClient32, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 4:
                            g.drawImage(imgClient42, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        default:
                            break;
                    }
                } else {
                    switch (type) {
                        case 1:
                            g.drawImage(imgClient16, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 2:
                            g.drawImage(imgClient26, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 3:
                            g.drawImage(imgClient36, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 4:
                            g.drawImage(imgClient46, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        default:
                            break;
                    }
                }
            } else if (!this.cChange) {
                if (ct == 0) {
                    switch (type) {
                        case 1:
                            g.drawImage(imgClient13, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 2:
                            g.drawImage(imgClient23, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 3:
                            g.drawImage(imgClient33, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 4:
                            g.drawImage(imgClient43, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        default:
                            break;
                    }
                } else {
                    switch (type) {
                        case 1:
                            g.drawImage(imgClient17, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 2:
                            g.drawImage(imgClient27, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 3:
                            g.drawImage(imgClient37, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        case 4:
                            g.drawImage(imgClient47, x, y, this.unitsize - 1, this.unitsize - 1, null);
                            break;
                        default:
                            break;
                    }
                }
            } else if (ct == 0) {
                switch (type) {
                    case 1:
                        g.drawImage(imgClient14, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    case 2:
                        g.drawImage(imgClient24, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    case 3:
                        g.drawImage(imgClient34, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    case 4:
                        g.drawImage(imgClient44, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    default:
                        break;
                }
            } else {
                switch (type) {
                    case 1:
                        g.drawImage(imgClient18, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    case 2:
                        g.drawImage(imgClient28, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    case 3:
                        g.drawImage(imgClient38, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    case 4:
                        g.drawImage(imgClient48, x, y, this.unitsize - 1, this.unitsize - 1, null);
                        break;
                    default:
                        break;
                }
            }
            
            if (style) {
                // shopping time
                g.setColor(Color.RED);
                if (this.test && st > 0) {
                    g.drawString(st + "", x, y);
                } else if (st == 0 && this.sChange > 5) {
                    g.drawString("#", x, y);
                }
                // checkout time
                g.setColor(Color.BLUE);
                g.drawString(ct + "", x, y + this.unitsize / 2);
            } else {
                // shopping time
                g.setColor(Color.RED);
                if (this.test && st > 0) {
                    g.drawString(st + "", x + this.unitsize / 2, y);
                } else if (st == 0 && this.sChange > 5) {
                    g.drawString("#", x + this.unitsize / 2, y);
                }
                // checkout time
                g.setColor(Color.BLUE);
                g.drawString(ct + "", x + this.unitsize / 2, y + this.unitsize / 2);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintSupermarket(g);
        paintCaisse(g);
        paintClient(g);
        
        if (this.test) {
            g.setColor(Color.BLACK);
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 50; j++) {
                    if (this.s.status[i][j]) {
                        g.drawString(this.s.types[i][j] + "T", j * this.unitsize, (i + 1) * this.unitsize);
                    } else {
                        g.drawString(this.s.types[i][j] + "F", j * this.unitsize, (i + 1) * this.unitsize);
                    }
                }
            }
        }

        // commencer à repeindre après un instant
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // change status pour repenidre
        this.cChange = !this.cChange;
        this.sChange++;
        if (this.sChange > 10) {
            this.sChange = 0;
        }

        // create new client
        this.time++;
        if (this.time == 20) {
            if (this.s.clients.size() < this.client) {
                Client cl = new Client(s, unitsize);
                this.s.clients.add(cl);
            }
            this.time = 0;
        }
        
        // change checkout's status
        for (int i = 0; i < this.s.checkouts.size(); i++) {
            this.s.checkouts.elementAt(i).setClient(0);
            this.s.checkouts.elementAt(i).setTime(0);
            for (int j = 0; j < this.s.checkouts.elementAt(i).getQueue(); j++) {
                if (!this.s.status[this.s.checkouts.elementAt(i).getEntrance().y + j][this.s.checkouts.elementAt(i).getEntrance().x]) {
                    this.s.checkouts.elementAt(i).setClient(this.s.checkouts.elementAt(i).getClient() + 1);
                }
            }
        }

        // client move
        for (int i = 0; i < this.s.clients.size(); i++) {
            int x = this.s.clients.elementAt(i).getPosition().x / this.unitsize;
            int y = this.s.clients.elementAt(i).getPosition().y / this.unitsize;
            //check remove client when client go out
            if (y == 24 && this.s.clients.elementAt(i).getDirection() == 2) {
                this.s.status[y][x] = true;
                this.s.clients.removeElementAt(i);
            } else {
                for (int j = 0; j < this.s.checkouts.size(); j++) {
                    if (this.s.checkouts.elementAt(j).getEntrance().x == x
                            && this.s.checkouts.elementAt(j).getEntrance().y <= y) {
                        this.s.checkouts.elementAt(j).setTime(
                                this.s.checkouts.elementAt(j).getTime() + this.s.clients.elementAt(i).getCheckoutTime());
                    }
                }
                this.s.clients.elementAt(i).move(this.s.types, this.s.status, unitsize, this.s.checkouts);
            }
        }

        repaint();
    }

}
