package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pattern.Patterns;

public class WindowFrame implements KeyListener {
	
	private static final String gameTitle = "StackDotPop";
	private int frameHeight = 480;
	private int frameWidth = 720;
	
	private JFrame frame;
	private GUI gui;
	private PatternStack stack;
	
	
	private double timer = 0;
	private int score = 0;
	private int level = 1;
		
	public WindowFrame() {
		// Init frame defaults
		frame = new JFrame(gameTitle);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.setIconImage(new ImageIcon("icon.png").getImage());
		
		frame.setLayout(new BorderLayout());
		
		gui = new GUI();
		stack = gui.getPatternStack();
		
		frame.add(gui.getPanel(CardinalLocation.NORTH).getJPanel(), BorderLayout.NORTH);
		frame.add(gui.getPanel(CardinalLocation.SOUTH).getJPanel(), BorderLayout.SOUTH);
		frame.add(gui.getPanel(CardinalLocation.EAST).getJPanel(), BorderLayout.EAST);
		frame.add(gui.getPanel(CardinalLocation.WEST).getJPanel(), BorderLayout.WEST);
	
		frame.add(stack.getJPanel(), BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		
		
		startGame();
	}
	
	public void startGame() {
		// count down
		
		frame.addKeyListener(this);
		//endGame();
	}
	
	public void endGame() {
		System.out.println("GameOver");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String out = "null";
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				Patterns p = stack.pop();
				System.out.println(p.getPatternName() + gui.getPanel(CardinalLocation.NORTH).getPattern().getPatternName());
				out = gui.getPanel(CardinalLocation.NORTH).patternMatches(p) ? "true":"false";
				break;
			case KeyEvent.VK_DOWN:
				Patterns p1 = stack.pop();
				System.out.println(p1.getPatternName() + gui.getPanel(CardinalLocation.SOUTH).getPattern().getPatternName());
				out = gui.getPanel(CardinalLocation.SOUTH).patternMatches(p1) ? "true":"false";
				break;
			case KeyEvent.VK_LEFT:
				Patterns p2 = stack.pop();
				System.out.println(p2.getPatternName() + gui.getPanel(CardinalLocation.WEST).getPattern().getPatternName());
				out = gui.getPanel(CardinalLocation.WEST).patternMatches(p2) ? "true":"false";
				break;
			case KeyEvent.VK_RIGHT:
				Patterns p3 = stack.pop();
				System.out.println(p3.getPatternName() + gui.getPanel(CardinalLocation.EAST).getPattern().getPatternName());
				out = gui.getPanel(CardinalLocation.EAST).patternMatches(p3) ? "true":"false";
				break;
			case KeyEvent.VK_SPACE:
				break;
			case KeyEvent.VK_ESCAPE:
				endGame();
				break;
			default:
				break;
		}
		
		if(out == "true") {
			score++;
			System.out.println(out);
		} else {
			System.out.println("Error");
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
}
