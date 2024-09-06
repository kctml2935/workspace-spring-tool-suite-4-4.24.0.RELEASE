/*package lecture.service.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class LectureDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtjavabasic;
	private JTextField txtjavabasic_1;
	private JTextField txtjavabasic_2;
	private JTextField txtjavabasic_3;
	private JTextField txtjavabasic_4;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			LectureDialog dialog = new LectureDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	/*
	public LectureDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(400, 780));
			contentPanel.add(scrollPane);
			{
				JPanel panel = new JPanel();
				panel.setPreferredSize(new Dimension(390, 780));
				scrollPane.setColumnHeaderView(panel);
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				JPanel panel_1 = new JPanel();
				panel_1.setPreferredSize(new Dimension(350, 60));
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JButton btnNewButton = new JButton("재생");
				btnNewButton.setBounds(241, 18, 97, 23);
				panel_1.add(btnNewButton);
				
				txtjavabasic = new JTextField();
				txtjavabasic.setText("01.JAVABASIC");
				txtjavabasic.setBounds(100, 19, 116, 21);
				panel_1.add(txtjavabasic);
				txtjavabasic.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(LectureDialog.class.getResource("/images/video.jpg")));
				lblNewLabel.setBounds(12, 5, 55, 55);
				panel_1.add(lblNewLabel);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setLayout(null);
					panel_2.setPreferredSize(new Dimension(350, 60));
					panel.add(panel_2);
					{
						JButton btnNewButton_1 = new JButton("재생");
						btnNewButton_1.setBounds(241, 18, 97, 23);
						panel_2.add(btnNewButton_1);
					}
					{
						txtjavabasic_1 = new JTextField();
						txtjavabasic_1.setText("02.JAVABASIC");
						txtjavabasic_1.setColumns(10);
						txtjavabasic_1.setBounds(100, 19, 116, 21);
						panel_2.add(txtjavabasic_1);
					}
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(LectureDialog.class.getResource("/images/video.jpg")));
						lblNewLabel_1.setBounds(12, 5, 55, 55);
						panel_2.add(lblNewLabel_1);
					}
				}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setLayout(null);
					panel_3.setPreferredSize(new Dimension(350, 60));
					panel.add(panel_3);
					{
						JButton btnNewButton_1 = new JButton("재생");
						btnNewButton_1.setBounds(241, 18, 97, 23);
						panel_3.add(btnNewButton_1);
					}
					{
						txtjavabasic_2 = new JTextField();
						txtjavabasic_2.setText("03.JAVABASIC");
						txtjavabasic_2.setColumns(10);
						txtjavabasic_2.setBounds(100, 19, 116, 21);
						panel_3.add(txtjavabasic_2);
					}
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(LectureDialog.class.getResource("/images/video.jpg")));
						lblNewLabel_1.setBounds(12, 5, 55, 55);
						panel_3.add(lblNewLabel_1);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setLayout(null);
					panel_2.setPreferredSize(new Dimension(350, 60));
					panel.add(panel_2);
					{
						JButton btnNewButton_1 = new JButton("재생");
						btnNewButton_1.setBounds(241, 18, 97, 23);
						panel_2.add(btnNewButton_1);
					}
					{
						txtjavabasic_3 = new JTextField();
						txtjavabasic_3.setText("04.JAVABASIC");
						txtjavabasic_3.setColumns(10);
						txtjavabasic_3.setBounds(100, 19, 116, 21);
						panel_2.add(txtjavabasic_3);
					}
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(LectureDialog.class.getResource("/images/video.jpg")));
						lblNewLabel_1.setBounds(12, 5, 55, 55);
						panel_2.add(lblNewLabel_1);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setLayout(null);
					panel_2.setPreferredSize(new Dimension(350, 60));
					panel.add(panel_2);
					{
						JButton btnNewButton_1 = new JButton("재생");
						btnNewButton_1.setBounds(241, 18, 97, 23);
						panel_2.add(btnNewButton_1);
					}
					{
						txtjavabasic_4 = new JTextField();
						txtjavabasic_4.setText("05.JAVABASIC");
						txtjavabasic_4.setColumns(10);
						txtjavabasic_4.setBounds(100, 19, 116, 21);
						panel_2.add(txtjavabasic_4);
					}
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(LectureDialog.class.getResource("/images/video.jpg")));
						lblNewLabel_1.setBounds(12, 5, 55, 55);
						panel_2.add(lblNewLabel_1);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}*/
