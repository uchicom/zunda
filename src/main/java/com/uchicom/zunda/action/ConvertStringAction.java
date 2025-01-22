// (C) 2014 uchicom
package com.uchicom.zunda.action;

import com.uchicom.zunda.Constants;
import com.uchicom.zunda.ZundaFrame;
import com.uchicom.zunda.util.ResourceUtil;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * 文字列に変換するアクションクラス.
 *
 * @author Shigeki Uchiyama
 */
public class ConvertStringAction extends AbstractAction {

  /** */
  private static final long serialVersionUID = 1L;

  private ZundaFrame zundaFrame;

  /** アクションのコンストラクタ. */
  public ConvertStringAction(ZundaFrame zundaFrame) {
    this.zundaFrame = zundaFrame;
    putValue(NAME, ResourceUtil.getString(Constants.ACTION_NAME_CONVERT_STRING));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    zundaFrame.convertHex2String();
  }
}
