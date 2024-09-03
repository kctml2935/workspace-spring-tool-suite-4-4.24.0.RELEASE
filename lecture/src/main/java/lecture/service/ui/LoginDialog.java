package lecture.service.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class LoginDialog extends JDialog {
	LectureMainFrame lectureMainFrame; 
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setLectureMainFrame(LectureMainFrame lectureMainFrame) {
		this.lectureMainFrame=lectureMainFrame;
	}
	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lectureMainFrame.setTitle("로그인성공");
				lectureMainFrame.getContentPane().setBackground(Color.blue);
				dispose();
			}
		});
		btnNewButton.setBounds(90, 139, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(274, 139, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(203, 45, 116, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(90, 48, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(90, 100, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 97, 116, 21);
		contentPanel.add(passwordField);
	}
}
