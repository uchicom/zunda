/**
 * (c) 2014 uchicom
 */
package com.uchicom.zunda.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.uchicom.zunda.Constants;
import com.uchicom.zunda.ZundaFrame;
import com.uchicom.zunda.util.ResourceUtil;

/**
 * １６進数に変換するアクションクラス.
 * 
 * @author Shigeki Uchiyama
 * 
 */
public class ConvertHexAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ZundaFrame zundaFrame;

	/**
	 * アクションのコンストラクタ.
	 */
	public ConvertHexAction(ZundaFrame zundaFrame) {
		this.zundaFrame = zundaFrame;
		putValue(NAME,
				ResourceUtil.getString(Constants.ACTION_NAME_CONVERT_HEX));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		zundaFrame.convertString2Hex();
	}

}
