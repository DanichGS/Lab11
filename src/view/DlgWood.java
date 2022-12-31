package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Wood;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgWood extends JDialog {
	
	private Wood object = null;
	public Wood getObject() {
		return object;
	}
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldDensity;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgWood dialog = new DlgWood();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgWood() {
		setModal(true);
		setTitle("Wood Information");
		setBounds(100, 100, 447, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			textFieldId = new JTextField();
			textFieldId.setBorder(new TitledBorder(null, "id", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldId);
			textFieldId.setColumns(10);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldName);
			textFieldName.setColumns(25);
		}
		{
			textFieldDensity = new JTextField();
			textFieldDensity.setBorder(new TitledBorder(null, "Density, kg/m3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(textFieldDensity);
			textFieldDensity.setColumns(30);
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

	protected void onCancel() {
		object = null;
		this.setVisible(false);
	}

	protected void onOk() {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(textFieldId.getText());
		String name = textFieldName.getText();
		float density = Float.parseFloat(textFieldDensity.getText());
		object = new Wood(id, name, density);
		this.setVisible(false);
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}
	public JTextField getTextFieldName() {
		return textFieldName;
	}
	public JTextField getTextFieldDensity() {
		return textFieldDensity;
	}
}
