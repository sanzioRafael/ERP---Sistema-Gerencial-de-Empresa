/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteEndereco;
import database.Conexao;
import database.VisaoEndereco;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class EnderecoEditView extends javax.swing.JDialog {

    /**
     * Creates new form EnderecoEditView
     */
    public EnderecoEditView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        ufLabel = new javax.swing.JLabel();
        cidadeLabel = new javax.swing.JLabel();
        bairroLabel = new javax.swing.JLabel();
        cepLabel = new javax.swing.JLabel();
        logradouroLabel = new javax.swing.JLabel();
        complementoLabel = new javax.swing.JLabel();
        cmbUf = new javax.swing.JComboBox();
        cidadeField = new javax.swing.JTextField();
        bairroField = new javax.swing.JTextField();
        cepField = new javax.swing.JTextField();
        logradouroField = new javax.swing.JTextField();
        complementoField = new javax.swing.JTextField();
        ConfirmarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cepPesquisaLabel = new javax.swing.JLabel();
        pesquisaCepField = new javax.swing.JTextField();
        pesquisarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ufLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ufLabel.setText("UF:");

        cidadeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cidadeLabel.setText("Cidade:");

        bairroLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bairroLabel.setText("Bairro:");

        cepLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cepLabel.setText("Cep:");

        logradouroLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logradouroLabel.setText("Logradouro:");

        complementoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        complementoLabel.setText("Complemento:");

        cmbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${registroAtualEndereco.uf}"), cmbUf, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${registroAtualEndereco.cidade}"), cidadeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${registroAtualEndereco.bairro}"), bairroField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${registroAtualEndereco.cep}"), cepField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${registroAtualEndereco.logradouro}"), logradouroField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${registroAtualEndereco.complemento}"), complementoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        ConfirmarButton.setText("Confirmar");
        ConfirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        cepPesquisaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cepPesquisaLabel.setText("Cep:");

        pesquisarButton.setText("Pesquisar");
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarButtonActionPerformed(evt);
            }
        });

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ufLabel)
                            .addComponent(cidadeLabel))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUf, 0, 454, Short.MAX_VALUE)
                            .addComponent(cidadeField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bairroLabel)
                            .addComponent(cepLabel)
                            .addComponent(logradouroLabel))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bairroField)
                            .addComponent(cepField)
                            .addComponent(logradouroField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(complementoLabel)
                        .addGap(34, 34, 34)
                        .addComponent(complementoField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 374, Short.MAX_VALUE)
                        .addComponent(cancelarButton)
                        .addGap(33, 33, 33)
                        .addComponent(ConfirmarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cepPesquisaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(pesquisaCepField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pesquisarButton)
                        .addGap(39, 39, 39)
                        .addComponent(limparButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cepPesquisaLabel)
                    .addComponent(pesquisaCepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarButton)
                    .addComponent(limparButton))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ufLabel)
                    .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeLabel)
                    .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroLabel)
                    .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cepLabel)
                    .addComponent(cepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logradouroLabel)
                    .addComponent(logradouroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complementoLabel)
                    .addComponent(complementoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmarButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        pesquisaCepField.setText("");
    }//GEN-LAST:event_limparButtonActionPerformed

    private void ConfirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarButtonActionPerformed
        if(verificaCampos()){
            setConfirmaEndereco(true);
            JOptionPane.showMessageDialog(this, "Cadastro Realizado com sucesso!!");
            setVisible(false);
        }else {
            JOptionPane.showMessageDialog(this, "Algum campo está vazio");
        }
    }//GEN-LAST:event_ConfirmarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        cepField.setText("");
        pesquisaCepField.setText("");
        cidadeField.setText("");
        bairroField.setText("");
        logradouroField.setText("");
        complementoField.setText("");
        setConfirmaEndereco(false);
        setVisible(false);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void pesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarButtonActionPerformed
        String campo = pesquisaCepField.getText();
        if(campo.length() == 8){
            List<VisaoEndereco> endereco = new Conexao().pesquisaCep(campo);
            for (int i = 0; i < endereco.size(); i++) {
                cmbUf.setSelectedItem(endereco.get(i).getUf());
                cidadeField.setText(endereco.get(i).getCidade());
                bairroField.setText(endereco.get(i).getBairro());
                cepField.setText(campo);
                logradouroField.setText(endereco.get(i).getEndereco());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cep Incompatível, o Cep deverá ter 8 caracteres");
        }
        
    }//GEN-LAST:event_pesquisarButtonActionPerformed
    
    public boolean verificaCampos(){

        if(!"".equals(cepField.getText()) && !"".equals(logradouroField.getText()) && !"".equals(bairroField.getText()) &&
           !"".equals(cidadeLabel.getText()) && !"".equals(complementoField.getText()))
            return true;
        else
            return false;
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnderecoEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EnderecoEditView dialog = new EnderecoEditView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmarButton;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField cepField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JLabel cepPesquisaLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JComboBox cmbUf;
    private javax.swing.JTextField complementoField;
    private javax.swing.JLabel complementoLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextField logradouroField;
    private javax.swing.JLabel logradouroLabel;
    private javax.swing.JTextField pesquisaCepField;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JLabel ufLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
        private ClienteEndereco registroAtualEndereco;

    /**
     * Get the value of registroAtualEndereco
     *
     * @return the value of registroAtualEndereco
     */
    public ClienteEndereco getRegistroAtualEndereco() {
        return registroAtualEndereco;
    }

    /**
     * Set the value of registroAtualEndereco
     *
     * @param registroAtualEndereco new value of registroAtualEndereco
     */
    public void setRegistroAtualEndereco(ClienteEndereco registroAtualEndereco) {
        ClienteEndereco oldClienteEndereco = this.registroAtualEndereco;
        this.registroAtualEndereco = registroAtualEndereco;
        propertyChangeSupport.firePropertyChange("registroAtualEndereco", oldClienteEndereco, registroAtualEndereco);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
        private boolean confirmaEndereco;

    /**
     * Get the value of confirmaEndereco
     *
     * @return the value of confirmaEndereco
     */
    public boolean isConfirmaEndereco() {
        return confirmaEndereco;
    }

    /**
     * Set the value of confirmaEndereco
     *
     * @param confirmaEndereco new value of confirmaEndereco
     */
    public void setConfirmaEndereco(boolean confirmaEndereco) {
        this.confirmaEndereco = confirmaEndereco;
    }

}