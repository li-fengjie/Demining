import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextField.*;
import javax.swing.event.*;
import java.math.*;
import java.lang.Integer.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Demining extends JFrame implements ActionListener , MouseListener{
	public JButton map[][];
	public int vis[][], oper[][];
	public String num[] = {"0.jpg","1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg"};
	public int count = 1;
	public Demining(){
		super("扫雷");
		this.setBounds(600,600,600,600);
		this.setResizable(false);
		this.setBackground(java.awt.Color.lightGray);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(10,10));
		this.map = new JButton[10][10];
		this.vis = new int[10][10];
		this.oper = new int[10][10];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				vis[i][j] = 0;
				oper[i][j] = 0;
			}
		}
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				this.add(this.map[i][j] = new JButton());
				map[i][j].addActionListener(this);
				map[i][j].addMouseListener(this);
				// map[i][j].setIcon(new ImageIcon("sl.png"));
			}
		}
		for(int i = 0; i < 10; i++){
			int x, y;
			x = (int)(Math.random()*10);
			y = (int)(Math.random()*10);
			if(vis[x][y] == -1)
				i--;
			vis[x][y] = -1;
			//bmap[x][y].setIcon(new ImageIcon("M.jpg"));
		}
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(vis[i][j] == -1){
					get_num(i,j);
				}
			}
		}
		this.setVisible(true);
	}
	public void get_num(int x, int y){
		int xx = x + 0;
		int yy = y + 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x + 1;
		yy = y + 0;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x - 1;
		yy = y + 0;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x + 0;
		yy = y - 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x + 1;
		yy = y + 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x - 1;
		yy = y - 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x - 1;
		yy = y + 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
		xx = x + 1;
		yy = y - 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && vis[xx][yy] != -1){
			vis[xx][yy] ++;
		}
	}
	public void dfs(int x, int y){
		int xx = x + 0;
		int yy = y + 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x + 1;
		yy = y + 0;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x - 1;
		yy = y + 0;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x + 0;
		yy = y - 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x + 1;
		yy = y + 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x - 1;
		yy = y - 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x - 1;
		yy = y + 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
		xx = x + 1;
		yy = y - 1;
		if(xx >= 0 && xx <= 9 && yy >= 0 && yy <= 9 && oper[xx][yy] == 0){
			if(vis[xx][yy] == 0 ){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[0]));
				dfs(xx,yy);
			}
			if(vis[xx][yy] != 0){
				oper[xx][yy] = 1;
				map[xx][yy].setIcon(new ImageIcon(num[vis[xx][yy]]));
			}
		}
	}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(e.getSource() == map[i][j] && e.getButton() == MouseEvent.BUTTON3){
					if(count%2 == 0)
						map[i][j].setIcon(new ImageIcon());
					else 
						map[i][j].setIcon(new ImageIcon("mark.jpg"));
					count++;
				}
			}
		}
	}
	public void actionPerformed(ActionEvent ev){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(ev.getSource() == map[i][j] && oper[i][j] != 1){
					oper[i][j] = 1;
					if(vis[i][j] == -1){
						for(int r = 0; r < 10; r++){
							for(int l = 0; l < 10; l++){
								if(vis[r][l] == -1){
									oper[r][l] = 1;
									map[r][l].setIcon(new ImageIcon("M.jpg"));
								}
							}
						}
						int T = JOptionPane.showConfirmDialog(this, "您输了！ 再来一局?");
						if(T == 0){
							for(int r = 0; r < 10; r++){
								for(int l = 0; l < 10; l++){
									oper[r][l] = 0;
									vis[r][l] = 0;
									map[r][l].setIcon(new ImageIcon());
								}
							}
							for(int k = 0; k < 10; k++){
								int x, y;
								x = (int)(Math.random()*10);
								y = (int)(Math.random()*10);
								if(vis[x][y] == -1)
									k--;
								vis[x][y] = -1;
								// map[x][y].setIcon(new ImageIcon("M.jpg"));
							}
							for(int r = 0; r < 10; r++){
								for(int l = 0; l < 10; l++){
									if(vis[r][l] == -1)
										get_num(r,l);
								}
							}
						}
						else System.exit(0);
						return ;
					}
						// JOptionPane.showConfirmDialog(this, "您输了！ 终止程序？ ", "确认", JOptionPane.YES_NO_OPTION);
					if(vis[i][j] == 0){
						map[i][j].setIcon(new ImageIcon(num[0]));
						dfs(i,j);
						boolean w = true;
						for(int r = 0; r < 10; r++){
							for(int l = 0; l < 10; l++){
								if(vis[r][l] != -1 && oper[r][l] == 0)
									w = false;
							}
						}
						if(w == true){
							int T = JOptionPane.showConfirmDialog(this, "您赢了！ 再来一局?");
		 					if(T == 0){
								for(int r = 0; r < 10; r++){
									for(int l = 0; l < 10; l++){
										oper[r][l] = 0;
										vis[r][l] = 0;
										map[r][l].setIcon(new ImageIcon());
									}
								}
								for(int k = 0; k < 10; k++){
									int x, y;
									x = (int)(Math.random()*10);
									y = (int)(Math.random()*10);
									if(vis[x][y] == -1)
										k--;
									vis[x][y] = -1;
									// map[x][y].setIcon(new ImageIcon("M.jpg"));
								}
								for(int r = 0; r < 10; r++){
									for(int l = 0; l < 10; l++){
										if(vis[r][l] == -1)
											get_num(r,l);
									}
								}
							}
							else System.exit(0);
							return ;
						}
					}
					for(int k = 1; k <= 8; k++){
						if(vis[i][j] == k){
							map[i][j].setIcon(new ImageIcon(num[k]));
							boolean w = true;
							for(int r = 0; r < 10; r++){
								for(int l = 0; l < 10; l++){
									if(vis[r][l] != -1 && oper[r][l] == 0)
										w = false;
								}
							}
							if(w == true){
								int T = JOptionPane.showConfirmDialog(this, "您赢了！ 再来一局?");
		 						if(T == 0){
									for(int r = 0; r < 10; r++){
										for(int l = 0; l < 10; l++){
											oper[r][l] = 0;
											vis[r][l] = 0;
											map[r][l].setIcon(new ImageIcon());
										}
									}
									for(int t = 0; t < 10; t++){
										int x, y;
										x = (int)(Math.random()*10);
										y = (int)(Math.random()*10);
										if(vis[x][y] == -1)
											t--;
										vis[x][y] = -1;
										// map[x][y].setIcon(new ImageIcon("M.jpg"));
									}
									for(int r = 0; r < 10; r++){
										for(int l = 0; l < 10; l++){
											if(vis[r][l] == -1)
												get_num(r,l);
										}
									}
								}
								else System.exit(0);
								return ;
							}
						}
					}
				}
			}
		}
	}
	public static void main(String args[]){
		new Demining();
	}
}