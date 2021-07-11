
package model;

import javax.swing.JPanel;

/**
 *
 * @author Mateus
 */
public class GerenciadorJPanel {
    
    private JPanel container;
    private JPanel content;
    
    
    public GerenciadorJPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;  
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }
}
