/**
 * (c) 2014 uchicom
 */
package com.uchicom.zunda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.uchicom.zunda.action.AboutAction;
import com.uchicom.zunda.action.ConvertHexAction;
import com.uchicom.zunda.action.ConvertStringAction;
import com.uchicom.zunda.action.HelpAction;
import com.uchicom.zunda.util.ResourceUtil;

/**
 * メイン画面クラス.
 * 
 * @author Shigeki Uchiyama
 * 
 */
public class ZundaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea hexArea = new JTextArea();
	private JTextArea stringArea = new JTextArea();
	private JComboBox<String> codeTypeComboBox = new JComboBox<String>(
			ResourceUtil.getStrings(Constants.CHARSETS));

	/**
	 * コンストラクタ.
	 */
	public ZundaFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
	}

	/**
	 * コンポーネントの初期化.
	 */
	private void initComponents() {
		setTitle(ResourceUtil.getString(Constants.APPLICATION_TITLE) + " "
				+ ResourceUtil.getString(Constants.APPLICATION_VERSION));
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu(ResourceUtil.getString(Constants.MENU_NAME_HELP));
		JMenuItem menuItem = new JMenuItem(new HelpAction());
		menu.add(menuItem);
		menuItem = new JMenuItem(new AboutAction());
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		hexArea.setLineWrap(true);
		hexArea.setRows(10);
		stringArea.setLineWrap(true);
		stringArea.setRows(10);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(
				new JLabel(ResourceUtil.getString(Constants.LABEL_STRING)),
				BorderLayout.WEST);
		northPanel.add(new JLabel(ResourceUtil.getString(Constants.LABEL_HEX)),
				BorderLayout.EAST);
		JPanel northCenterPanel = new JPanel(new GridLayout(1, 3));
		northCenterPanel.add(new JButton(new ConvertHexAction(this)));
		northCenterPanel.add(codeTypeComboBox);
		northCenterPanel.add(new JButton(new ConvertStringAction(this)));

		northPanel.add(northCenterPanel, BorderLayout.CENTER);
		panel.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel(new GridLayout(1, 2));
		centerPanel.add(new JScrollPane(stringArea));
		centerPanel.add(new JScrollPane(hexArea));

		panel.add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(panel);

	}

	/**
	 * １６進数から文字列への変換.
	 */
	public void convertHex2String() {
		String hex = hexArea.getText().toUpperCase();
		if (hex.length() % 2 == 0) {
			stringArea.setBackground(Color.white);
			char[] chars = hex.toCharArray();
			byte[] bytes = new byte[chars.length / 2];
			for (int i = 0; i < chars.length; i++) {
				char ch = chars[i];
				int val = (int) ch;
				if (val >= '0' && val <= '9') {
					int val2 = val - '0';
					if (i % 2 == 0) {
						bytes[i / 2] |= val2 << 4;
					} else {
						bytes[i / 2] |= val2;
					}
				} else if (val >= 'A' && val <= 'F') {
					int val2 = val - 'A' + 10;
					if (i % 2 == 0) {
						bytes[i / 2] |= val2 << 4;
					} else {
						bytes[i / 2] |= val2;
					}
				} else {
					// エラー
					stringArea.setBackground(Color.red);
					return;

				}
				stringArea.setText(new String(bytes, Charset
						.forName((String) codeTypeComboBox.getSelectedItem())));
			}
		} else {
			stringArea.setBackground(Color.red);
		}
	}

	/**
	 * 文字列から１６進数への変換.
	 */
	public void convertString2Hex() {
		String string = stringArea.getText();
		byte[] bytes = string.getBytes(Charset
				.forName((String) codeTypeComboBox.getSelectedItem()));
		StringBuffer strBuff = new StringBuffer(bytes.length * 2);
		for (byte b : bytes) {
			strBuff.append(Integer.toHexString(0xFF & b));
		}
		hexArea.setText(strBuff.toString().toUpperCase());
	}
}
