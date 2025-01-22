// (C) 2014 uchicom
package com.uchicom.zunda.action;

import com.uchicom.zunda.Constants;
import com.uchicom.zunda.util.ResourceUtil;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.AbstractAction;

/**
 * このアプリケーションについてのアクションクラス.
 *
 * @author Shigeki Uchiyama
 */
public class AboutAction extends AbstractAction {

  /** */
  private static final long serialVersionUID = 1L;

  /** アクションのコンストラクタ. */
  public AboutAction() {
    putValue(NAME, ResourceUtil.getString(Constants.ACTION_NAME_ABOUT));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Desktop desktop = java.awt.Desktop.getDesktop();
    try {
      desktop.browse(new URI(ResourceUtil.getString(Constants.URL_ABOUT)));
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (URISyntaxException e1) {
      e1.printStackTrace();
    }
  }
}
