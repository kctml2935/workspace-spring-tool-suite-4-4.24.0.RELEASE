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
import lecture.service.order.Order;
import lecture.service.order.OrderDao;
import lecture.service.order.OrderItem;
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
import java.awt.Font;

public class LectureMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Userinfo loginUser = null;
	private OrderItem orderitem;
	private LectureService lectureService;
	private OrderService orderservice;
	private JPanel programmingcontentpanel;
	private JPanel photocontentpanel;
	private JPanel designcontentpanel;
	private JPanel orderContentpanel;
	private JPanel ordertitlepanel;
	private JPanel orderitempanel;
	private JPanel orderListpanel;
	private JPanel recommendedcontentpanel;
	private JLabel orderListLabel;
	
	
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
	public void loginProcess(Userinfo loginUser) throws Exception{
		this.loginUser=loginUser;
		setTitle(loginUser.getUsername());
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
                loginUser=null;
                JOptionPane.showMessageDialog(null, "로그아웃 하였습니다.");
                System.exit(0);
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
		lecturecategory1ScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		lecturecategory1ScrollPanel.setPreferredSize(new Dimension(390, 780));
		category1.add(lecturecategory1ScrollPanel);
		
		programmingcontentpanel = new JPanel();
		programmingcontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT,7,7));
		programmingcontentpanel.setPreferredSize(new Dimension(390, 900));
		programmingcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lecturecategory1ScrollPanel.setViewportView(programmingcontentpanel);
		//카테고리1끝
		JPanel category2 = new JPanel();
		tabbedPane.addTab("3D디자인", null, category2, null);
		
		JScrollPane lecturecategory2ScrollPanel = new JScrollPane();
		lecturecategory2ScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		lecturecategory2ScrollPanel.setPreferredSize(new Dimension(390, 780));
		category2.add(lecturecategory2ScrollPanel);
		
		designcontentpanel = new JPanel();
		designcontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT,7,7));
		designcontentpanel.setPreferredSize(new Dimension(390, 900));
		designcontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lecturecategory2ScrollPanel.setViewportView(designcontentpanel);
		//카테고리2끝
		JPanel category3 = new JPanel();
		
		tabbedPane.addTab("사진/영상", null, category3, null);
		
		JScrollPane lecturecategory3ScrollPanel = new JScrollPane();
		lecturecategory3ScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		lecturecategory3ScrollPanel.setPreferredSize(new Dimension(390, 780));
		category3.add(lecturecategory3ScrollPanel);
		
		photocontentpanel = new JPanel();
		photocontentpanel.setLayout(new FlowLayout(FlowLayout.LEFT,7,7));
		photocontentpanel.setPreferredSize(new Dimension(390, 900));
		photocontentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lecturecategory3ScrollPanel.setViewportView(photocontentpanel);
		//카테고리3끝
		
		JPanel userpanel = new JPanel();
		tabbedPane.addTab("", new ImageIcon("C:\\Users\\itwill\\Pictures\\user20.png"), userpanel, null);
		
		JScrollPane userScrollPane = new JScrollPane();
		userScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		userScrollPane.setPreferredSize(new Dimension(390, 900));
		userpanel.add(userScrollPane);
		
		orderContentpanel = new JPanel();
		orderContentpanel.setPreferredSize(new Dimension(390, 2000));
		orderContentpanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		userScrollPane.setViewportView(orderContentpanel);
		orderContentpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ordertitlepanel = new JPanel();
		ordertitlepanel.setPreferredSize(new Dimension(350, 60));
		orderContentpanel.add(ordertitlepanel);
		ordertitlepanel.setLayout(null);
		
		JLabel orderitemtitleLabel = new JLabel("주문번호");
		orderitemtitleLabel.setBounds(12, 10, 57, 15);
		ordertitlepanel.add(orderitemtitleLabel);
		
		JLabel orderitemnoLabel = new JLabel("");
		orderitemnoLabel.setBounds(31, 10, 57, 15);
		ordertitlepanel.add(orderitemnoLabel);
		
		JLabel totaltitleLabel = new JLabel("total");
		totaltitleLabel.setBounds(150, 10, 57, 15);
		ordertitlepanel.add(totaltitleLabel);
		
		JLabel totalpriceLabel = new JLabel("");
		totalpriceLabel.setBounds(191, 10, 57, 15);
		ordertitlepanel.add(totalpriceLabel);
		
		JButton orderitemdeleteButton = new JButton("");
		orderitemdeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//주문삭제
			}
		});
		orderitemdeleteButton.setBounds(260, 0, 90, 24);
		ordertitlepanel.add(orderitemdeleteButton);
		
		orderitempanel = new JPanel();
		orderitempanel.setPreferredSize(new Dimension(350, 80));
		orderContentpanel.add(orderitempanel);
		
		JLabel orderitemimageLabel = new JLabel("");
		orderitempanel.add(orderitemimageLabel);
		
		JLabel orderitemdescLabel = new JLabel("");
		orderitempanel.add(orderitemdescLabel);
		
		JLabel orderitemtotprice = new JLabel("0");
		orderitempanel.add(orderitemtotprice);
		
		JButton deleteButton = new JButton("");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton gotolectureButton = new JButton("");
		orderitempanel.add(gotolectureButton);
		orderitempanel.add(deleteButton);
		
		try {
			displayLectureprogrammingList();
			displayrecommendedList();
			designcontentprogrammingList();
			photocontentprogrammingList();
			//displayOrderList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	//996
	public void displayOrderList() throws Exception{
		orderservice = new OrderService();
		orderitem = new OrderItem();
		orderContentpanel.removeAll();
		orderListpanel = new JPanel();
		orderListpanel.setLayout(null);
		orderListpanel.setPreferredSize(new Dimension(350, 30));
		orderListpanel.setBorder(null);
		orderListpanel.setBackground(Color.WHITE);
		orderContentpanel.add(orderListpanel);
		orderListLabel = new JLabel("강의목록");
		orderListLabel.setForeground(Color.DARK_GRAY);
		orderListLabel.setFont(new Font("D2Coding", Font.BOLD, 22));
		orderListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderListLabel.setBounds(90, 0, 155, 30);
		orderListpanel.add(orderListLabel);
		
		List<Order> orderList = orderservice.orderitemList(loginUser.getUser_id());
		
		
		for (Order order : orderList) {
			JPanel ordertitlePanel = new JPanel();
			ordertitlePanel.setLayout(null);
			ordertitlePanel.setPreferredSize(new Dimension(350, 30));
			ordertitlePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			ordertitlePanel.setBackground(Color.LIGHT_GRAY);
			orderContentpanel.add(ordertitlePanel);
			
			JLabel orderitemtitleLabel = new JLabel("주문번호");
			orderitemtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			orderitemtitleLabel.setFont(new Font("D2Coding", Font.PLAIN, 11));
			orderitemtitleLabel.setBounds(12, 3, 56, 25);
			ordertitlePanel.add(orderitemtitleLabel);
			
			JLabel totaltitleLabel = new JLabel("Total:");
			totaltitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			totaltitleLabel.setFont(new Font("굴림", Font.BOLD, 11));
			totaltitleLabel.setBounds(130, 10, 57, 15);
			ordertitlePanel.add(totaltitleLabel);
			
			JLabel totalpriceLabel = new JLabel(new DecimalFormat("0,000").format(order.getOrder_price()));
			totalpriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			totalpriceLabel.setFont(new Font("D2Coding", Font.BOLD, 13));
			totalpriceLabel.setBounds(180, 10, 57, 15);
			ordertitlePanel.add(totalpriceLabel);
			
			
			JLabel orderitemnoLabel = new JLabel(order.getOrder_no()+"");
			orderitemnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			orderitemnoLabel.setFont(new Font("굴림", Font.PLAIN, 11));
			orderitemnoLabel.setBounds(100, 3, 28, 26);
			ordertitlePanel.add(orderitemnoLabel);
		
			JButton orderItemDeleteButton = new JButton("강의삭제");
			orderItemDeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			orderItemDeleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/***************주문삭제**************/
					try {
						orderservice.deleteByOrderNo(order.getOrder_no());
						displayOrderList();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			orderItemDeleteButton.setBorder(null);
			orderItemDeleteButton.setBackground(Color.WHITE);
			orderItemDeleteButton.setBounds(250, 10, 90, 24);
			ordertitlePanel.add(orderItemDeleteButton);
			/**********order item start************/
			for(OrderItem orderItem: order.getOrderItemList()) {
				
				JPanel orderitempanel = new JPanel();
				orderitempanel.setLayout(null);
				orderitempanel.setPreferredSize(new Dimension(350, 50));
				orderitempanel.setBorder(null);
				orderitempanel.setBackground(Color.WHITE);
				
				JLabel orderitemimageLabel = new JLabel("");
				orderitemimageLabel.setIcon(new ImageIcon(LectureMainFrame.class.getResource("/images/"+orderItem.getLecture().getL_image())));
				orderitemimageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
				orderitemimageLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
				orderitemimageLabel.setHorizontalAlignment(SwingConstants.CENTER);
				orderitemimageLabel.setBounds(25, 7, 50, 40);
				orderitempanel.add(orderitemimageLabel);
				
				JLabel orderitemdescLabel = new JLabel("<html><b>"+orderItem.getLecture().getL_name()+"</b> <br/> ");
				orderitemdescLabel.setHorizontalAlignment(SwingConstants.CENTER);
				orderitemdescLabel.setFont(new Font("D2Coding", Font.PLAIN, 13));
				orderitemdescLabel.setBounds(67, 7, 100, 40);
				orderitempanel.add(orderitemdescLabel);
				
				JLabel orderitemtotprice = new JLabel("￦ "+new DecimalFormat("0,000").format(orderItem.getLecture().getL_price()));
				orderitemtotprice.setHorizontalAlignment(SwingConstants.LEFT);
				orderitemtotprice.setFont(new Font("D2Coding", Font.PLAIN, 13));
				orderitemtotprice.setBounds(159, 7, 91, 41);
				orderitempanel.add(orderitemtotprice);
				
				JButton gotolectureButton = new JButton("수강");
				gotolectureButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				gotolectureButton.setBorder(null);
				gotolectureButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				gotolectureButton.setOpaque(false);
				gotolectureButton.setBounds(230, 7, 47, 40);
				
				orderitempanel.add(gotolectureButton);
				
				JButton deleteButton = new JButton("삭제");
				deleteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							orderservice.delete(loginUser.getUser_id());
							JOptionPane.showMessageDialog(null, "강의가 삭제되었습니다.");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				deleteButton.setBorder(null);
				deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				deleteButton.setOpaque(false);
				deleteButton.setBounds(300, 7, 47, 40);
				orderitempanel.add(deleteButton);
				
				orderContentpanel.add(orderitempanel);
			}
			
		
		}
	}
	//1638라인
	public void displayLectureprogrammingList() throws Exception{
		orderservice = new OrderService();
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

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							orderservice.create(loginUser.getUser_id(), l.getL_no());
							JOptionPane.showMessageDialog(null, "내 강의장에 제품이담겼습니다");

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
		orderservice = new OrderService();
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
			
			JButton lectureAddButton = new JButton("수강하기");
			lectureAddButton.addActionListener(new ActionListener() {
				private Lecture l = lecture;

				public void actionPerformed(ActionEvent e) {

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							orderservice.create(loginUser.getUser_id(), l.getL_no());
							JOptionPane.showMessageDialog(null, "내 강의장에 제품이담겼습니다");

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
			
			
			recommendedcontentpanel.add(lecturePanel);
			
		}
		
	}
	public void designcontentprogrammingList() throws Exception{
		orderservice = new OrderService();
		lectureService = new LectureService();
		if (designcontentpanel == null) {
            System.out.println("designcontentpanel is null");
            return;
        }
		List<Lecture> lectureList = lectureService.getlecturebyCategoryNo(2);
		designcontentpanel.removeAll();
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

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							orderservice.create(loginUser.getUser_id(), l.getL_no());
							JOptionPane.showMessageDialog(null, "내 강의장에 제품이담겼습니다");

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
			
			
			designcontentpanel.add(lecturePanel);
			
		}
		designcontentpanel.revalidate();
		designcontentpanel.repaint();
	}
	public void photocontentprogrammingList() throws Exception{
		orderservice = new OrderService();
		loginUser = new Userinfo();
		lectureService = new LectureService();
		if (photocontentpanel == null) {
            System.out.println("photocontentpanel is null");
            return;
        }
		List<Lecture> lectureList = lectureService.getlecturebyCategoryNo(3);
		photocontentpanel.removeAll();
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

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							orderservice.create(loginUser.getUser_id(), l.getL_no());
							JOptionPane.showMessageDialog(null, "내 강의장에 제품이담겼습니다");

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
			
			
			photocontentpanel.add(lecturePanel);
			
		}
		photocontentpanel.revalidate();
		photocontentpanel.repaint();
	}
}
