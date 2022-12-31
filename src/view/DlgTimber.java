package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import model.Timber;
import model.Wood;
import store.WoodDirectory;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTimber extends JDialog {
	
	private Timber object = null;
	public Timber getObject() {
		return object;
	}
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLength;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTimber dialog = new DlgTimber();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTimber() {
		setModal(true);
		setTitle("Timbler Information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			textFieldLength = new JTextField();
			textFieldLength.setBorder(new TitledBorder(null, "Length, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldLength);
			textFieldLength.setColumns(10);
		}
		{
			textFieldHeight = new JTextField();
			textFieldHeight.setBorder(new TitledBorder(null, "Height, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			textFieldWidth = new JTextField();
			textFieldWidth.setBorder(new TitledBorder(null, "Width, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			comboBox = new JComboBox();
			comboBox.setPreferredSize(new Dimension(250, 40));
			comboBox.setMaximumRowCount(15);
			comboBox.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Wood Selection", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setWoodDirectory(WoodDirectory wd) {
		ComboBoxModel<Object> model = 
				new DefaultComboBoxModel<>(wd.getArr());
		comboBox.setModel(model);
		
	}
	protected void onCancel() {
		object = null;
		this.setVisible(false);
	}

	protected void onOk() {
		// TODO Auto-generated method stub
		Wood wood = (Wood) comboBox.getSelectedItem();
		float length = Integer.parseInt(textFieldLength.getText());
		float height = Integer.parseInt(textFieldHeight.getText());
		float width = Integer.parseInt(textFieldWidth.getText());
		try {
			object = new Timber(wood ,length, height, width);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);
					object=null;
		}
		this.setVisible(false);
	}
	public JTextField getTextFieldLength() {
		return textFieldLength;
	}
	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}
	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
