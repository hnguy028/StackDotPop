package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import definitions.Variables;
import gameLogic.*;
import pattern.*;

/**
 * @author hinguyen
 *
 * Main frame and thread of the game. Holds all game objects
 */
public class WindowFrame implements KeyListener, Runnable {
	
	/* Thread variables */
	private Thread thread;
	private boolean running = false;
	
	/* Frame Initial Configurations */
	private int frameHeight = 480;
	private int frameWidth = 720;
	
	/* Board Layout (3x3 grid containing panels for each object) */
	private static final int panelRows = Variables.panelRows;
	private static final int panelColumns = Variables.panelColumns;
	
	// Maximum number of panels
	private static final int maxPatterns = Variables.maxPatterns;
	
	/* Game Objects */
	private JFrame frame;
	private JPanelImage gamePanel;
	private GameEngine gameEngine;
	
	/* Debugging Variables*/
	
	
	/**
	 * Constructor 
	 */
	public WindowFrame() {
		init();
		start();
	}
	
	/**
	 * init() : Initializes the game objects
	 */
	public void init() {
		// Initialize frame defaults
		frame = new JFrame(Variables.gameTitle);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.setIconImage(new ImageIcon(Variables.imageDirectory + Variables.iconFileName).getImage());
		frame.setLayout(new BorderLayout());
		
		// Set game layout to be a grid
		gamePanel = new JPanelImage(Variables.imageDirectory + Variables.backgroundFileName, panelRows, panelColumns);
		gamePanel.setLayout(new GridLayout(panelRows,panelColumns));
		
		gameEngine = new GameEngine();

		gamePanel.addPattern(1,0,new Blue("0","BlueOrb"));
		gamePanel.addPattern(2,1,new Green("1","GreenOrb"));
		gamePanel.addPattern(1,2,new Yellow("2","YellowOrb"));
		gamePanel.addPattern(0,1,new Red("3","RedOrb"));
		
		// set stack to the center cell
		if(gameEngine.topStack() == null) {
			
			
		}
		System.out.println(gameEngine.topStack().getFileName());
		gamePanel.addPattern(1,1,gameEngine.topStack());
		
		// add components to frame
		frame.add(gamePanel, BorderLayout.CENTER);
		frame.add(gameEngine, BorderLayout.NORTH);

		frame.pack();
		frame.setVisible(true);
		
		// initialize keylistener
		frame.addKeyListener(this);
	}
	
	/**
	 * start() : start the thread if its not already running
	 */
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		run();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		long previousTime = System.nanoTime();
		final double numTicks = 60.0; // fps
		double ns = 1000000000 / numTicks;
		double delta = 0;
		
		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - previousTime) / ns;
			previousTime = currentTime;
			
			if(delta >= 1) {
				/* Here we do the loop calculations ie. timer, and state checks */
				tick();
				delta--;
			}
			
			/* Here we handle the game logic for each loop iteration */
			render(); 
		}
		stop();
	}
	
	/**
	 * stop() : stop the thread if its not already stopped 
	 */
	public synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) { e.printStackTrace(); }
		System.exit(1);
	} 

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(gameEngine.getState()) {
		case START_MENU:
			break;
		case GAME:
			if(running) 
				gameKeyPressed(e);
			break;
		case PAUSE_MENU:
			System.out.println("GAME PAUSED");
			if(e.getKeyCode() == KeyEvent.VK_P) {
				gameEngine.setState(State.GAME);
			}
			break;
		default:
			break;
			
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * tick() :
	 */
	private void tick() {
		// Testing game loop
		if(gameEngine.getState() != State.PAUSE_MENU) {
			gameEngine.decrementTimer();
			if(gameEngine.getTime() <= 0) {
				System.out.println("Time Up");
				gameEngine.setState(State.END_LEVEL);
				gameEngine.addPoints(-100);
				gameEngine.resetTimer();
			}
		}
		// Testing game loop
	}
	
	/**
	 * render() :
	 */
	private void render() {
		// should contain switch statement of the game states and call the correct keypressed methods
	}
	
	private void gameKeyPressed(KeyEvent e) {
		boolean out = false;
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				out = gamePanel.matches(1,0,gameEngine.popStack());
				gameEngine.resetTimer();
				break;
			case KeyEvent.VK_DOWN:
				out = gamePanel.matches(1,2,gameEngine.popStack());
				gameEngine.resetTimer();
				break;
			case KeyEvent.VK_LEFT:
				out = gamePanel.matches(0,1,gameEngine.popStack());
				gameEngine.resetTimer();
				break;
			case KeyEvent.VK_RIGHT:
				out = gamePanel.matches(2,1,gameEngine.popStack());
				gameEngine.resetTimer();
				break;
			case KeyEvent.VK_SPACE:
				break;
			case KeyEvent.VK_P:
				gameEngine.setState(State.PAUSE_MENU);
				break;
			case KeyEvent.VK_ESCAPE:
				stop();
				break;
			default:
				break;
		}
		
		System.out.println(out);
		if(out) {gameEngine.addPoints(100);} else {gameEngine.addPoints(-100);}
		gamePanel.addPattern(1,1,gameEngine.topStack());
		gamePanel.repaint();
		gameEngine.checkLevelEnd();
	}
}
