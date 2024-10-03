package Mystack;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/**
 * SnakeGame class represents the main game logic and GUI for the Snake Game.
 */

public class SnakeGame extends JPanel implements ActionListener {
 
    private final int BOARD_WIDTH = 300;
    private final int BOARD_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;
 
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
 
    private int dots;
    private int appleX;
    private int appleY;
 
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
 
    private Timer timer;
 
    /**
     * Constructor to initialize the SnakeGame.
     */
    public SnakeGame() {
        initGame();
    }
 
    /**
     * Initializes the game by setting up the game board, snake, and apple.
     */
    private void initGame() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
 
        addKeyListener(new TAdapter());
 
        initSnake();
        initApple();
 
        timer = new Timer(DELAY, this);
        timer.start();
    }
 
    /**
     * Initializes the snake at the start of the game.
     */
    private void initSnake() {
        dots = 3;
 
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * DOT_SIZE;
            y[z] = 50;
        }
    }
 
    /**
     * Initializes the apple at a random position on the game board.
     */
    private void initApple() {
        int r = (int) (Math.random() * RAND_POS);
        appleX = r * DOT_SIZE;
 
        r = (int) (Math.random() * RAND_POS);
        appleY = r * DOT_SIZE;
    }
 
    /**
     * Draws the snake and apple on the game board.
     *
     * @param g The Graphics object to draw on.
     */
    private void doDrawing(Graphics g) {
        if (inGame) {
            g.setColor(Color.red);
            
            g.fillOval(appleX, appleY, DOT_SIZE, DOT_SIZE);
 
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRect(x[z], y[z], DOT_SIZE, DOT_SIZE);
            }
 
            Toolkit.getDefaultToolkit().sync();
 
        } else {
            gameOver(g);
        }
    }
 
    /**
     * Displays the game over message on the game board.
     *
     * @param g The Graphics object to draw on.
     */
    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
 
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg)) / 2, BOARD_HEIGHT / 2);
    }
 
    /**
     * Moves the snake and checks for collisions with the apple or itself.
     */
    private void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }
 
        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
 
        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
 
        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
 
        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
 
    /**
     * Checks for collisions with the apple or itself.
     */
    private void checkCollision() {
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
 
        if (y[0] >= BOARD_HEIGHT) {
            inGame = false;
        }
 
        if (y[0] < 0) {
            inGame = false;
        }
 
        if (x[0] >= BOARD_WIDTH) {
            inGame = false;
        }
 
        if (x[0] < 0) {
            inGame = false;
        }
 
        if (!inGame) {
            timer.stop();
        }
    }
 
    /**
     * Checks if the snake has eaten the apple and updates the game accordingly.
     */
    private void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            dots++;
            initApple();
        }
    }
 
    /**
     * Paints the game board and components.
     *
     * @param g The Graphics object to draw on.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        doDrawing(g);
    }
 
    /**
     * Handles the timer event and updates the game state.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
 
        repaint();
    }
 
    /**
     * Handles keyboard input for controlling the snake's direction.
     */
    private class TAdapter extends KeyAdapter {
 
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
 
            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
 
            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
 
            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
 
            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
 
    /**
     * Main method to start the Snake Game.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
