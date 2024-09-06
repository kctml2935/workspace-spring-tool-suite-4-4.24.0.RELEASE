package lecture.service.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lecture.service.userinfo.UserService;
import lecture.service.userinfo.Userinfo;
import lecture.service.userinfo.UserinfoDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class joinDialog extends JDialog {
	LoginDialog logindialog;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField useridField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel userjoinMsgLabel;
	private UserService user;
	private UserinfoDao userinfoDao;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		try {
			joinDialog dialog = new joinDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/

	public void setLoginDialog(LoginDialog login) {
		this.logindialog=login;
	}
	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public joinDialog() throws Exception {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel useridLabel = new JLabel("아이디");
			useridLabel.setHorizontalAlignment(SwingConstants.CENTER);
			useridLabel.setBounds(81, 55, 57, 15);
			contentPanel.add(useridLabel);
		}
		{
			JLabel usernameLabel = new JLabel("이름");
			usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			usernameLabel.setBounds(81, 109, 57, 15);
			contentPanel.add(usernameLabel);
		}
		{
			JLabel passwordLabel = new JLabel("비밀번호");
			passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
			passwordLabel.setBounds(81, 150, 57, 15);
			contentPanel.add(passwordLabel);
		}
		{
			useridField = new JTextField();
			useridField.setBounds(184, 52, 116, 21);
			contentPanel.add(useridField);
			useridField.setColumns(10);
		}
		{
			usernameField = new JTextField();
			usernameField.setBounds(184, 106, 116, 21);
			contentPanel.add(usernameField);
			usernameField.setColumns(10);
		}
		{
			passwordField = new JTextField();
			passwordField.setBounds(184, 147, 116, 21);
			contentPanel.add(passwordField);
			passwordField.setColumns(10);
		}
		
		JButton btnNewButton = new JButton("중복확인");
		user = new UserService();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = useridField.getText();
				try {
					if(user.isDuplicated(userid)) {
						JOptionPane.showMessageDialog(null, "이미 있는 아이디입니다");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다");
					e2.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(313, 51, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("가입하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userinfoDao = new UserinfoDao();
					String userid = useridField.getText();
					boolean isDuplicate = user.isDuplicated(userid);
					if(isDuplicate) {
						userjoinMsgLabel.setText("아이디가 사용중입니다");
						return;
					}
					String password = passwordField.getText();
					String name = usernameField.getText();
					Userinfo user = new Userinfo(userid, name, password);
					userinfoDao.insert(user);
					dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_1.setBounds(152, 190, 148, 33);
		contentPanel.add(btnNewButton_1);
		{
			JLabel userjoinMsgLabel = new JLabel("");
			userjoinMsgLabel.setBounds(208, 83, 57, 15);
			contentPanel.add(userjoinMsgLabel);
		}
	}
}

