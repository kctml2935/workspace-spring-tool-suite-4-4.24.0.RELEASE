package lecture.service.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class LectureMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LectureMainFrame frame = new LectureMainFrame();
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
	public LectureMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 402);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("로그인");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog = new LoginDialog();
				loginDialog.setLectureMainFrame(LectureMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel recommendedPanel = new JPanel();
		tabbedPane.addTab("추천강의", null, recommendedPanel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(390, 780));
		recommendedPanel.add(scrollPane);
		
		JPanel recommendedcontentpanel = new JPanel();
		recommendedcontentpanel.setPreferredSize(new Dimension(390, 780));
		recommendedcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setColumnHeaderView(recommendedcontentpanel);
		recommendedcontentpanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 5, 170, 190);
		panel.setPreferredSize(new Dimension(170, 190));
		recommendedcontentpanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("여기에 강의명 입력");
		lblNewLabel.setBounds(12, 155, 132, 25);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("수강버튼");
		btnNewButton.setBounds(12, 122, 97, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\java.jpg"));
		lblNewLabel_1.setBounds(12, 10, 112, 83);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(197, 5, 170, 190);
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(170, 190));
		recommendedcontentpanel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("여기에 강의명 입력");
		lblNewLabel_2.setBounds(12, 155, 132, 25);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("수강버튼");
		btnNewButton_1.setBounds(12, 122, 97, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\photoshop.jpg"));
		lblNewLabel_4.setBounds(12, 10, 113, 82);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 205, 170, 190);
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(170, 190));
		recommendedcontentpanel.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("여기에 강의명 입력");
		lblNewLabel_3.setBounds(12, 155, 132, 25);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("이미지 넣는곳");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\3DSMAX.jpg"));
		lblNewLabel_1_2.setBounds(12, 10, 107, 82);
		panel_2.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("수강버튼");
		btnNewButton_2.setBounds(12, 122, 97, 23);
		panel_2.add(btnNewButton_2);
		
		JPanel category1 = new JPanel();
		tabbedPane.addTab("프로그래밍", null, category1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(390, 780));
		category1.add(scrollPane_1);
		
		JPanel programmingcontentpanel = new JPanel();
		programmingcontentpanel.setLayout(null);
		programmingcontentpanel.setPreferredSize(new Dimension(390, 780));
		programmingcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.setColumnHeaderView(programmingcontentpanel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(170, 190));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(12, 5, 170, 190);
		programmingcontentpanel.add(panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("여기에 강의명 입력");
		lblNewLabel_5.setBounds(12, 155, 132, 25);
		panel_3.add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("수강버튼");
		btnNewButton_3.setBounds(12, 122, 97, 23);
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\java.jpg"));
		lblNewLabel_1_1.setBounds(12, 10, 112, 83);
		panel_3.add(lblNewLabel_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setPreferredSize(new Dimension(170, 190));
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(197, 5, 170, 190);
		programmingcontentpanel.add(panel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_2_1.setBounds(12, 155, 132, 25);
		panel_1_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1_1 = new JButton("수강버튼");
		btnNewButton_1_1.setBounds(12, 122, 97, 23);
		panel_1_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\itwill\\Desktop\\c++.png"));
		lblNewLabel_4_1.setBounds(12, 10, 113, 82);
		panel_1_1.add(lblNewLabel_4_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setPreferredSize(new Dimension(170, 190));
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(12, 205, 170, 190);
		programmingcontentpanel.add(panel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_3_1.setBounds(12, 155, 132, 25);
		panel_2_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_2_1 = new JButton("수강버튼");
		btnNewButton_2_1.setBounds(12, 122, 97, 23);
		panel_2_1.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(12, 50, 57, 15);
		panel_2_1.add(lblNewLabel_6);
		
		JPanel category2 = new JPanel();
		tabbedPane.addTab("3D디자인", null, category2, null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setPreferredSize(new Dimension(390, 780));
		category2.add(scrollPane_1_1);
		
		JPanel designcontentpanel = new JPanel();
		designcontentpanel.setLayout(null);
		designcontentpanel.setPreferredSize(new Dimension(390, 780));
		designcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1_1.setColumnHeaderView(designcontentpanel);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setPreferredSize(new Dimension(170, 190));
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBounds(12, 5, 170, 190);
		designcontentpanel.add(panel_3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_5_1.setBounds(12, 155, 132, 25);
		panel_3_1.add(lblNewLabel_5_1);
		
		JButton btnNewButton_3_1 = new JButton("수강버튼");
		btnNewButton_3_1.setBounds(12, 122, 97, 23);
		panel_3_1.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(12, 10, 112, 83);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setPreferredSize(new Dimension(170, 190));
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(197, 5, 170, 190);
		designcontentpanel.add(panel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_2_1_1.setBounds(12, 155, 132, 25);
		panel_1_1_1.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("수강버튼");
		btnNewButton_1_1_1.setBounds(12, 122, 97, 23);
		panel_1_1_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setBounds(12, 10, 113, 82);
		panel_1_1_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setPreferredSize(new Dimension(170, 190));
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1.setBounds(12, 205, 170, 190);
		designcontentpanel.add(panel_2_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_3_1_1.setBounds(12, 155, 132, 25);
		panel_2_1_1.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_2_1_1 = new JButton("수강버튼");
		btnNewButton_2_1_1.setBounds(12, 122, 97, 23);
		panel_2_1_1.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("New label");
		lblNewLabel_6_1.setBounds(12, 50, 57, 15);
		panel_2_1_1.add(lblNewLabel_6_1);
		
		JPanel panel_2_1_1_1_2 = new JPanel();
		panel_2_1_1_1_2.setLayout(null);
		panel_2_1_1_1_2.setPreferredSize(new Dimension(170, 190));
		panel_2_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1_1_2.setBounds(197, 205, 170, 190);
		designcontentpanel.add(panel_2_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("여기에 강의명 입력");
		lblNewLabel_3_1_1_1_2.setBounds(12, 155, 132, 25);
		panel_2_1_1_1_2.add(lblNewLabel_3_1_1_1_2);
		
		JButton btnNewButton_2_1_1_1_2 = new JButton("수강버튼");
		btnNewButton_2_1_1_1_2.setBounds(12, 122, 97, 23);
		panel_2_1_1_1_2.add(btnNewButton_2_1_1_1_2);
		
		JLabel lblNewLabel_6_1_1_2 = new JLabel("New label");
		lblNewLabel_6_1_1_2.setBounds(12, 50, 57, 15);
		panel_2_1_1_1_2.add(lblNewLabel_6_1_1_2);
		
		JPanel category3 = new JPanel();
		tabbedPane.addTab("사진/영상", null, category3, null);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setPreferredSize(new Dimension(390, 780));
		category3.add(scrollPane_1_1_1);
		
		JPanel photocontentpanel = new JPanel();
		photocontentpanel.setLayout(null);
		photocontentpanel.setPreferredSize(new Dimension(390, 780));
		photocontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1_1_1.setColumnHeaderView(photocontentpanel);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setPreferredSize(new Dimension(170, 190));
		panel_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1_1.setBounds(12, 5, 170, 190);
		photocontentpanel.add(panel_3_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_5_1_1.setBounds(12, 155, 132, 25);
		panel_3_1_1.add(lblNewLabel_5_1_1);
		
		JButton btnNewButton_3_1_1 = new JButton("수강버튼");
		btnNewButton_3_1_1.setBounds(12, 122, 97, 23);
		panel_3_1_1.add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setBounds(12, 10, 112, 83);
		panel_3_1_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setPreferredSize(new Dimension(170, 190));
		panel_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1.setBounds(197, 5, 170, 190);
		photocontentpanel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_2_1_1_1.setBounds(12, 155, 132, 25);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("수강버튼");
		btnNewButton_1_1_1_1.setBounds(12, 122, 97, 23);
		panel_1_1_1_1.add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1.setBounds(12, 10, 113, 82);
		panel_1_1_1_1.add(lblNewLabel_4_1_1_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setPreferredSize(new Dimension(170, 190));
		panel_2_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1_1.setBounds(12, 205, 170, 190);
		photocontentpanel.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_3_1_1_1.setBounds(12, 155, 132, 25);
		panel_2_1_1_1.add(lblNewLabel_3_1_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("수강버튼");
		btnNewButton_2_1_1_1.setBounds(12, 122, 97, 23);
		panel_2_1_1_1.add(btnNewButton_2_1_1_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("New label");
		lblNewLabel_6_1_1.setBounds(12, 50, 57, 15);
		panel_2_1_1_1.add(lblNewLabel_6_1_1);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setPreferredSize(new Dimension(170, 190));
		panel_2_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1_1_1.setBounds(197, 205, 170, 190);
		photocontentpanel.add(panel_2_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("여기에 강의명 입력");
		lblNewLabel_3_1_1_1_1.setBounds(12, 155, 132, 25);
		panel_2_1_1_1_1.add(lblNewLabel_3_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("수강버튼");
		btnNewButton_2_1_1_1_1.setBounds(12, 122, 97, 23);
		panel_2_1_1_1_1.add(btnNewButton_2_1_1_1_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("New label");
		lblNewLabel_6_1_1_1.setBounds(12, 50, 57, 15);
		panel_2_1_1_1_1.add(lblNewLabel_6_1_1_1);
		
		JPanel userpanel = new JPanel();
		tabbedPane.addTab("", new ImageIcon("C:\\Users\\itwill\\Pictures\\user20.png"), userpanel, null);
	}
}
