package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gameLogic.*;
import pattern.*;

public class WindowFrame implements KeyListener, Runnable {
	
	private static final String gameTitle = "StackDotPop";
	
	/* Thread variables */
	private Thread thread;
	private boolean running = false;
	
	private int frameHeight = 480;
	private int frameWidth = 720;
	private static final int panelRows = 3;
	private static final int panelColumns = 3;
	// Maximum number of patterns
	private static final int maxPatterns = 4;
		
	private JFrame frame;
	private Panel[][] panelHolder;
	private GameEngine gameEngine;
	private PatternStack stack;
	
	private double timer = 0;
	private int score = 0;
	private int level = 1;
		
	public WindowFrame() {
		// Initialize frame defaults
		frame = new JFrame(gameTitle);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.setIconImage(new ImageIcon("resources/icon.png").getImage());
		
		// Load board background image
		try{ frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/wood_background.jpg"))))); } catch(Exception e) {}
		
		// Initialize board grid
		panelHolder = new Panel[panelRows][panelColumns];
		frame.setLayout(new GridLayout(panelRows,panelColumns));
		
		CardinalLocation counter = CardinalLocation.NORTH_WEST;
		
		for(int y=0; y<panelRows; y++) {
			for(int x=0; x<panelColumns; x++) {
				panelHolder[x][y] = new Panel(counter, new NullPattern());
				frame.add(panelHolder[x][y]);
				counter.next();
			}
		}
		
		gameEngine = new GameEngine();
		stack = gameEngine.getPatternStack();

		panelHolder[1][0].setPattern(new Blue("Blue","BlueOrb.png"));
		panelHolder[2][1].setPattern(new Green("Green","GreenOrb.png"));
		panelHolder[1][2].setPattern(new Yellow("Yellow","YellowOrb.png"));
		panelHolder[0][1].setPattern(new Red("Red","RedOrb.png"));
		
		panelHolder[1][1].setPattern(stack.top);
		updateFrame();
		frame.pack();
		frame.setVisible(true);
		
		start();
	}
	
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		// initialize keylistener
		frame.addKeyListener(this);
		
		long previousTime = System.nanoTime();
		final double numTicks = 60.0; // fps
		double ns = 1000000000 / numTicks;
		double delta = 0;
		
		while(running) {
			long currentTime = System.nanoTime();
			delta += (previousTime - currentTime) / ns;
			previousTime = currentTime;
			
			if(delta >= 1) {
				tick();
				delta--;
			}
			
			render();
		}
		stop();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) { e.printStackTrace(); }
		System.exit(1);
	} 

	@Override
	public void keyPressed(KeyEvent e) {
		switch(gameEngine.getState()) {
		case START_MENU:
			break;
		case GAME:
			gameTick(e);
			break;
		default:
			break;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	private void tick() {
		//if() {} 
	}
	
	private void render() {
		
	}
	
	private void gameTick(KeyEvent e) {

		String out = "null";
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				Patterns p = stack.pop();
				System.out.println(p.getPatternName() + panelHolder[1][0].getPattern().getPatternName());
				out = panelHolder[1][0].patternMatches(p) ? "true":"false";
				break;
			case KeyEvent.VK_DOWN:
				Patterns p1 = stack.pop();
				System.out.println(p1.getPatternName() + panelHolder[1][2].getPattern().getPatternName());
				out = panelHolder[1][2].patternMatches(p1) ? "true":"false";
				break;
			case KeyEvent.VK_LEFT:
				Patterns p2 = stack.pop();
				System.out.println(p2.getPatternName() + panelHolder[0][1].getPattern().getPatternName());
				out = panelHolder[0][1].patternMatches(p2) ? "true":"false";
				break;
			case KeyEvent.VK_RIGHT:
				Patterns p3 = stack.pop();
				System.out.println(p3.getPatternName() + panelHolder[2][1].getPattern().getPatternName());
				out = panelHolder[2][1].patternMatches(p3) ? "true":"false";
				break;
			case KeyEvent.VK_SPACE:
				break;
			case KeyEvent.VK_ESCAPE:
				stop();
				break;
			default:
				break;
		}
		panelHolder[1][1].setPattern(stack.top);
	}
	
	private void updateFrame() {
		for(int y=0; y<panelRows; y++) {
			for(int x=0; x<panelColumns; x++) {
				panelHolder[x][y].setOpaque(true);
				frame.add(panelHolder[x][y]);
			}
		}
	}
}
