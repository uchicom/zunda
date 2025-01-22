// (C) 2014 uchicom
package com.uchicom.zunda;

import javax.swing.SwingUtilities;

/**
 * メインクラス.
 *
 * @author Shigeki Uchiyama
 */
public class Main {

  /**
   * 実行時に呼び出されるmain
   *
   * @param args 引数
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          ZundaFrame frame = new ZundaFrame();
          frame.pack();
          frame.setVisible(true);
        });
  }
}
