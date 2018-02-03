/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security_gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static security_gui.Combination.DEcreption;
import static security_gui.Combination.Encrption;
import static security_gui.Playfair.createTable;
import static security_gui.Playfair.decode;
import static security_gui.Playfair.encode;
import static security_gui.Playfair.prepareText;

/**
 * FXML Controller class
 *
 * @author MUHAMMAD ASHRAF BAHY
 */
public class SecurityController implements Initializable {

    @FXML
    private TextField output;
    @FXML
    private TextField input;
    @FXML
    private Button combination_button;
    @FXML
    private Button playfair_btn;
    @FXML
    private Button hillcipher_btn;
    @FXML
    private Label choose_tech;
    @FXML
    private Label choose_hillciper;
    @FXML
    private Button triple;
    @FXML
    private Button bi;
    @FXML
    private TextField aa;
    @FXML
    private TextField ab;
    @FXML
    private TextField ac;
    @FXML
    private TextField ba;
    @FXML
    private TextField bb;
    @FXML
    private TextField bc;
    @FXML
    private TextField ca;
    @FXML
    private TextField cb;
    @FXML
    private TextField cc;
    @FXML
    private TextField playfair_key;
    @FXML
    private Button encrypt;
    @FXML
    private Button decrypt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void show_button(KeyEvent event) {
        encrypt.setDisable(false);
        decrypt.setDisable(false);
    }

    @FXML
    private void encr_combination(ActionEvent event) {
        choose_tech.setText("combination");
        playfair_key.setVisible(false);
        triple.setVisible(false);
        bi.setVisible(false);
        aa.setVisible(false);
        ab.setVisible(false);
        ac.setVisible(false);
        ba.setVisible(false);
        bb.setVisible(false);
        bc.setVisible(false);
        ca.setVisible(false);
        cb.setVisible(false);
        cc.setVisible(false);

    }

    @FXML
    private void encr_playfair(ActionEvent event) {
        choose_tech.setText("play fair");
        playfair_key.setVisible(true);
        triple.setVisible(false);
        bi.setVisible(false);
        aa.setVisible(false);
        ab.setVisible(false);
        ac.setVisible(false);
        ba.setVisible(false);
        bb.setVisible(false);
        bc.setVisible(false);
        ca.setVisible(false);
        cb.setVisible(false);
        cc.setVisible(false);
//        String txt = prompt(input.getText(), 1);

    }

    @FXML
    private void encr_hillcipher(ActionEvent event) {
        choose_tech.setText("hill cipher");
        triple.setVisible(true);
        bi.setVisible(true);

        playfair_key.setVisible(false);
    }

    @FXML
    private void Encrypt(ActionEvent event) {

        if (choose_tech.getText().equals("hill cipher")) {

            if (choose_hillciper.getText().equals("2x2")) {
                String str = input.getText();
                int aa_v = Integer.parseInt(aa.getText());
                int ab_v = Integer.parseInt(ab.getText());
                int ba_v = Integer.parseInt(ba.getText());
                int bb_v = Integer.parseInt(bb.getText());
                int[][] matrix = {{aa_v, ab_v}, {ba_v, bb_v}};
                HillCipher2x2 h2 = new HillCipher2x2();
                String r2 = h2.encrypt(str, matrix);
                output.setText(r2);
            } else if (choose_hillciper.getText().equals("3x3")) {
                String str = input.getText();
                int aa_v = Integer.parseInt(aa.getText());
                int ab_v = Integer.parseInt(ab.getText());
                int ac_v = Integer.parseInt(ac.getText());
                int ba_v = Integer.parseInt(ba.getText());
                int bb_v = Integer.parseInt(bb.getText());
                int bc_v = Integer.parseInt(bc.getText());
                int ca_v = Integer.parseInt(ca.getText());
                int cb_v = Integer.parseInt(cb.getText());
                int cc_v = Integer.parseInt(cc.getText());

                int[][] matrix = {{aa_v, ab_v, ac_v}, {ba_v, bb_v, bc_v}, {ca_v, cb_v, cc_v}};
                HillCipher3x3 h2 = new HillCipher3x3();
                String r2 = h2.encrypt(str, matrix);
                output.setText(r2);
            }

        } else if (choose_tech.getText().equals("play fair")) {
            Playfair pf = new Playfair();

            pf.createTable(playfair_key.getText());

            String enc = encode(prepareText(input.getText()));

            output.setText(enc);
        }else if(choose_tech.getText().equals("combination")){
            output.setText(Encrption(input.getText()));
        }
    }

    @FXML
    private void decrypt(ActionEvent event) {
          if (choose_tech.getText().equals("hill cipher")) {

            if (choose_hillciper.getText().equals("2x2")) {
                String str = input.getText();
                int aa_v = Integer.parseInt(aa.getText());
                int ab_v = Integer.parseInt(ab.getText());
                int ba_v = Integer.parseInt(ba.getText());
                int bb_v = Integer.parseInt(bb.getText());
                int[][] matrix = {{aa_v, ab_v}, {ba_v, bb_v}};
                HillCipher2x2 h2 = new HillCipher2x2();
                String r2 = h2.decrypt(str, matrix);
                output.setText(r2);
            } else if (choose_hillciper.getText().equals("3x3")) {
                String str = input.getText();
                int aa_v = Integer.parseInt(aa.getText());
                int ab_v = Integer.parseInt(ab.getText());
                int ac_v = Integer.parseInt(ac.getText());
                int ba_v = Integer.parseInt(ba.getText());
                int bb_v = Integer.parseInt(bb.getText());
                int bc_v = Integer.parseInt(bc.getText());
                int ca_v = Integer.parseInt(ca.getText());
                int cb_v = Integer.parseInt(cb.getText());
                int cc_v = Integer.parseInt(cc.getText());

                int[][] matrix = {{aa_v, ab_v, ac_v}, {ba_v, bb_v, bc_v}, {ca_v, cb_v, cc_v}};
                HillCipher3x3 h2 = new HillCipher3x3();
                String r2 = h2.decrypt(str, matrix);
                output.setText(r2);
            }

        } else if (choose_tech.getText().equals("play fair")) {
            Playfair pf = new Playfair();

            pf.createTable(playfair_key.getText());

            String enc = decode(prepareText(input.getText()));

            output.setText(enc);
        }else if(choose_tech.getText().equals("combination")){
            output.setText(DEcreption(input.getText()));
        }
    }

    @FXML
    private void show_triple(ActionEvent event) {
        choose_hillciper.setText("3x3");
        aa.setVisible(true);
        ab.setVisible(true);
        ac.setVisible(true);
        ba.setVisible(true);
        bb.setVisible(true);
        bc.setVisible(true);
        ca.setVisible(true);
        cb.setVisible(true);
        cc.setVisible(true);
    }

    @FXML
    private void show_bi(ActionEvent event) {
        choose_hillciper.setText("2x2");
        aa.setVisible(true);
        ab.setVisible(true);
        ac.setVisible(false);
        ba.setVisible(true);
        bb.setVisible(true);
        bc.setVisible(false);
        ca.setVisible(false);
        cb.setVisible(false);
        cc.setVisible(false);
    }

}
