package lecture.service.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;


import lecture.service.lecture.Lecture;
import lecture.service.lecture.LectureService;
import lecture.service.order.OrderDao;
import lecture.service.order.OrderService;
import lecture.service.userinfo.Userinfo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class LectureMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userid = null;
	private LectureService lectureService;
	private OrderService order;
	private JPanel programmingcontentpanel;
	private JPanel photocontentpanel;
	private JPanel designcontentpanel;
	private JPanel userPanel;
	private JPanel userTitlePanel;
	private JPanel lecturePanel;
	private JPanel recommendedcontentpanel;
	
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
	public void setUserid(String userid) {
		this.userid=userid;
	}
	/**
	 * Create the frame.
	 */
	public LectureMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("로그인");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog = null;
				try {
					loginDialog = new LoginDialog();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loginDialog.setLectureMainFrame(LectureMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("로그아웃");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logout action
                setUserid(null);
            }
        });
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
		recommendedPanel.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("추천강의", null, recommendedPanel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(390, 780));
		recommendedPanel.add(scrollPane);
		
		recommendedcontentpanel = new JPanel();
		recommendedcontentpanel.setPreferredSize(new Dimension(390, 780));
		recommendedcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setViewportView(recommendedcontentpanel);
		recommendedcontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));
		//여기서부터 강의1개 ui패널 디자인
		JPanel lecturePanel = new JPanel();
		lecturePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lecturePanel.setBounds(12, 5, 170, 190);
		lecturePanel.setPreferredSize(new Dimension(170, 190));
		recommendedcontentpanel.add(lecturePanel);
		lecturePanel.setLayout(null);
		
		
		
		JLabel lecturedescLabel = new JLabel("여기에 강의명 입력");
		lecturedescLabel.setBounds(12, 126, 132, 54);
		lecturePanel.add(lecturedescLabel);
		
		JButton lectureAddButton = new JButton("수강버튼");
		lectureAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>강의담기");
			}
		});
		lectureAddButton.setBounds(12, 93, 97, 23);
		lecturePanel.add(lectureAddButton);
		
		JLabel lectureImageLabel = new JLabel("");
		lectureImageLabel.setIcon(new ImageIcon(LectureMainFrame.class.getResource("/images/java.jpg")));
		lectureImageLabel.setBounds(12, 10, 112, 83);
		lecturePanel.add(lectureImageLabel);
		recommendedcontentpanel.add(lecturePanel);
		//끝
		JPanel category1 = new JPanel();
		
		tabbedPane.addTab("프로그래밍", null, category1, null);
		
		JScrollPane lecturecategory1ScrollPanel = new JScrollPane();
		lecturecategory1ScrollPanel.setPreferredSize(new Dimension(390, 780));
		category1.add(lecturecategory1ScrollPanel);
		
		programmingcontentpanel = new JPanel();
		programmingcontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT,7,7));
		programmingcontentpanel.setPreferredSize(new Dimension(390, 780));
		programmingcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lecturecategory1ScrollPanel.setColumnHeaderView(programmingcontentpanel);
		//카테고리1끝
		JPanel category2 = new JPanel();
		tabbedPane.addTab("3D디자인", null, category2, null);
		
		JScrollPane lecturecategory2ScrollPanel = new JScrollPane();
		lecturecategory2ScrollPanel.setPreferredSize(new Dimension(390, 780));
		category2.add(lecturecategory2ScrollPanel);
		
		designcontentpanel = new JPanel();
		designcontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT,7,7));
		designcontentpanel.setPreferredSize(new Dimension(390, 780));
		designcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lecturecategory2ScrollPanel.setColumnHeaderView(designcontentpanel);
		//카테고리2끝
		JPanel category3 = new JPanel();
		
		tabbedPane.addTab("사진/영상", null, category3, null);
		
		JScrollPane lecturecategory3ScrollPanel = new JScrollPane();
		lecturecategory3ScrollPanel.setPreferredSize(new Dimension(390, 780));
		category3.add(lecturecategory3ScrollPanel);
		
		photocontentpanel = new JPanel();
		photocontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT,7,7));
		photocontentpanel.setPreferredSize(new Dimension(390, 780));
		photocontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lecturecategory3ScrollPanel.setColumnHeaderView(photocontentpanel);
		//카테고리3끝
		
		JPanel userpanel = new JPanel();
		tabbedPane.addTab("", new ImageIcon("C:\\Users\\itwill\\Pictures\\user20.png"), userpanel, null);
		
		JScrollPane userScrollPane = new JScrollPane();
		userScrollPane.setPreferredSize(new Dimension(390, 780));
		userpanel.add(userScrollPane);
		
		JPanel orderContentpanel = new JPanel();
		userScrollPane.setColumnHeaderView(orderContentpanel);
		
		try {
			displayLectureprogrammingList();
			displayrecommendedList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	//996
	public void displayOrder() throws Exception{
		userPanel.removeAll();
		
	}
	//1638라인
	public void displayLectureprogrammingList() throws Exception{
		lectureService = new LectureService();
		if (programmingcontentpanel == null) {
            System.out.println("programmingcontentpanel is null");
            return;
        }
		List<Lecture> lectureList = lectureService.getlecturebyCategoryNo(1);
		programmingcontentpanel.removeAll();
		Collections.shuffle(lectureList);
		
		for(Lecture lecture : lectureList) {
			JPanel lecturePanel = new JPanel();
			lecturePanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			lecturePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			lecturePanel.setBounds(new Rectangle(0, 0, 170, 190));
			lecturePanel.setMaximumSize(new Dimension(200, 200));
			lecturePanel.setMinimumSize(new Dimension(150, 150));
			lecturePanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lecturePanel.setBackground(Color.WHITE);
			lecturePanel.setBorder(null);
			lecturePanel.setPreferredSize(new Dimension(170, 190));
			lecturePanel.setLayout(null);
			
			
			JLabel lectureImageLabel = new JLabel("");
			lectureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

			lectureImageLabel
					.setIcon(new ImageIcon(LectureMainFrame.class.getResource("/images/" + lecture.getL_image())));
			lectureImageLabel.setBounds(3, 1, 162, 116);
			lecturePanel.add(lectureImageLabel);
			
			JLabel lectureDescLabel = new JLabel("<html><font size='3'>" + "강의 이름: " + lecture.getL_name() + "<br>"
					+ "가격: " + new DecimalFormat("#,###").format(lecture.getL_price()) + "<br>" + "설명: "
					+ lecture.getL_desc() + "</font></html>");

			lectureDescLabel.setVerticalAlignment(SwingConstants.TOP);
			lectureDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lectureDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lectureDescLabel.setBounds(12, 126, 132, 54);
			lecturePanel.add(lectureDescLabel);
			
			JButton lectureAddButton = new JButton("수강하기");
			lectureAddButton.addActionListener(new ActionListener() {
				private Lecture l = lecture;

				public void actionPerformed(ActionEvent e) {

					if (userid != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							order.create(userid, l.getL_no());
							JOptionPane.showMessageDialog(null, "장바구니에 제품이담겼습니다");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/*******************************************/

					} else {
						// 로그인안했을때
						/****************** 로그인다이알로그뛰우기 ***************/
						LoginDialog loginDialog;
						try {
							loginDialog = new LoginDialog();
							loginDialog.setLectureMainFrame(LectureMainFrame.this);
							loginDialog.setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}

				}
			});
			lectureAddButton.setBorder(null);
			lectureAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lectureAddButton.setOpaque(false);
			lectureAddButton.setBounds(12, 93, 97, 23);
			lecturePanel.add(lectureAddButton);
			
			
			programmingcontentpanel.add(lecturePanel);
			
		}
		programmingcontentpanel.revalidate();
	    programmingcontentpanel.repaint();
	}

	public void displayrecommendedList() throws Exception{
		lectureService = new LectureService();
		if (recommendedcontentpanel == null) {
            System.out.println("recommendedcontentpanel is null");
            return;
        }
			recommendedcontentpanel.removeAll();
		List<Lecture> lectureList = lectureService.lectureList();
		Collections.shuffle(lectureList);
		
		for(int i=0;i<lectureList.size();i++) {
			Lecture lecture = lectureList.get(i);
			JPanel lecturePanel = new JPanel();
			lecturePanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			lecturePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			lecturePanel.setBounds(new Rectangle(0, 0, 170, 190));
			lecturePanel.setMaximumSize(new Dimension(200, 200));
			lecturePanel.setMinimumSize(new Dimension(150, 150));
			lecturePanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lecturePanel.setBackground(Color.WHITE);
			lecturePanel.setBorder(null);
			lecturePanel.setSize(new Dimension(120, 120));
			lecturePanel.setPreferredSize(new Dimension(170, 190));
			lecturePanel.setLayout(null);
			
			
			JLabel lectureImageLabel = new JLabel("");
			lectureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

			lectureImageLabel
					.setIcon(new ImageIcon(LectureMainFrame.class.getResource("/images/" + lecture.getL_image())));
			lectureImageLabel.setBounds(3, 1, 162, 116);
			lecturePanel.add(lectureImageLabel);
			
			JLabel lectureDescLabel = new JLabel("<html><font size='3'>" + "강의 이름: " + lecture.getL_name() + "<br>"
					+ "가격: " + new DecimalFormat("#,###").format(lecture.getL_price()) + "<br>" + "설명: "
					+ lecture.getL_desc() + "</font></html>");

			lectureDescLabel.setVerticalAlignment(SwingConstants.TOP);
			lectureDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lectureDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lectureDescLabel.setBounds(12, 126, 132, 54);
			lecturePanel.add(lectureDescLabel);
			
			JButton lectureAddButton = new JButton("");
			lectureAddButton.addActionListener(new ActionListener() {
				private Lecture l = lecture;

				public void actionPerformed(ActionEvent e) {

					if (userid != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							order.create(userid, l.getL_no());
							JOptionPane.showMessageDialog(null, "장바구니에 제품이담겼습니다");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/*******************************************/

					} else {
						// 로그인안했을때
						/****************** 로그인다이알로그뛰우기 ***************/
						LoginDialog loginDialog;
						try {
							loginDialog = new LoginDialog();
							loginDialog.setLectureMainFrame(LectureMainFrame.this);
							loginDialog.setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}

				}
			});
			lectureAddButton.setBorder(null);
			lectureAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lectureAddButton.setOpaque(false);
			lectureAddButton.setBackground(Color.WHITE);
			lectureAddButton.setForeground(Color.WHITE);
			lectureAddButton.setBounds(12, 93, 97, 23);
			lecturePanel.add(lectureAddButton);
			
			
			recommendedcontentpanel.add(lecturePanel);
			
		}
		
	}
}
