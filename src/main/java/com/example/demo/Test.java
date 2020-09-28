package com.example.demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/20/17:05
 * @Description:
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class Test {
    JFrame frame;
    JTextPane textPane;

    public Test() {
        frame = new JFrame("JTextPane");
        textPane = new JTextPane();
    }

    public void insert(String str, AttributeSet attrSet) {
        Document doc = textPane.getDocument();
        str = "\n" + str;
        try {
            doc.insertString(doc.getLength(), str, attrSet);
        } catch (BadLocationException e) {
            System.out.println("BadLocationException:   " + e);
        }
    }

    public void setDocs(String str, Color col, boolean bold, int fontSize) {
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, col);
        //颜色
        if (bold == true) {
            StyleConstants.setBold(attrSet, true);
        }//字体类型
        StyleConstants.setFontSize(attrSet, fontSize);
        //字体大小
        insert(str, attrSet);
    }

    public void gui() {
        //textPane.insertIcon(image);
        setDocs("第一行的文字", Color.red, false, 20);
        setDocs("第二行的文字", Color.BLACK, true, 25);
        setDocs("第三行的文字", Color.BLUE, false, 20);

        frame.getContentPane().add(textPane, BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(200, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("JTextPane");
        JTextPane textPane=new JTextPane();
        //颜色
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, Color.red);
        StyleConstants.setFontSize(attrSet, 20);
        Document doc = textPane.getDocument();

        String s = "\n" + "第一行的文字";
        try {
            doc.insertString(doc.getLength(), s, attrSet);
        } catch (BadLocationException e) {
            System.out.println("BadLocationException:   " + e);
        }

        frame.getContentPane().add(textPane, BorderLayout.CENTER);
       frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(200, 300);
        frame.setVisible(true);
    }
}
