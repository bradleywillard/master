package org.bwillard.ccsf.course.cs211s.assn6.classmates;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControlPanel.java

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class ControlPanel extends JPanel
{
    public class LoadListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent evt)
        {
            String fileName;
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("."));
            jFileChooser.showOpenDialog(racePanel);
            fileName = jFileChooser.getSelectedFile().getPath();
            try
            {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
                Object object = objectInputStream.readObject();
                ArrayList carList = new ArrayList();
                if(object instanceof ArrayList)
                {
                    ArrayList arrayList = (ArrayList)object;
                    for(Iterator iterator = arrayList.iterator(); iterator.hasNext();)
                    {
                        Object innerObject = iterator.next();
                        if(innerObject instanceof Car)
                            carList.add((Car)innerObject);
                    }

                    racePanel.setCarList(carList);
                }
                objectInputStream.close();
                System.out.println((new StringBuilder(String.valueOf(fileName))).append(" is loaded.").toString());
            }
            catch(Exception exception)
            {
                System.out.println(exception);
                exception.printStackTrace();
            }
            raceButton.setEnabled(false);
            replayButton.setEnabled(true);
            slowMotionFactorList.setEnabled(true);
            saveButton.setEnabled(true);
            loadButton.setEnabled(true);
            return;
        }

        final ControlPanel this$0;

        public LoadListener()
        {
            this$0 = ControlPanel.this;
            super();
        }
    }

    public class RaceListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent evt)
        {
            raceButton.setEnabled(false);
            replayButton.setEnabled(false);
            slowMotionFactorList.setEnabled(false);
            saveButton.setEnabled(false);
            loadButton.setEnabled(false);
            winnerLabel.setText("");
            timer = new Timer(200, new TimerListener(null));
            timer.start();
            racePanel.startRace();
        }

        final ControlPanel this$0;

        public RaceListener()
        {
            this$0 = ControlPanel.this;
            super();
        }
    }

    public class ReplayListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent evt)
        {
            raceButton.setEnabled(false);
            replayButton.setEnabled(false);
            slowMotionFactorList.setEnabled(false);
            saveButton.setEnabled(false);
            loadButton.setEnabled(false);
            timer = new Timer(200, new TimerListener(null));
            timer.start();
            racePanel.replayRace();
        }

        final ControlPanel this$0;

        public ReplayListener()
        {
            this$0 = ControlPanel.this;
            super();
        }
    }

    public class SaveListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent evt)
        {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("."));
            jFileChooser.showSaveDialog(racePanel);
            String fileName = (new StringBuilder(String.valueOf(jFileChooser.getSelectedFile().getPath()))).append(".ser").toString();
            try
            {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
                objectOutputStream.writeObject(racePanel.getCarList());
                objectOutputStream.close();
                System.out.println((new StringBuilder(String.valueOf(fileName))).append(" is saved.").toString());
            }
            catch(IOException ioException)
            {
                System.out.println(ioException);
                ioException.printStackTrace();
            }
        }

        final ControlPanel this$0;

        public SaveListener()
        {
            this$0 = ControlPanel.this;
            super();
        }
    }

    public class SlowMotionFactorListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            racePanel.setSlowMotionFactor(slowMotionFactorList.getSelectedIndex());
        }

        final ControlPanel this$0;

        public SlowMotionFactorListener()
        {
            this$0 = ControlPanel.this;
            super();
        }
    }

    private class TimerListener
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            if(racePanel.checkAllCarsFinishLine())
            {
                timer.stop();
                raceButton.setEnabled(true);
                replayButton.setEnabled(true);
                slowMotionFactorList.setEnabled(true);
                saveButton.setEnabled(true);
                loadButton.setEnabled(true);
            }
            if(racePanel.getWinnerIndex() != -1)
                winnerLabel.setText((new StringBuilder("The winner is ")).append(racePanel.getWinnerName()).append('!').toString());
        }

        final ControlPanel this$0;

        private TimerListener()
        {
            this$0 = ControlPanel.this;
            super();
        }

        TimerListener(TimerListener timerlistener)
        {
            this();
        }
    }


    public ControlPanel()
    {
        setLayout(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel();
        raceButton = new JButton("Race!");
        buttonPanel.add(raceButton);
        raceButton.addActionListener(new RaceListener());
        replayButton = new JButton("Replay");
        replayButton.setEnabled(false);
        buttonPanel.add(replayButton);
        replayButton.addActionListener(new ReplayListener());
        slowMotionFactorList = new JComboBox();
        slowMotionFactorList.addItem("Slow-motion-factor replay:");
        slowMotionFactorList.addItem("1x (default replay speed)");
        slowMotionFactorList.addItem("replay 2x as slow");
        slowMotionFactorList.addItem("replay 3x as slow");
        slowMotionFactorList.addItem("replay 4x as slow");
        slowMotionFactorList.addItem("replay 5x as slow");
        slowMotionFactorList.addItem("replay 6x as slow");
        slowMotionFactorList.addItem("replay 7x as slow");
        slowMotionFactorList.addItem("replay 8x as slow");
        slowMotionFactorList.addItem("replay 9x as slow");
        slowMotionFactorList.addItem("replay 10x as slow");
        buttonPanel.add(slowMotionFactorList);
        slowMotionFactorList.addActionListener(new SlowMotionFactorListener());
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        buttonPanel.add(saveButton);
        saveButton.addActionListener(new SaveListener());
        loadButton = new JButton("Load");
        buttonPanel.add(loadButton);
        loadButton.addActionListener(new LoadListener());
        add(buttonPanel);
        JPanel labelPanel = new JPanel();
        winnerLabel = new JLabel("");
        labelPanel.add(winnerLabel);
        add(labelPanel);
    }

    public void setRacePanel(RacePanel racePanel)
    {
        this.racePanel = racePanel;
    }

    private static final long serialVersionUID = 0L;
    private JComboBox slowMotionFactorList;
    private JButton raceButton;
    private JButton replayButton;
    private JButton saveButton;
    private JButton loadButton;
    private JLabel winnerLabel;
    private RacePanel racePanel;
    private Timer timer;
    private static final int TIME_BETWEEN_REP = 200;









}
