import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	private boolean player_1_turn = true;
	private int possible_attempts = 9;
	private int grid[] = new int[9];
	
	public JLabel Turn = new JLabel("");
	public JLabel Winner = new JLabel("");
	double firstTurn = 0;
	public JButton grid_1 = new JButton("");		
	public JButton grid_2 = new JButton("");		
	public JButton grid_3 = new JButton("");		
	public JButton grid_4 = new JButton("");		
	public JButton grid_5 = new JButton("");		
	public JButton grid_6 = new JButton("");		
	public JButton grid_7 = new JButton("");		
	public JButton grid_8 = new JButton("");		
	public JButton grid_9 = new JButton("");	
	public JButton resetButton = new JButton("Reset");	
	
	private boolean AI_bool = false;
	
	public int score_p1 = 0;
	public int score_p2 = 0;
	
	private boolean[] used = new boolean[9];
	
	public void test() {
		
		for(int i=0; i < 9;i++) {
			grid[i] = 0;
			used[i] = false;
		}
		grid_1.setBackground(Color.white);
		grid_2.setBackground(Color.white);
		grid_3.setBackground(Color.white);
		grid_4.setBackground(Color.white);
		grid_5.setBackground(Color.white);
		grid_6.setBackground(Color.white);
		grid_7.setBackground(Color.white);
		grid_8.setBackground(Color.white);
		grid_9.setBackground(Color.white);	
		possible_attempts = 9;	
	}
	int randomNum = 0;
	private void AI() {
		if(!player_1_turn) {
			player_1_turn = true;
			if(possible_attempts == 9 ) {
				randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
				
				switch(randomNum) {
				case 0:			
					grid_1.setBackground(Color.green);
					break;
				case 1:
					grid_2.setBackground(Color.green);
					break;
				case 2:
					grid_3.setBackground(Color.green);
					break;
				case 3:
					grid_4.setBackground(Color.green);
					break;
				case 4:
					grid_5.setBackground(Color.green);
					break;
				case 5:
					grid_6.setBackground(Color.green);
					break;
				case 6:
					grid_7.setBackground(Color.green);
					break;
				case 7:
					grid_8.setBackground(Color.green);
					break;
				case 8:
					grid_9.setBackground(Color.green);
					break;
				default: 
					break;			
				}				
				grid[randomNum] = -1;
				
				if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
			}else {
				if(possible_attempts == 8 && grid[4] == 1) {
					randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
					
					switch(randomNum) {
						case 1:
							grid_1.setBackground(Color.green);
							grid[0] = -1;						
							break;
						case 2:
							grid_3.setBackground(Color.green);
							grid[2] = -1;
							break;
						case 3:
							grid_7.setBackground(Color.green);
							grid[6] = -1;
							break;
						case 4:
							grid_9.setBackground(Color.green);
							grid[8] = -1;
							break;
						default:
							break;
					}	
					player_1_turn = true;
				
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}else{
						if(possible_attempts < 8 || possible_attempts == 8 && grid[4] != 1) {
							for(int i = 0; i < 9; i++) {
								if(grid[i]!=0)used[i] = true;
							}
							
							
							
							
							randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
						
							
							
							
						do {
							randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
							
						}while(used[randomNum]);
						
							
									
								switch(randomNum) {
								case 0:			
									grid_1.setBackground(Color.green);
									break;
								case 1:
									grid_2.setBackground(Color.green);
									break;
								case 2:
									grid_3.setBackground(Color.green);
									break;
								case 3:
									grid_4.setBackground(Color.green);
									break;
								case 4:
									grid_5.setBackground(Color.green);
									break;
								case 5:
									grid_6.setBackground(Color.green);
									break;
								case 6:
									grid_7.setBackground(Color.green);
									break;
								case 7:
									grid_8.setBackground(Color.green);
									break;
								case 8:
									grid_9.setBackground(Color.green);
									break;
								default: 
									break;			
								}
								grid[randomNum] = -1;
								
							
							
						}
						
						player_1_turn = true;
						if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
					}
				
				}
			possible_attempts--;

				
				
			}
			
			
		
		
	}
	
	
	public void check() {
		
		if(grid[0] + grid[1] + grid[2] == 3 ||
		grid[3] + grid[4] + grid[5] == 3 ||
		grid[6]+grid[7]+grid[8] == 3 ||
		grid[0] + grid[3] + grid[6] == 3 || 		 
		grid[1]+grid[4]+grid[7]== 3 ||
		grid[2]+grid[5]+grid[8] == 3 ||
		grid[0]+grid[4]+grid[8] == 3 ||
		grid[2]+grid[4]+grid[6] == 3) {
			score_p1++;
			Winner.setText("Player 1: " + score_p1 + " || Player 2: " + score_p2);
			test();
		}
		if(grid[0] + grid[1] + grid[2] == -3 ||
				grid[3] + grid[4] + grid[5] == -3 ||
				grid[6]+grid[7]+grid[8] == -3 ||
				grid[0] + grid[3] + grid[6] == -3 || 		 
				grid[1]+grid[4]+grid[7]== -3 ||
				grid[2]+grid[5]+grid[8] == -3 ||
				grid[0]+grid[4]+grid[8] == -3 ||
				grid[2]+grid[4]+grid[6] == -3) {
				score_p2++;
				Winner.setText("Player 1: " + score_p1 + " || Player 2: " + score_p2);
				test();
				}
		if(possible_attempts == 0) test();
		AI();
	}
	
	public void reset() {

		test();
		firstTurn = Math.random() * (100 - 1 + 1) + 1;
		if(firstTurn>50)player_1_turn = false;else player_1_turn = true;
		score_p1 = 0;
		score_p2 = 0;
		Winner.setText("Player 1: " + score_p1 + " || Player 2: " + score_p2);
		if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
		if(!player_1_turn)AI();
	}
	public GUI() {
		
		
		firstTurn = Math.random() * (100 - 1 + 1) + 1;
		
		if(firstTurn>50)player_1_turn = false;
		Winner.setText("Player 1: " + score_p1 + " || Player 2: " + score_p2);
		test();
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		
		panel.setLayout(null);
		grid_1.setBounds(10, 10, 100, 100);	
		grid_2.setBounds(110, 10, 100, 100);
		grid_3.setBounds(210, 10, 100, 100);
		grid_4.setBounds(10, 110, 100, 100);
		grid_5.setBounds(110, 110, 100, 100);
		grid_6.setBounds(210, 110, 100, 100);
		grid_7.setBounds(10, 210, 100, 100);
		grid_8.setBounds(110, 210, 100, 100);
		grid_9.setBounds(210, 210, 100, 100);
		panel.add(grid_1);
		panel.add(grid_2);
		panel.add(grid_3);
		panel.add(grid_4);
		panel.add(grid_5);
		panel.add(grid_6);
		panel.add(grid_7);
		panel.add(grid_8);
		panel.add(grid_9);
		frame.setBounds(10,10,700,900);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("out GUI");
		frame.pack();
		frame.setVisible(true);		
		grid_1.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {					
			
	
				if(grid[0] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_1.setBackground(Color.black);				
						grid[0] = 1;
					}else {
						grid_1.setBackground(Color.green);	
						grid[0] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
				
			}          
		});
		grid_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[1] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_2.setBackground(Color.black);						
						grid[1] = 1;
					}else {
						grid_2.setBackground(Color.green);	
						grid[1] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}    
		});
		grid_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[2] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_3.setBackground(Color.black);						
						grid[2] = 1;
					}else {
						grid_3.setBackground(Color.green);	
						grid[2] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		grid_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[3] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_4.setBackground(Color.black);						
						grid[3] = 1;
					}else {
						grid_4.setBackground(Color.green);	
						grid[3] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		grid_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[4] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_5.setBackground(Color.black);						
						grid[4] = 1;
						player_1_turn = !player_1_turn;
					}else {
						grid_5.setBackground(Color.green);	
						grid[4] = -1;
						player_1_turn = !player_1_turn;
					}
					
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		grid_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[5] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_6.setBackground(Color.black);						
						grid[5] = 1;
					}else {
						grid_6.setBackground(Color.green);	
						grid[5] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		grid_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[6] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_7.setBackground(Color.black);						
						grid[6] = 1;
					}else {
						grid_7.setBackground(Color.green);	
						grid[6] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		grid_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[7] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_8.setBackground(Color.black);						
						grid[7] = 1;
					}else {
						grid_8.setBackground(Color.green);	
						grid[7] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		grid_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				if(grid[8] == 0) {
					possible_attempts--;
					if(player_1_turn) {
						grid_9.setBackground(Color.black);						
						grid[8] = 1;
					}else {
						grid_9.setBackground(Color.green);	
						grid[8] = -1;
					}
					player_1_turn = !player_1_turn;
					if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
				}
				check();
			}   
		});
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				reset();
			}   
		});
		
		
		Turn.setBounds(350, 10, 100, 100);
		Winner.setBounds(480,30,500,100);
		resetButton.setBounds(510,10,100,20);
		if(player_1_turn)Turn.setText("player 1");else Turn.setText("player 2");
		panel.add(Turn);
		panel.add(Winner);
		panel.add(resetButton);
		
	
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			new GUI();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
