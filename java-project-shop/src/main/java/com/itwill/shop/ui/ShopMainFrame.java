package com.itwill.shop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ShopMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainParentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 326);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("로그인");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog=new LoginDialog();
				loginDialog.setShopMainFrame(ShopMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("로그아웃");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("종료");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setVgap(1);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		menuPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(menuPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("홈");
		lblNewLabel.setOpaque(true);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			boolean selected=false;
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "HOME");
				selected=!selected;
				if(selected) {
					lblNewLabel.setBackground(Color.GRAY);
					System.out.println("true");
					
				}else {
					lblNewLabel.setBackground(Color.ORANGE);
					System.out.println("true");
				}
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\itwill\\Pictures\\back-30.png"));
		menuPanel.add(btnNewButton);
		lblNewLabel.setIgnoreRepaint(true);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("추석");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "CHUSUK");
			}
		});
		lblNewLabel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel_1.setIgnoreRepaint(true);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("특가");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "SPECIAL");
			}
		});
		lblNewLabel_2.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("베스트");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "BEST");
			}
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Pictures\\arrow-right-30.png"));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		menuPanel.add(btnNewButton_1);
		
		mainParentPanel = new JPanel();
		mainParentPanel.setBackground(Color.PINK);
		contentPane.add(mainParentPanel, BorderLayout.CENTER);
		mainParentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.YELLOW);
		mainParentPanel.add(homePanel, "HOME");
		
		JPanel chusukPanel = new JPanel();
		chusukPanel.setBackground(Color.LIGHT_GRAY);
		mainParentPanel.add(chusukPanel, "CHUSUK");
		
		JPanel specialPricePanel = new JPanel();
		specialPricePanel.setBackground(Color.ORANGE);
		mainParentPanel.add(specialPricePanel, "SPECIAL");
		
		JPanel bestPanel = new JPanel();
		bestPanel.setBackground(SystemColor.activeCaption);
		mainParentPanel.add(bestPanel, "BEST");
	}

}