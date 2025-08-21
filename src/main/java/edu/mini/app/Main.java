package edu.mini.app;

import edu.mini.MainWindow.ui;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new ui().setVisible(true);
    });
  }
}

