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
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

import model.Cylinder;
import model.Timber;
import model.Wood;
import store.WoodDirectory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCylinder extends JDialog {
	private Cylinder object = null;
	public Cylinder getObject() {
		return object;
	}
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLength;
	private JTextField textFieldDiameter;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCylinder dialog = new DlgCylinder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCylinder() {
		setModal(true);
		setTitle("Cylinder Information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			textFieldLength = new JTextField();
			textFieldLength.setBorder(new TitledBorder(null, "Length, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldLength);
			textFieldLength.setColumns(10);
		}
		{
			textFieldDiameter = new JTextField();
			textFieldDiameter.setBorder(new TitledBorder(null, "Diameter, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldDiameter);
			textFieldDiameter.setColumns(10);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBorder(new TitledBorder(null, "Wood Selection", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			comboBox.setPreferredSize(new Dimension(250, 40));
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
		float diameter = Integer.parseInt(textFieldDiameter.getText());
		try {
			object = new Cylinder(wood ,length, diameter);
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
	public JTextField getTextFieldDiameter() {
		return textFieldDiameter;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
