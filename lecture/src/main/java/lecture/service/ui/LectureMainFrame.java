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
		setBounds(100, 100, 450, 400);
		
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton 이미지 = new JButton("New button");
		panel.add(이미지);
		
		JLabel lblNewLabel = new JLabel("강의 목록");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("카테고리");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("수강하기");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel 강의목록 = new JPanel();
		panel_1.add(강의목록, "name_1218171436473600");
		
		JPanel 카테고리 = new JPanel();
		panel_1.add(카테고리, "name_1218179203195400");
		
		JPanel 수강 = new JPanel();
		panel_1.add(수강, "name_1218181731638700");
		
		JPanel 카테고리1 = new JPanel();
		panel_1.add(카테고리1, "name_1218691107974100");
		
		JPanel 카테고리2 = new JPanel();
		panel_1.add(카테고리2, "name_1218693435795000");
		
		JPanel 카테고리3 = new JPanel();
		panel_1.add(카테고리3, "name_1218695532722600");
	}

}
