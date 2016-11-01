/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gestino.cfdi;

/**
 *
 * @author developer
 */
public class Cancelacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String uuid = "71DE2CE3-2286-4D93-AFA4-DB0A26EE3218";
        WebCfdiConnection connect = new WebCfdiConnection();
        connect.setRfcEmisor("TUMG620310R95");
        String r = connect.cancelar(uuid);
        System.out.println(r);
    }
}
