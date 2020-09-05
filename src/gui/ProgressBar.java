package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ProgressBar {
    public ProgressBar(){
        JProgressBar progress = new JProgressBar();
        JButton button = new JButton("Cancel");
        JFrame frame = new JFrame("Copying file..");
        frame.setLayout(new BorderLayout());
        frame.add(progress, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 100));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        startWorker(progress, button).execute();
        button.addActionListener(e -> {
        frame.dispose();
        });

    }
    private static SwingWorker<Void, Void> startWorker(JProgressBar progress, JButton button) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < 100 && !isCancelled(); i++) {
                    doWork();
                    setProgress(i);
                }
                return null;
            }

            @Override
            protected void done() {
                button.setText("Close");
                //progress.setValue(0);
            }
        };
        worker.addPropertyChangeListener(e -> {
            if ("progress".equals(e.getPropertyName())) {
                progress.setValue((Integer) e.getNewValue());
            }
        });
        return worker;
    }

    private static void doWork() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException ignored) {
        }
    }
}