import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
	
	//cypher variables
	String wordIn;
	String wordOut="";
	String message;
	int key;
	
	//frame variables
	private JTextArea messageIn;
	private JTextArea messageOut;
	private JTextField keyIn;
	private JButton decypher;
	private JButton cypher;

	private JLabel title;
	
	public Gui() {
		createView();
		
		setTitle("Caesar Cypher");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(480,420);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void createView() {
		JPanel panel=new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		
		//title
		Font f=new Font("TimesRoman",Font.ITALIC,42);
		title=new JLabel("Caesar Cypher");
		title.setForeground(Color.red);
		title.setFont(f);
		panel.add(title);
		
		//input area
		messageIn=new JTextArea();
		messageIn.setLineWrap(true);
		messageIn.setWrapStyleWord(true);
		
		JScrollPane scrollPane=new JScrollPane(messageIn);
		scrollPane.setPreferredSize(new Dimension(420,108));
		panel.add(scrollPane);
		
		//buttons and key input
		//encrypt
		cypher=new JButton("Encrypt");
		cypher.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						wordIn=messageIn.getText().toUpperCase();
						key=Integer.parseInt(keyIn.getText());
						
						messageOut.setText(Cypher.encrypt(wordIn,wordOut,key));
						
					}
					
				});
		panel.add(cypher);
		
		//key
		keyIn=new JTextField();
		keyIn.setPreferredSize(new Dimension(36,36));
		panel.add(keyIn);
		
		//decrypt
		decypher=new JButton("Decrypt");
		decypher.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						wordIn=messageIn.getText().toUpperCase();
						key=Integer.parseInt(keyIn.getText());
						
						messageOut.setText(Cypher.decrypt(wordIn,wordOut,key));
						
					}
					
				});
		panel.add(decypher);
		
		
		//Message Out
		messageOut=new JTextArea();
		messageOut.setLineWrap(true);
		messageOut.setWrapStyleWord(true);
		messageOut.setEditable(false);
		
		JScrollPane scrollPaneOut=new JScrollPane(messageOut);
		scrollPaneOut.setPreferredSize(new Dimension(420,108));
		panel.add(scrollPaneOut);
	}
}
