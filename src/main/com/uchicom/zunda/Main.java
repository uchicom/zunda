/**
 * (c) 2014 uchicom
 */
package com.uchicom.zunda;

/**
 * メインクラス.
 * 
 * @author Shigeki Uchiyama
 * 
 */
public class Main {

	/**
	 * 実行時に呼び出されるmain
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ZundaFrame frame = new ZundaFrame();
		frame.pack();
		frame.setVisible(true);
	}
}
