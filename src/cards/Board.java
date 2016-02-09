package cards;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public abstract class Board extends JFrame implements ActionListener{
	
	protected boolean[] selected;
	protected Card[] up;
	protected Cards deck;
	protected ListeningLabel[] labels;
	
	protected final Cards selectedCards = new Cards();
	protected final int boardSize;
	
	private final JButton restart  = new JButton("Restart");
	private final JLabel cardsLeft = new JLabel();
	private final JLabel timeLeft = new JLabel();
	private final Timer timer;
	private final TimerListener timerListener;

	private JPanel buttonPanel	= new JPanel();
	private JPanel menuPanel	= new JPanel();
	
	protected final static JPanel emptyPanel=new JPanel();
	protected final static Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
	protected final static Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	
	static{
		emptyPanel.setBackground(Color.WHITE);
	}
	
	public Board(String title, int buttonPanelLayoutRows, int buttonPanelLayoutColumns, int boardSize){
		super(title);
		
		setLayout(new FlowLayout());

		this.boardSize=boardSize;
		
		restart.addActionListener(this);

		buttonPanel.setLayout(new GridLayout(buttonPanelLayoutRows,buttonPanelLayoutColumns));
		buttonPanel.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(20,20,20,20),
			BorderFactory.createLineBorder(Color.BLACK)
		));
		buttonPanel.setBackground(Color.WHITE);

		menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.PAGE_AXIS));
		menuPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		menuPanel.add(restart, SwingConstants.CENTER);
		menuPanel.add(cardsLeft, SwingConstants.CENTER);
		menuPanel.add(timeLeft, SwingConstants.CENTER);
		menuPanel.setBackground(Color.WHITE);

		add(buttonPanel);
		add(menuPanel);
		
		timerListener = new TimerListener();
		timer = new Timer(1000, timerListener);
		
		reset();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		timer.start();
	}
	public void removeSelected(int index){
		for(int i = 0; i < 11; i++){
			if(selected[i]){
				try{
					up[i]=deck.remove(0);		
					labels[i].setText(up[i].toHTMLString());						
				}catch(IndexOutOfBoundsException e){
					up[i]=null;
					buttonPanel.remove(labels[i]);
					buttonPanel.add(emptyPanel);
					buttonPanel.revalidate();
					buttonPanel.repaint();
				}
				selected[i]=false;		
				labels[i].labelMouseAdapter.deselect(i==index);					
			}
		}
		selectedCards.clear();
		refreshCardsLeft();
	}
	public void remove(int i,boolean mouseIsOver){
		selectedCards.remove(i);
		try{
			up[i]=deck.remove(0);		
			labels[i].setText(up[i].toHTMLString());						
		}catch(IndexOutOfBoundsException e){
			up[i]=null;
			buttonPanel.remove(labels[i]);
			buttonPanel.add(emptyPanel);
			buttonPanel.revalidate();
			buttonPanel.repaint();
		}
		selected[i]=false;		
		labels[i].labelMouseAdapter.deselect(mouseIsOver);	
	}
	public void deselect(int index){
		selectedCards.clear();
		for(int i = 0; i < 11; i++){
			if(selected[i]){
				labels[i].labelMouseAdapter.deselect(i==index);
			}
		}
		selected=new boolean[11];
	}
	protected final void reset(){
		buttonPanel.removeAll();
		
		selected = new boolean[boardSize];

		up = new Card[boardSize];
		deck=Cards.DECK.shuffle();
		labels=new ListeningLabel[boardSize];
		
		for(int i = 0; i < boardSize; i++){
			up[i]=deck.remove(0);
			labels[i]=new ListeningLabel(up[i].toHTMLString(), this, i,SwingConstants.CENTER);
			labels[i].setCursor(HAND_CURSOR);
			labels[i].setOpaque(true);
			labels[i].setBackground(Color.WHITE);
			labels[i].setBorder(paddingBorder);
			Dimension Preferred = labels[i].getPreferredSize();
			labels[i].setPreferredSize(new Dimension(50,Preferred.height));
			
			if(isEmptyButton(i))buttonPanel.add(emptyPanel);
			buttonPanel.add(labels[i]);
		}
		
		cardsLeft.setText("Cards Left: "+deck.size());
		
		init();
		
		timerListener.count=0;

		revalidate();
		validate();
		repaint();
		pack();
	}
	private void refreshCardsLeft(){
		cardsLeft.setText("Cards Left: "+deck.size());
		for(int i = 0; i < 11; i++){
			if(up[i]!=null){
				return;
			}
		}
		setVisible(false);
		int response=JOptionPane.showConfirmDialog(null,"Congratulations! Play again?", "You Win!", JOptionPane.YES_NO_OPTION);
		if(response==JOptionPane.YES_OPTION){
			reset();
			setVisible(true);
		}else{
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent e){
		reset();
	}
	protected void init(){}
	protected void click(int index){
		if(selected[index]){
			selected[index]=false;
			labels[index].labelMouseAdapter.deselect(true);
			selectedCards.remove(selectedCards.indexOf(up[index]));
		}else{
			selected[index]=true;
			labels[index].labelMouseAdapter.select(true);
			selectedCards.add(up[index]);
			onSelect(index);
		}
	}
	protected abstract void onSelect(int index);
	protected static boolean isEmptyButton(int i){return false;}
	
	private class TimerListener implements ActionListener{
		int count=0;
		public TimerListener(){
			timeLeft.setText("0");
		}
		public void reset(){
			timeLeft.setText("0");
			count=0;
		}
		public void actionPerformed(ActionEvent e){
			count+=1;
			timeLeft.setText(Integer.toString(count));
		}
	}
}