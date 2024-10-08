/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author gwend
 */
public class Tetris extends javax.swing.JFrame {

    /**
     * Creates new form Tetris
     */
    public Tetris() {
        initComponents();
        board1.setChampScore(champScore);
        board1.setChampLevel(champLevel);
        board1.setChampLines(champLines);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board1 = new tetris.Board();
        champScore = new javax.swing.JLabel();
        champLevel = new javax.swing.JLabel();
        champLines = new javax.swing.JLabel();
        tetrisLabel = new javax.swing.JLabel();
        commands = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        linesLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        flecheGauche = new javax.swing.JLabel();
        flecheHaut = new javax.swing.JLabel();
        flecheDroite = new javax.swing.JLabel();
        flecheBas = new javax.swing.JLabel();
        spaceTitle = new javax.swing.JLabel();
        pTitle = new javax.swing.JLabel();
        rTitle = new javax.swing.JLabel();
        moveLeft = new javax.swing.JLabel();
        rotateTitle = new javax.swing.JLabel();
        moveRight = new javax.swing.JLabel();
        softDrop = new javax.swing.JLabel();
        hardDrop = new javax.swing.JLabel();
        pauseTitle = new javax.swing.JLabel();
        restartTitle = new javax.swing.JLabel();
        nextShapeTitle = new javax.swing.JLabel();
        preview1 = new tetris.Preview(board1.s);
        barer_menu = new javax.swing.JMenuBar();
        fichier = new javax.swing.JMenu();
        boutonQuitter = new javax.swing.JMenuItem();
        gameOptions = new javax.swing.JMenu();
        pauseMenuItem = new javax.swing.JMenuItem();
        restartMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        champScore.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        champScore.setText("0");

        champLevel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        champLevel.setText("0");

        champLines.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        champLines.setText("0");

        tetrisLabel.setFont(new java.awt.Font("Goudy Stout", 0, 36)); // NOI18N
        tetrisLabel.setForeground(new java.awt.Color(239, 141, 46));
        tetrisLabel.setText("TETRIS");

        commands.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        commands.setText("Commands");

        levelLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        levelLabel.setText("Level - ");

        linesLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        linesLabel.setText("Lines -");

        scoreLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        scoreLabel.setText("Score -");

        flecheGauche.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        flecheGauche.setText("←");

        flecheHaut.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        flecheHaut.setText("↑");

        flecheDroite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        flecheDroite.setText("→");

        flecheBas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        flecheBas.setText("↓");

        spaceTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spaceTitle.setText("Space");

        pTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pTitle.setText("P");

        rTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rTitle.setText("R");

        moveLeft.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        moveLeft.setText("Move left");

        rotateTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotateTitle.setText("Rotate");

        moveRight.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        moveRight.setText("Move right");

        softDrop.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        softDrop.setText("Soft Drop");

        hardDrop.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        hardDrop.setText("Hard Drop");

        pauseTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pauseTitle.setText("Pause");

        restartTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        restartTitle.setText("Restart");

        nextShapeTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nextShapeTitle.setText("Next");

        preview1.setBackground(new java.awt.Color(255, 255, 255));

        fichier.setText("File");

        boutonQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        boutonQuitter.setText("Exit");
        boutonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonQuitterActionPerformed(evt);
            }
        });
        fichier.add(boutonQuitter);

        barer_menu.add(fichier);

        gameOptions.setText("Game options");

        pauseMenuItem.setText("Pause");
        pauseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseMenuItemActionPerformed(evt);
            }
        });
        gameOptions.add(pauseMenuItem);

        restartMenuItem.setText("Restart");
        restartMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartMenuItemActionPerformed(evt);
            }
        });
        gameOptions.add(restartMenuItem);
        gameOptions.add(jSeparator1);

        barer_menu.add(gameOptions);

        setJMenuBar(barer_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreLabel)
                            .addComponent(linesLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(champScore, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(champLines, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(flecheGauche)
                                    .addComponent(spaceTitle)
                                    .addComponent(flecheBas)
                                    .addComponent(flecheDroite)
                                    .addComponent(flecheHaut)
                                    .addComponent(pTitle)
                                    .addComponent(rTitle))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(moveLeft)
                                    .addComponent(rotateTitle)
                                    .addComponent(softDrop)
                                    .addComponent(hardDrop)
                                    .addComponent(moveRight)
                                    .addComponent(pauseTitle)
                                    .addComponent(restartTitle))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(commands)
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(nextShapeTitle)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(preview1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tetrisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addComponent(board1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(levelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(champLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(champLevel)
                    .addComponent(levelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tetrisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(commands)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(flecheGauche)
                                    .addComponent(moveLeft))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rotateTitle)
                                    .addComponent(flecheHaut))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(flecheDroite)
                                    .addComponent(moveRight))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(softDrop, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(flecheBas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spaceTitle)
                                    .addComponent(hardDrop))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pauseTitle)
                                    .addComponent(pTitle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(restartTitle)
                                    .addComponent(rTitle)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(nextShapeTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(preview1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(linesLabel)
                            .addComponent(champLines))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scoreLabel)
                            .addComponent(champScore)))
                    .addComponent(board1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_boutonQuitterActionPerformed

    private void pauseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseMenuItemActionPerformed
        if (board1.gamePaused){
            board1.unpause();
        }
        else {
            board1.pause();
        }
    }//GEN-LAST:event_pauseMenuItemActionPerformed

    private void restartMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartMenuItemActionPerformed
        board1.restart();
    }//GEN-LAST:event_restartMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tetris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barer_menu;
    private tetris.Board board1;
    private javax.swing.JMenuItem boutonQuitter;
    private javax.swing.JLabel champLevel;
    private javax.swing.JLabel champLines;
    private javax.swing.JLabel champScore;
    private javax.swing.JLabel commands;
    private javax.swing.JMenu fichier;
    private javax.swing.JLabel flecheBas;
    private javax.swing.JLabel flecheDroite;
    private javax.swing.JLabel flecheGauche;
    private javax.swing.JLabel flecheHaut;
    private javax.swing.JMenu gameOptions;
    private javax.swing.JLabel hardDrop;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel linesLabel;
    private javax.swing.JLabel moveLeft;
    private javax.swing.JLabel moveRight;
    private javax.swing.JLabel nextShapeTitle;
    private javax.swing.JLabel pTitle;
    private javax.swing.JMenuItem pauseMenuItem;
    private javax.swing.JLabel pauseTitle;
    private tetris.Preview preview1;
    private javax.swing.JLabel rTitle;
    private javax.swing.JMenuItem restartMenuItem;
    private javax.swing.JLabel restartTitle;
    private javax.swing.JLabel rotateTitle;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel softDrop;
    private javax.swing.JLabel spaceTitle;
    private javax.swing.JLabel tetrisLabel;
    // End of variables declaration//GEN-END:variables
}
